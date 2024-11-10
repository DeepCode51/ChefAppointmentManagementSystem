package com.entity;
import com.util.VeDate;
public class Course {
	private String courseid = "C"+VeDate.getStringId();//生成主键编号
	private String coursename;//课程名称
	private String image;//封面
	private String cateid;//课程类型
	private String teacherid;//厨师
	private String price;//课时费用
	private String recommend;//是否推荐
	private String special;//是否特价
	private String addtime;//上架日期
	private String hits;//点击数
	private String num;//报名人数
	private String worktime;//上课时间
	private String contents;//课程详情
	private String catename;// 映射数据
	private String teachername;// 映射数据
	public String getCourseid() { return courseid; }
	public void setCourseid(String courseid) { this.courseid = courseid; }
	public String getCoursename() { return this.coursename; }
	public void setCoursename(String coursename) { this.coursename = coursename; }
	public String getImage() { return this.image; }
	public void setImage(String image) { this.image = image; }
	public String getCateid() { return this.cateid; }
	public void setCateid(String cateid) { this.cateid = cateid; }
	public String getTeacherid() { return this.teacherid; }
	public void setTeacherid(String teacherid) { this.teacherid = teacherid; }
	public String getPrice() { return this.price; }
	public void setPrice(String price) { this.price = price; }
	public String getRecommend() { return this.recommend; }
	public void setRecommend(String recommend) { this.recommend = recommend; }
	public String getSpecial() { return this.special; }
	public void setSpecial(String special) { this.special = special; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getHits() { return this.hits; }
	public void setHits(String hits) { this.hits = hits; }
	public String getNum() { return this.num; }
	public void setNum(String num) { this.num = num; }
	public String getWorktime() { return this.worktime; }
	public void setWorktime(String worktime) { this.worktime = worktime; }
	public String getContents() { return this.contents; }
	public void setContents(String contents) { this.contents = contents; }
	public String getCatename() { return this.catename; }
	public void setCatename(String catename) { this.catename = catename; }
	public String getTeachername() { return this.teachername; }
	public void setTeachername(String teachername) { this.teachername = teachername; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Course [courseid="+this.courseid+", coursename="+this.coursename+", image="+this.image+", cateid="+this.cateid+", teacherid="+this.teacherid+", price="+this.price+", recommend="+this.recommend+", special="+this.special+", addtime="+this.addtime+", hits="+this.hits+", num="+this.num+", worktime="+this.worktime+", contents="+this.contents+", catename="+this.catename+", teachername="+this.teachername+"]";
}



}




/**
* 
*/
