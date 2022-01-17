package web.mvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web.mvc.model.Student;

public class StudentService {
	private static List<Student> students;
	static { // 類別資源初始資料實作區
		students = new ArrayList<>();
		students.add(new Student(2022001, "John", 90, 1, new Date()));
		students.add(new Student(2022002, "Mary", 100, 2, new Date()));
		students.add(new Student(2022003, "Jo", 80, 2, new Date()));
	}
	
	public List<Student> queryAll() {
		return students;
	}
	
	public int add(Student student) {
		if(isIdExists(student.getId())) {
			System.out.printf("add() -> id: %d 已存在", student.getId());
			return 0; // 0:失敗
		}
		students.add(student);
		return 1; // 1:成功
	}
	
	// 判斷 id 是否存在 ?
	private boolean isIdExists(Integer id) {
		return students.stream().filter(s -> s.getId() == id).findAny().isPresent();
	}
	
}
