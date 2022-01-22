package web.mvc.task.depository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	/*
	public static void main(String[] args) {
		System.out.println("產生資料庫");
	}
	*/
	
	@Override
	public Integer create(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readAll() {
		List<Task> tasks = new ArrayList<>();
		String sql = "select id, name, work, eat, commute, entertainment, sleep from Task";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				// 建立 task 物件並將資料表欄位資訊注入
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setWork(rs.getInt("work"));
				task.setEat(rs.getInt("eat"));
				task.setCommute(rs.getInt("commute"));
				task.setEntertainment(rs.getInt("entertainment"));
				task.setSleep(rs.getInt("sleep"));
				// 將 task 物件加入到 tasks 集合中
				tasks.add(task);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return tasks;
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
