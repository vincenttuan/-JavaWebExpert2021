package web.mvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	// 根據 id 來取得 student 物件
	public Optional<Student> getById(Integer id) {
		// parallel 平行查詢/多核心同步運算
		return students.stream().parallel().filter(s -> s.getId() == id).findAny();
	}
	
	// 修改 student
	public int update(Student newStudent) {
		// 驗證是否根據 id 值有此學生 ?
		Optional<Student> optStudent = getById(newStudent.getId());
		if(optStudent.isPresent()) {
			// 注意：isPresent() 得到 true, 才可以使用 get() 得到 Student 物件
			Student originalStudent = optStudent.get();
			originalStudent = newStudent; // 修改(替換)
			return 1;
		}
		System.out.printf("update() -> 無此學號: %d 的學生\n", newStudent.getId());
		return 0;
	}
	
	// 刪除 student
	public int deleteById(Integer id) {
		// 驗證是否根據 id 值有此學生 ?
		Optional<Student> optStudent = getById(id);
		if(optStudent.isPresent()) {
			Student originalStudent = optStudent.get();
			students.remove(originalStudent); // 移除
			return 1;
		}
		System.out.printf("deleteById() -> 無此學號: %d 的學生\n", id);
		return 0;
	}
	
	// 判斷 id 是否存在 ?
	private boolean isIdExists(Integer id) {
		return students.stream().parallel().filter(s -> s.getId() == id).findAny().isPresent();
	}
	
}
