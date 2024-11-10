package com.entity;
import com.util.VeDate;
public class Repair {
	private String repairid = "R"+VeDate.getStringId();//生成主键编号
	private String equipmentid;//设备
	private String reason;//维护原因
	private String money;//维护费用
	private String addtime;//维护日期
	private String manager;//负责人
	private String memo;//备注
	private String eno;// 映射数据
	public String getRepairid() { return repairid; }
	public void setRepairid(String repairid) { this.repairid = repairid; }
	public String getEquipmentid() { return this.equipmentid; }
	public void setEquipmentid(String equipmentid) { this.equipmentid = equipmentid; }
	public String getReason() { return this.reason; }
	public void setReason(String reason) { this.reason = reason; }
	public String getMoney() { return this.money; }
	public void setMoney(String money) { this.money = money; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getManager() { return this.manager; }
	public void setManager(String manager) { this.manager = manager; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getEno() { return this.eno; }
	public void setEno(String eno) { this.eno = eno; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Repair [repairid="+this.repairid+", equipmentid="+this.equipmentid+", reason="+this.reason+", money="+this.money+", addtime="+this.addtime+", manager="+this.manager+", memo="+this.memo+", eno="+this.eno+"]";
}



}




/**
* 
*/
