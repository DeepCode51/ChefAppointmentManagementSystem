package com.entity;
import com.util.VeDate;
public class Teacher {
	private String teacherid = "T"+VeDate.getStringId();//生成主键编号
	private String username;//用户名
	private String password;//密码
	private String teachername;//姓名
	private String sex;//性别
	private String birthday;//出生日期
	private String image;//照片
	private String workdate;//入职日期
	private String contact;//联系方式
	private String contents;//厨师介绍
	public String getTeacherid() { return teacherid; }
	public void setTeacherid(String teacherid) { this.teacherid = teacherid; }
	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	public String getTeachername() { return this.teachername; }
	public void setTeachername(String teachername) { this.teachername = teachername; }
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	public String getBirthday() { return this.birthday; }
	public void setBirthday(String birthday) { this.birthday = birthday; }
	public String getImage() { return this.image; }
	public void setImage(String image) { this.image = image; }
	public String getWorkdate() { return this.workdate; }
	public void setWorkdate(String workdate) { this.workdate = workdate; }
	public String getContact() { return this.contact; }
	public void setContact(String contact) { this.contact = contact; }
	public String getContents() { return this.contents; }
	public void setContents(String contents) { this.contents = contents; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Teacher [teacherid="+this.teacherid+", username="+this.username+", password="+this.password+", teachername="+this.teachername+", sex="+this.sex+", birthday="+this.birthday+", image="+this.image+", workdate="+this.workdate+", contact="+this.contact+", contents="+this.contents+"]";
}



}




/**
* 
*/
