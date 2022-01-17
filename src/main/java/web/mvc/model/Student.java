package web.mvc.model;

import java.util.Date;

public class Student {
	private Integer id; // 學生學號(不可重複)
	private String name; // 學生姓名
	private Integer score; // 學生成績
	private Integer sex; // 1: 男, 2:女
	private Date createtime; // 建立時間
	
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
}
