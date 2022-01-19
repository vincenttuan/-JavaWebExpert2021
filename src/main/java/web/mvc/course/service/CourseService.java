package web.mvc.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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

	// 全部查詢
	@Override
	public List<Course> queryAll() {
		return courses;
	}

	// 新增
	@Override
	public int add(Course course) {
		if (isIdExists(course.getId())) {
			System.out.printf("CourseService.add() -> id: %d 已存在", course.getId());
			return 0; // 0:失敗
		}
		courses.add(course);
		return 1; // 1:成功
	}

	// 單筆查詢：根據 id 來取得 student 物件
	@Override
	public Optional<Course> getById(Integer id) {
		// parallel 平行查詢/多核心同步運算
		return courses.stream().parallel().filter(s -> s.getId().intValue() == id.intValue()).findAny();
	}

	// 修改
	@Override
	public int update(Course newCourse) {
		// 驗證是否根據 id 值有此課程 ?
		Optional<Course> optCourse = getById(newCourse.getId());
		if (optCourse.isPresent()) {
			// 注意：isPresent() 得到 true, 才可以使用 get() 得到 Course 物件
			Course originalCourse = optCourse.get();
			// 找到 originalCourse 在 courses 列表中的位置
			int idx = IntStream.range(0, courses.size())
					.filter(i -> courses.get(i).getId().intValue() == originalCourse.getId().intValue()).findFirst()
					.getAsInt();
			// 原位置idx的元素被新元素newCourse取代
			courses.set(idx, newCourse); // 原位置idx的元素被新元素newCourse取代
			return 1;
		}
		System.out.printf("CourseService.update() -> 無此代號: %d 的課程\n", newCourse.getId());
		return 0;
	}
	
	// 刪除
	@Override
	public int deleteById(Integer id) {
		// 驗證是否根據 id 值有此課程
		Optional<Course> optCourse = getById(id);
		if(optCourse.isPresent()) {
			Course originalCourse = optCourse.get();
			courses.remove(originalCourse); // 移除
			return 1;
		}
		System.out.printf("CourseService.deleteById() -> 無此代號: %d 的課程\n", id);
		return 0;
	}
	
	// 判斷 id 是否存在 ?
	@Override
	public boolean isIdExists(Integer id) {
		return courses.stream().parallel().filter(s -> s.getId() == id).findAny().isPresent();
	}

}
