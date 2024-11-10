package com.entity;
import com.util.VeDate;
public class Checkin {
	private String checkinid = "C"+VeDate.getStringId();//生成主键编号
	private String teacherid;//厨师
	private String courseid;//课程
	private String usersid;//用户
	private String addtime;//日期
	private String memo;//备注
	private String teachername;// 映射数据
	private String coursename;// 映射数据
	private String username;// 映射数据
	public String getCheckinid() { return checkinid; }
	public void setCheckinid(String checkinid) { this.checkinid = checkinid; }
	public String getTeacherid() { return this.teacherid; }
	public void setTeacherid(String teacherid) { this.teacherid = teacherid; }
	public String getCourseid() { return this.courseid; }
	public void setCourseid(String courseid) { this.courseid = courseid; }
	public String getUsersid() { return this.usersid; }
	public void setUsersid(String usersid) { this.usersid = usersid; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getTeachername() { return this.teachername; }
	public void setTeachername(String teachername) { this.teachername = teachername; }
	public String getCoursename() { return this.coursename; }
	public void setCoursename(String coursename) { this.coursename = coursename; }
	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Checkin [checkinid="+this.checkinid+", teacherid="+this.teacherid+", courseid="+this.courseid+", usersid="+this.usersid+", addtime="+this.addtime+", memo="+this.memo+", teachername="+this.teachername+", coursename="+this.coursename+", username="+this.username+"]";
}



}




/**
* 
*/
