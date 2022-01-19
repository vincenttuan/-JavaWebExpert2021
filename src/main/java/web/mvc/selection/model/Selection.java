package web.mvc.selection.model;

import java.util.ArrayList;
import java.util.List;

import web.mvc.course.model.Course;

public class Selection {
	
	private Integer studentId;
	private List<Course> courses = new ArrayList<>();
	
	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}

	@Override
	public String toString() {
		return "Selection [studentId=" + studentId + ", courses=" + courses + "]";
	}
	
}
