package com.entity;
import com.util.VeDate;
public class Broken {
	private String brokenid = "B"+VeDate.getStringId();//生成主键编号
	private String equipmentid;//设备
	private String reason;//报废原因
	private String resultx;//处理结果
	private String money;//损失
	private String addtime;//日期
	private String memo;//备注
	private String equipname;// 映射数据
	public String getBrokenid() { return brokenid; }
	public void setBrokenid(String brokenid) { this.brokenid = brokenid; }
	public String getEquipmentid() { return this.equipmentid; }
	public void setEquipmentid(String equipmentid) { this.equipmentid = equipmentid; }
	public String getReason() { return this.reason; }
	public void setReason(String reason) { this.reason = reason; }
	public String getResultx() { return this.resultx; }
	public void setResultx(String resultx) { this.resultx = resultx; }
	public String getMoney() { return this.money; }
	public void setMoney(String money) { this.money = money; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getEquipname() { return this.equipname; }
	public void setEquipname(String equipname) { this.equipname = equipname; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Broken [brokenid="+this.brokenid+", equipmentid="+this.equipmentid+", reason="+this.reason+", resultx="+this.resultx+", money="+this.money+", addtime="+this.addtime+", memo="+this.memo+", equipname="+this.equipname+"]";
}



}




/**
* 
*/
