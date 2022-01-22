package web.mvc.task.depository;

import java.util.List;

import web.mvc.task.model.Task;

// Dao: Data access object
// CRUD: create、read、update、delete
public interface TaskDao {
	// 新增
	Integer create(Task task);
	// 查詢全部
	List<Task> readAll();
	// 查詢單筆
	Task readById(Integer id);
	// 修改
	Integer update(Integer id, Task newTask);
	// 刪除
	Integer delete(Integer id);
}
