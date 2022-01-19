package web.mvc.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import web.mvc.course.model.Course;
import web.mvc.spec.IService;

public class CourseService implements IService<Course> {
	private static List<Course> courses;
	static { // 類別資源初始資料實作區
		courses = new ArrayList<>();
		courses.add(new Course(1001, "程式語言", 3));
		courses.add(new Course(2001, "企業管理", 2));
		courses.add(new Course(3001, "統計學", 3));
		courses.add(new Course(4001, "商用英文", 1));
		courses.add(new Course(5001, "資料庫", 3));
	}
	
	@Override
	public List<Course> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Course t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Course> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Course t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isIdExists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
