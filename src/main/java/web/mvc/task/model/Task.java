package web.mvc.task.model;

public class Task {
	private Integer id; // 序號
	private String  name; // 使用者名稱
	//  以下5個欄位加起來必須是 = 24H
	private Integer work; // hours per day
	private Integer eat; // hours per day
	private Integer commute; // hours per day
	private Integer entertainment; // hours per day
	private Integer sleep; // hours per day
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getWork() {
		return work;
	}


	public void setWork(Integer work) {
		this.work = work;
	}


	public Integer getEat() {
		return eat;
	}


	public void setEat(Integer eat) {
		this.eat = eat;
	}


	public Integer getCommute() {
		return commute;
	}


	public void setCommute(Integer commute) {
		this.commute = commute;
	}


	public Integer getEntertainment() {
		return entertainment;
	}


	public void setEntertainment(Integer entertainment) {
		this.entertainment = entertainment;
	}


	public Integer getSleep() {
		return sleep;
	}


	public void setSleep(Integer sleep) {
		this.sleep = sleep;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", work=" + work + ", eat=" + eat + ", commute=" + commute
				+ ", entertainment=" + entertainment + ", sleep=" + sleep + "]";
	}
	
	
}
