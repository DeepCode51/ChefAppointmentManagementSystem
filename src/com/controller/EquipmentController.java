package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Equipment;
import com.service.EquipmentService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/equipment", produces = "text/plain;charset=utf-8")
public class EquipmentController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private EquipmentService equipmentService;

	// 准备添加数据
	@RequestMapping("createEquipment.action")
	public String createEquipment() {
		this.getRequest().setAttribute("eno", "ENO" + VeDate.getStringDatex());
		return "admin/addequipment";
	}

	// 添加数据
	@RequestMapping("addEquipment.action")
	public String addEquipment(Equipment equipment) {
		equipment.setStatus("正常");
		this.equipmentService.insertEquipment(equipment);
		return "redirect:/equipment/createEquipment.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteEquipment.action")
	public String deleteEquipment(String id) {
		this.equipmentService.deleteEquipment(id);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 批量删除数据
	@RequestMapping("deleteEquipmentByIds.action")
	public String deleteEquipmentByIds() {
		String[] ids = this.getRequest().getParameterValues("equipmentid");
		for (String equipmentid : ids) {
			this.equipmentService.deleteEquipment(equipmentid);
		}
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 更新数据
	@RequestMapping("updateEquipment.action")
	public String updateEquipment(Equipment equipment) {
		this.equipmentService.updateEquipment(equipment);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Equipment equipment = this.equipmentService.getEquipmentById(id);
		if (status.equals(equipment.getStatus())) {
			status = "";
		}
		equipment.setStatus(status);
		this.equipmentService.updateEquipment(equipment);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 显示全部数据
	@RequestMapping("getAllEquipment.action")
	public String getAllEquipment(String number) {
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		PageHelper.getPage(equipmentList, "equipment", null, null, 10, number, this.getRequest(), null);
		return "admin/listequipment";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryEquipmentByCond.action")
	public String queryEquipmentByCond(String cond, String name, String number) {
		Equipment equipment = new Equipment();
		if (cond != null) {
			if ("eno".equals(cond)) {
				equipment.setEno(name);
			}
			if ("equipname".equals(cond)) {
				equipment.setEquipname(name);
			}
			if ("productor".equals(cond)) {
				equipment.setProductor(name);
			}
			if ("image".equals(cond)) {
				equipment.setImage(name);
			}
			if ("useinfo".equals(cond)) {
				equipment.setUseinfo(name);
			}
			if ("buydate".equals(cond)) {
				equipment.setBuydate(name);
			}
			if ("price".equals(cond)) {
				equipment.setPrice(name);
			}
			if ("status".equals(cond)) {
				equipment.setStatus(name);
			}
			if ("contents".equals(cond)) {
				equipment.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.equipmentService.getEquipmentByLike(equipment), "equipment", nameList, valueList, 10,
				number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryequipment";
	}

	// 按主键查询数据
	@RequestMapping("getEquipmentById.action")
	public String getEquipmentById(String id) {
		Equipment equipment = this.equipmentService.getEquipmentById(id);
		this.getRequest().setAttribute("equipment", equipment);
		return "admin/editequipment";
	}

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

}
// 
