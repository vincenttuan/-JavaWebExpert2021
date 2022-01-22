package web.mvc.task.service;

import java.util.List;

import web.mvc.task.depository.TaskDao;
import web.mvc.task.depository.TaskDaoImpl;
import web.mvc.task.model.Task;

public class TaskServiceImpl implements TaskService {
	private TaskDao taskDao = new TaskDaoImpl();
	
	@Override
	public Integer add(String name, Integer work, Integer eat, Integer commute, Integer entertainment, Integer sleep) {
		Task task = new Task();
		task.setName(name);
		task.setWork(work);
		task.setEat(eat);
		task.setCommute(commute);
		task.setEntertainment(entertainment);
		task.setSleep(sleep);
		int rowcount = taskDao.create(task);
		return rowcount;
	}

	@Override
	public Integer add(String name, String work, String eat, String commute, String entertainment, String sleep) {
		int rowcount = add(name, Integer.parseInt(work), 
								 Integer.parseInt(eat), 
								 Integer.parseInt(commute), 
								 Integer.parseInt(entertainment), 
								 Integer.parseInt(sleep));
		return rowcount;
	}

	@Override
	public Integer update(Integer id, String name, Integer work, Integer eat, Integer commute, Integer entertainment,
			Integer sleep) {
		Task task = new Task();
		task.setName(name);
		task.setWork(work);
		task.setEat(eat);
		task.setCommute(commute);
		task.setEntertainment(entertainment);
		task.setSleep(sleep);
		int rowcount = taskDao.update(id, task);
		return rowcount;
	}

	@Override
	public Integer update(String id, String name, String work, String eat, String commute, String entertainment, String sleep) {
		int rowcount = update(Integer.parseInt(id), 
							  name, 
							  Integer.parseInt(work), 
							  Integer.parseInt(eat), 
							  Integer.parseInt(commute), 
							  Integer.parseInt(entertainment), 
							  Integer.parseInt(sleep));
		return rowcount;
	}

	@Override
	public Integer delete(Integer id) {
		return taskDao.delete(id);
	}

	@Override
	public Integer delete(String id) {
		return delete(Integer.parseInt(id));
	}

	@Override
	public List<Task> queryAll() {
		return taskDao.readAll();
	}

	@Override
	public Task getOne(Integer id) {
		return taskDao.readById(id);
	}

	@Override
	public Task getOne(String id) {
		return getOne(Integer.parseInt(id));
	}

	

}
