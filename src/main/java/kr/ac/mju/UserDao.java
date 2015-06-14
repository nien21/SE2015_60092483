package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.ac.mju.Constants;

import org.springframework.stereotype.Service;
@Service
public class UserDao {

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
	
	public boolean create(User user) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "insert into user values(?, ?, ?, ?)";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,  user.getID());
		preparedStatement.setString(2,  user.getpwd());
		preparedStatement.setString(3,  user.getName());
		preparedStatement.setString(4,  user.getType());

		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	
	public User checkId(String id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		String sql = "select *  from user where id = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next() ) {
			user = new User(resultSet.getString("id"), resultSet.getString("pwd"), resultSet.getString("name"), resultSet.getString("type"));
		}
		
		
		closeConnection(connection, preparedStatement, resultSet);
		return user;
	}
	
	public User checkIdPwd(String id, String pwd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		String sql = "select *  from user where id = ? and pwd = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, pwd);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next() ) {
			user = new User(resultSet.getString("id"), resultSet.getString("pwd"), resultSet.getString("name"), resultSet.getString("type"));
		}	
		closeConnection(connection, preparedStatement, resultSet);
		return user;
	}
	
	public Vector<User> read() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Vector<User> users = new Vector<User>();
		String sql = "select *  from user";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			users.add(new User(resultSet.getString("id"), resultSet.getString("pwd"), resultSet.getString("name"), resultSet.getString("type")));		
		}
		closeConnection(connection, preparedStatement, resultSet);
		return users;
		
	}
	public boolean update(User user) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "update user set name = ?, pwd = ?, type = ? where id = ?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,  user.getName());
		preparedStatement.setString(2,  user.getpwd());
		preparedStatement.setString(3,  user.getType());
		preparedStatement.setString(4,  user.getID());
		result = preparedStatement.executeUpdate();
		
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);	
	}
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		int result;
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "DELETE FROM user WHERE id=?";
	
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,  id);
		
		result = preparedStatement.executeUpdate();
		closeConnection(connection, preparedStatement, resultSet);
		return (result == 1);
	}
}
