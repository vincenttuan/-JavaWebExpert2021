package web.mvc.task.depository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import web.mvc.task.model.Task;

public class TaskDaoImpl implements TaskDao {
	private static final String DB_PATH = "/Users/vincenttuan/eclipse-workspace-javaexpert/web/src/main/java/web/mvc/task/depository";
	private static final String DB_NAME = "/database.db";
	private static Connection conn;
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			String fullPath = DB_PATH + DB_NAME;
			conn = DriverManager.getConnection("jdbc:sqlite:" + fullPath);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Integer create(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Integer id, Task newTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
