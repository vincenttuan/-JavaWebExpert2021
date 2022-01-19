package web.mvc.selection.model;

import java.util.Set;

import web.mvc.course.model.Course;

public class Selection {
	
	private Integer studentId;
	private Set<Course> courses;
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Selection [studentId=" + studentId + ", courses=" + courses + "]";
	}
	
}
