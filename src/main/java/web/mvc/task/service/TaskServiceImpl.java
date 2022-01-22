package web.mvc.task.service;

import java.util.List;

import web.mvc.task.depository.TaskDao;
import web.mvc.task.depository.TaskDaoImpl;
import web.mvc.task.model.Task;

public class TaskServiceImpl implements TaskService {
	TaskDao taskDao = new TaskDaoImpl();
	
	@Override
	public Integer add(String name, Integer work, Integer eat, Integer commute, Integer entertainment, Integer sleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(String name, String work, String eat, String commute, String entertainment, String sleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Integer id, String name, Integer work, Integer eat, Integer commute, Integer entertainment,
			Integer sleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(String id, String name, String work, String eat, String commute, String entertainment,
			String sleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> queryAll() {
		return taskDao.readAll();
	}

	@Override
	public Task getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
