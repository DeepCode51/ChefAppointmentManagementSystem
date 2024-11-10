package com.entity;
import com.util.VeDate;
public class Orders {
	private String ordersid = "O"+VeDate.getStringId();//生成主键编号
	private String ordercode;//预约单号
	private String usersid;//用户
	private String teacherid;//厨师
	private String orderdate;//预约日期
	private String sectionx;//时间段
	private String status;//状态
	private String memo;//备注
	private String realname;// 映射数据
	private String teachername;// 映射数据
	public String getOrdersid() { return ordersid; }
	public void setOrdersid(String ordersid) { this.ordersid = ordersid; }
	public String getOrdercode() { return this.ordercode; }
	public void setOrdercode(String ordercode) { this.ordercode = ordercode; }
	public String getUsersid() { return this.usersid; }
	public void setUsersid(String usersid) { this.usersid = usersid; }
	public String getTeacherid() { return this.teacherid; }
	public void setTeacherid(String teacherid) { this.teacherid = teacherid; }
	public String getOrderdate() { return this.orderdate; }
	public void setOrderdate(String orderdate) { this.orderdate = orderdate; }
	public String getSectionx() { return this.sectionx; }
	public void setSectionx(String sectionx) { this.sectionx = sectionx; }
	public String getStatus() { return this.status; }
	public void setStatus(String status) { this.status = status; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getRealname() { return this.realname; }
	public void setRealname(String realname) { this.realname = realname; }
	public String getTeachername() { return this.teachername; }
	public void setTeachername(String teachername) { this.teachername = teachername; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Orders [ordersid="+this.ordersid+", ordercode="+this.ordercode+", usersid="+this.usersid+", teacherid="+this.teacherid+", orderdate="+this.orderdate+", sectionx="+this.sectionx+", status="+this.status+", memo="+this.memo+", realname="+this.realname+", teachername="+this.teachername+"]";
}



}




/**
* 
*/
