package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.ac.mju.Lecture;
import kr.ac.mju.Constants;

import org.springframework.stereotype.Service;
@Service
public class SugangDAO {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Constants.DBMS.URL.getMsg(), Constants.DBMS.ID.getMsg(), Constants.DBMS.PASSWORD.getMsg());
	}
	
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(connection == null) {
			return;
		}
		if(connection != null) {try{connection.close();}catch(Exception e) {} }
		if(statement != null) {try{statement.close();}catch(Exception e) {} }
		if(resultSet != null) {try{resultSet.close();}catch(Exception e) {} }
	}
	
	public boolean create(Sugang sugang) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "insert into sugang(lectureId, studentName, professorName) values(?, ?, ?)";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,  sugang.getLectureID());
		preparedStatement.setString(2,  sugang.getStudentName());
		preparedStatement.setString(3,  sugang.getProfessorName());

		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	
	public Vector<Lecture> selectByStu(String studnetName) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Vector<Lecture> lectures = new Vector<Lecture>();
		
		String sql = "select id, name, lecture.professorName, year, grade, currentMaxnum, maxNum, credit, studentName,ifnull(sugang.result, 'unwritten') as result from lecture left join sugang on lecture.id = sugang.lectureid where sugang.studentname = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, studnetName);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			lectures.add(new Lecture(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("professorName"), resultSet.getInt("year"), resultSet.getInt("grade"), resultSet.getInt("maxNum"), resultSet.getInt("credit"), resultSet.getString("result")));
		}
		closeConnection(connection, preparedStatement, resultSet);
		return lectures;
	}
	
	public Vector<Sugang> selectByProf(String professorId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Vector<Sugang> sugangs = new Vector<Sugang>();
		
		String sql = "select lectureId, studentName, isnull(result, unwritten), professorName  from sugang where professorName = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, professorId);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			sugangs.add(new Sugang(resultSet.getInt("lectureId"), resultSet.getString("studentName"), resultSet.getString("professorName"), resultSet.getString("result")));		
		}
		closeConnection(connection, preparedStatement, resultSet);
		return sugangs;
	}
	
	public Vector<Sugang> selectByLecture(int lectureId, String professorName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Vector<Sugang> sugangs = new Vector<Sugang>();
		
		String sql = "select lectureId, studentName, ifnull(result, 'unwritten') as result , professorName  from sugang where lectureId = ? and professorName = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, lectureId);
		preparedStatement.setString(2, professorName);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			sugangs.add(new Sugang(resultSet.getInt("lectureId"), resultSet.getString("studentName"), resultSet.getString("professorName"), resultSet.getString("result")));		
		}
		closeConnection(connection, preparedStatement, resultSet);
		return sugangs;
	}
	
	public Sugang checkRegister(int lectureId, String professorName, String studentName) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Sugang sugang =null;
		String sql = "select * from sugang where lectureId = ? and professorName = ? and studentName = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, lectureId);
		preparedStatement.setString(2, professorName);
		preparedStatement.setString(3, studentName);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			sugang = new Sugang(resultSet.getInt("lectureId"), resultSet.getString("studentName"), resultSet.getString("professorName"));
		}
		closeConnection(connection, preparedStatement, resultSet);
		return sugang;
	}
	public Vector<Sugang> read() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Vector<Sugang> sugangs = new Vector<Sugang>();
		
		String sql = "select lectureId, studentName, isnull(result, unwritten), professorName  from sugang";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			sugangs.add(new Sugang(resultSet.getInt("lectureId"), resultSet.getString("studentName"), resultSet.getString("professorName"), resultSet.getString("result")));		
		}
		closeConnection(connection, preparedStatement, resultSet);
		return sugangs;
		
	}

	public boolean update(Sugang sugang) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "update sugang set result = ? where lectureId = ? and studentName = ? and professorName = ? ";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,  sugang.getResult());
		preparedStatement.setInt(2,  sugang.getLectureID());
		preparedStatement.setString(3,  sugang.getStudentName());
		preparedStatement.setString(4,  sugang.getProfessorName());

		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	public boolean delete(Sugang sugang) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "DELETE FROM user where lectureId = ? and studentName = ? and professorName = ? ";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,  sugang.getLectureID());
		preparedStatement.setString(2,  sugang.getStudentName());
		preparedStatement.setString(3,  sugang.getProfessorName());
		
		result = preparedStatement.executeUpdate();
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);
	}
}
