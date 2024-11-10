package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Repair;
import com.service.RepairService;
import com.entity.Equipment;
import com.service.EquipmentService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/repair", produces = "text/plain;charset=utf-8")
public class RepairController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private RepairService repairService;
	@Autowired
	private EquipmentService equipmentService;

	// 准备添加数据
	@RequestMapping("createRepair.action")
	public String createRepair() {
		Equipment equipment = new Equipment();
		equipment.setStatus("正常");
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(equipment);
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/addrepair";
	}

	// 添加数据
	@RequestMapping("addRepair.action")
	public String addRepair(Repair repair) {
		this.repairService.insertRepair(repair);
		return "redirect:/repair/createRepair.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRepair.action")
	public String deleteRepair(String id) {
		this.repairService.deleteRepair(id);
		return "redirect:/repair/getAllRepair.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRepairByIds.action")
	public String deleteRepairByIds() {
		String[] ids = this.getRequest().getParameterValues("repairid");
		for (String repairid : ids) {
			this.repairService.deleteRepair(repairid);
		}
		return "redirect:/repair/getAllRepair.action";
	}

	// 更新数据
	@RequestMapping("updateRepair.action")
	public String updateRepair(Repair repair) {
		this.repairService.updateRepair(repair);
		return "redirect:/repair/getAllRepair.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRepair.action")
	public String getAllRepair(String number) {
		List<Repair> repairList = this.repairService.getAllRepair();
		PageHelper.getPage(repairList, "repair", null, null, 10, number, this.getRequest(), null);
		return "admin/listrepair";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRepairByCond.action")
	public String queryRepairByCond(String cond, String name, String number) {
		Repair repair = new Repair();
		if (cond != null) {
			if ("equipmentid".equals(cond)) {
				repair.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				repair.setReason(name);
			}
			if ("money".equals(cond)) {
				repair.setMoney(name);
			}
			if ("addtime".equals(cond)) {
				repair.setAddtime(name);
			}
			if ("manager".equals(cond)) {
				repair.setManager(name);
			}
			if ("memo".equals(cond)) {
				repair.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.repairService.getRepairByLike(repair), "repair", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryrepair";
	}

	// 按主键查询数据
	@RequestMapping("getRepairById.action")
	public String getRepairById(String id) {
		Repair repair = this.repairService.getRepairById(id);
		this.getRequest().setAttribute("repair", repair);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/editrepair";
	}

	public RepairService getRepairService() {
		return repairService;
	}

	public void setRepairService(RepairService repairService) {
		this.repairService = repairService;
	}

}
// 
