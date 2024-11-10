package com.entity;
import com.util.VeDate;
public class Equipment {
	private String equipmentid = "E"+VeDate.getStringId();//生成主键编号
	private String eno;//设备名称
	private String equipname;//设备名称
	private String productor;//生产厂商
	private String image;//图片
	private String useinfo;//作用
	private String buydate;//采购日期
	private String price;//采购金额
	private String status;//状态
	private String contents;//设备介绍
	public String getEquipmentid() { return equipmentid; }
	public void setEquipmentid(String equipmentid) { this.equipmentid = equipmentid; }
	public String getEno() { return this.eno; }
	public void setEno(String eno) { this.eno = eno; }
	public String getEquipname() { return this.equipname; }
	public void setEquipname(String equipname) { this.equipname = equipname; }
	public String getProductor() { return this.productor; }
	public void setProductor(String productor) { this.productor = productor; }
	public String getImage() { return this.image; }
	public void setImage(String image) { this.image = image; }
	public String getUseinfo() { return this.useinfo; }
	public void setUseinfo(String useinfo) { this.useinfo = useinfo; }
	public String getBuydate() { return this.buydate; }
	public void setBuydate(String buydate) { this.buydate = buydate; }
	public String getPrice() { return this.price; }
	public void setPrice(String price) { this.price = price; }
	public String getStatus() { return this.status; }
	public void setStatus(String status) { this.status = status; }
	public String getContents() { return this.contents; }
	public void setContents(String contents) { this.contents = contents; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Equipment [equipmentid="+this.equipmentid+", eno="+this.eno+", equipname="+this.equipname+", productor="+this.productor+", image="+this.image+", useinfo="+this.useinfo+", buydate="+this.buydate+", price="+this.price+", status="+this.status+", contents="+this.contents+"]";
}



}




/**
* 
*/
