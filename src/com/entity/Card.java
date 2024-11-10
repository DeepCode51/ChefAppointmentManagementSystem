package com.entity;

import com.util.VeDate;

public class Card {
	private String cardid = "C" + VeDate.getStringId();// 生成主键编号
	private String cardno;// 卡号
	private String usersid;// 用户
	private String courseid;// 课程
	private String money;// 费用
	private String addtime;// 开卡日期
	private String num;// 总次数
	private String usenum;// 使用次数
	private String surnum;// 剩余次数
	private String memo;// 备注
	private String username;// 映射数据
	private String coursename;// 映射数据
	private String teacherid;

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUsenum() {
		return this.usenum;
	}

	public void setUsenum(String usenum) {
		this.usenum = usenum;
	}

	public String getSurnum() {
		return this.surnum;
	}

	public void setSurnum(String surnum) {
		this.surnum = surnum;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Card [cardid=" + this.cardid + ", cardno=" + this.cardno + ", usersid=" + this.usersid + ", courseid="
				+ this.courseid + ", money=" + this.money + ", addtime=" + this.addtime + ", num=" + this.num
				+ ", usenum=" + this.usenum + ", surnum=" + this.surnum + ", memo=" + this.memo + ", username="
				+ this.username + ", coursename=" + this.coursename + "]";
	}

}

/**
 * 
 */
