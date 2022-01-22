package web.mvc.task.depository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	 * public static void main(String[] args) { System.out.println("產生資料庫"); }
	 */

	@Override
	public Integer create(Task task) {
		String sql = "INSERT INTO Task (name, 'work', eat, commute, entertainment, sleep) VALUES(?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, task.getName());
			pstmt.setInt(2, task.getWork());
			pstmt.setInt(3, task.getEat());
			pstmt.setInt(4, task.getCommute());
			pstmt.setInt(5, task.getEntertainment());
			pstmt.setInt(6, task.getSleep());
			int rowcount = pstmt.executeUpdate();
			return rowcount;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public List<Task> readAll() {
		List<Task> tasks = new ArrayList<>();
		String sql = "select id, name, work, eat, commute, entertainment, sleep from Task";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
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
		String sql = "select id, name, work, eat, commute, entertainment, sleep from Task where id=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 建立 task 物件並將資料表欄位資訊注入
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setWork(rs.getInt("work"));
				task.setEat(rs.getInt("eat"));
				task.setCommute(rs.getInt("commute"));
				task.setEntertainment(rs.getInt("entertainment"));
				task.setSleep(rs.getInt("sleep"));
				return task;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Integer update(Integer id, Task newTask) {
		String sql = "Update Task set name=?, 'work'=?, eat=?, commute=?, entertainment=?, sleep=? where id=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newTask.getName());
			pstmt.setInt(2, newTask.getWork());
			pstmt.setInt(3, newTask.getEat());
			pstmt.setInt(4, newTask.getCommute());
			pstmt.setInt(5, newTask.getEntertainment());
			pstmt.setInt(6, newTask.getSleep());
			pstmt.setInt(7, id);
			int rowcount = pstmt.executeUpdate();
			return rowcount;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public Integer delete(Integer id) {
		String sql = "delete from Task where id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			int rowcount = pstmt.executeUpdate();
			return rowcount;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}
