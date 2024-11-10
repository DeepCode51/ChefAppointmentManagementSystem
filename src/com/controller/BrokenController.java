package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Broken;
import com.service.BrokenService;
import com.entity.Equipment;
import com.service.EquipmentService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/broken" , produces = "text/plain;charset=utf-8")
public class BrokenController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private BrokenService brokenService;
	@Autowired
	private EquipmentService equipmentService;

	// 准备添加数据
	@RequestMapping("createBroken.action")
	public String createBroken() {
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/addbroken";
	}
	// 添加数据
	@RequestMapping("addBroken.action")
	public String addBroken(Broken broken) {
		this.brokenService.insertBroken(broken);
		return "redirect:/broken/createBroken.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBroken.action")
	public String deleteBroken(String id) {
		this.brokenService.deleteBroken(id);
		return "redirect:/broken/getAllBroken.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBrokenByIds.action")
	public String deleteBrokenByIds() {
		String[] ids = this.getRequest().getParameterValues("brokenid");
		for (String brokenid : ids) {
			this.brokenService.deleteBroken(brokenid);
		}
		return "redirect:/broken/getAllBroken.action";
	}

	// 更新数据
	@RequestMapping("updateBroken.action")
	public String updateBroken(Broken broken) {
		this.brokenService.updateBroken(broken);
		return "redirect:/broken/getAllBroken.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBroken.action")
	public String getAllBroken(String number) {
		List<Broken> brokenList = this.brokenService.getAllBroken();
		PageHelper.getPage(brokenList, "broken", null, null, 10, number, this.getRequest(), null);
		return "admin/listbroken";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBrokenByCond.action")
	public String queryBrokenByCond(String cond, String name, String number) {
		Broken broken = new Broken();
		if(cond != null){
			if ("equipmentid".equals(cond)) {
				broken.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				broken.setReason(name);
			}
			if ("resultx".equals(cond)) {
				broken.setResultx(name);
			}
			if ("money".equals(cond)) {
				broken.setMoney(name);
			}
			if ("addtime".equals(cond)) {
				broken.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				broken.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.brokenService.getBrokenByLike(broken), "broken", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybroken";
	}

	// 按主键查询数据
	@RequestMapping("getBrokenById.action")
	public String getBrokenById(String id) {
		Broken broken = this.brokenService.getBrokenById(id);
		this.getRequest().setAttribute("broken", broken);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/editbroken";
	}

	public BrokenService getBrokenService() { return brokenService; }

	public void setBrokenService(BrokenService brokenService) { this.brokenService = brokenService; }

}
// 
