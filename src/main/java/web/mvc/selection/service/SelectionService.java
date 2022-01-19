package web.mvc.selection.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import web.mvc.course.model.Course;
import web.mvc.course.service.CourseService;
import web.mvc.selection.model.Selection;
import web.mvc.student.model.Student;

public class SelectionService {
	
	private static List<Selection> selections;
	private CourseService courseService = new CourseService();
	static {
		selections = new ArrayList<>();
	}
	
	public List<Selection> queryAll() {
		return selections;
	}
	
	public void addOrUpdate(Integer studentId, List<Integer> course_ids) {
		Optional<Selection> optSelection = selections.stream()
				.filter(s -> s.getStudentId().intValue() == studentId.intValue())
				.findAny();
		if(optSelection.isPresent()) {
			// 先移除
			selections.remove(optSelection.get());
		}
		// 新增
		Selection selection = new Selection();
		selection.setStudentId(studentId);
		for(Integer course_id : course_ids) {
			Course course = courseService.getById(course_id).get();
			selection.addCourse(course);
		}
	}
	
}
