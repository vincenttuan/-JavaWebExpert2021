package web.mvc.task.service;

import java.util.List;

import web.mvc.task.model.Task;

public interface TaskService {
	
	Integer add(String name, Integer work, Integer eat, Integer commute, Integer entertainment, Integer sleep);
	Integer add(String name, String  work, String  eat, String  commute, String  entertainment, String  sleep);
	
	Integer update(Integer id, String name, Integer work, Integer eat, Integer commute, Integer entertainment, Integer sleep);
	Integer update(String  id, String name, String  work, String  eat, String  commute, String  entertainment, String  sleep);
	
	Integer delete(Integer id);
	Integer delete(String  id);
	
	List<Task> queryAll();
	
	Task getOne(Integer id);
	Task getOne(String  id);
	
}
