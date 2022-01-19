package web.mvc.course.service;

import java.util.List;
import java.util.Optional;

import web.mvc.course.model.Course;
import web.mvc.spec.IService;

public class CourseService implements IService<Course> {

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
