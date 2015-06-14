package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.springframework.stereotype.Service;


@Service
public class LectureDAO {
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
	
	public boolean create(Lecture lecture) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "insert into lecture(id, name, professorName, year, grade, maxNum, credit) values(?, ?, ?, ?, ?, ?, ?)";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,  lecture.getId());
		preparedStatement.setString(2, lecture.getName());
		preparedStatement.setString(3, lecture.getProfessorName());
		preparedStatement.setInt(4, lecture.getYear());
		preparedStatement.setInt(5, lecture.getGrade());
		preparedStatement.setInt(6, lecture.getMaxNum());
		preparedStatement.setInt(7, lecture.getCredit());
		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	
	public Vector<Lecture> read() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Vector<Lecture> lectures = new Vector<Lecture>();
		String sql = "select *  from lecture";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			lectures.add(new Lecture(
					resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("professorName"), resultSet.getInt("year"), resultSet.getInt("grade"), resultSet.getInt("currentMaxnum"), resultSet.getInt("maxNum"), resultSet.getInt("credit")));		
		}
		closeConnection(connection, preparedStatement, resultSet);
		return lectures;
		
	}
	public Vector<Lecture> searchByProf(String professorName) throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Vector<Lecture> lectures = new Vector<Lecture>();
		String sql = "select *  from lecture where professorName = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, professorName);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			lectures.add(new Lecture(
					resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("professorName"), resultSet.getInt("year"), resultSet.getInt("grade"), resultSet.getInt("currentMaxnum"), resultSet.getInt("maxNum"), resultSet.getInt("credit")));			
		}
		closeConnection(connection, preparedStatement, resultSet);
		return lectures;
		
	}
	public Lecture searchByLectureID(int lectureId) throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "select *  from lecture where id = ?";
		Lecture lecture = null;
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, lectureId);
		resultSet = preparedStatement.executeQuery();

		if(resultSet.next() ) {
			lecture = new Lecture(
					resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("professorName"), resultSet.getInt("year"), resultSet.getInt("grade"), resultSet.getInt("currentMaxnum"), resultSet.getInt("maxNum"), resultSet.getInt("credit"));
		}
		closeConnection(connection, preparedStatement, resultSet);
		return lecture;
		
	}
	public boolean update(int id) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "update lecture set currentMaxnum = currentMaxnum +1 where id = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "DELETE FROM lecture WHERE id=?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,  id);
		
		result = preparedStatement.executeUpdate();
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);
	}
}
