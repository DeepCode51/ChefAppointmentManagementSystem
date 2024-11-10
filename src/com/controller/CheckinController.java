package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Card;
import com.entity.Checkin;
import com.entity.Course;
import com.entity.Teacher;
import com.entity.Users;
import com.service.CardService;
import com.service.CheckinService;
import com.service.CourseService;
import com.service.TeacherService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/checkin", produces = "text/plain;charset=utf-8")
public class CheckinController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private CheckinService checkinService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CardService cardService;

	// 准备添加数据
	@RequestMapping("createCheckin.action")
	public String createCheckin() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "admin/addcheckin";
	}

	// 添加数据
	@RequestMapping("addCheckin.action")
	public String addCheckin(Checkin checkin) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		checkin.setTeacherid(adminid);
		checkin.setAddtime(VeDate.getStringDateShort());
		Card card = this.cardService.getCardById(this.getRequest().getParameter("cardid"));
		card.setUsenum("" + (Integer.parseInt(card.getUsenum()) + 1));
		card.setSurnum("" + (Integer.parseInt(card.getSurnum()) - 1));
		checkin.setUsersid(card.getUsersid());
		this.checkinService.insertCheckin(checkin);
		this.cardService.updateCard(card);
		return "redirect:/checkin/createCheckin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCheckin.action")
	public String deleteCheckin(String id) {
		this.checkinService.deleteCheckin(id);
		return "redirect:/checkin/getAllCheckin.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCheckinByIds.action")
	public String deleteCheckinByIds() {
		String[] ids = this.getRequest().getParameterValues("checkinid");
		for (String checkinid : ids) {
			this.checkinService.deleteCheckin(checkinid);
		}
		return "redirect:/checkin/getAllCheckin.action";
	}

	// 更新数据
	@RequestMapping("updateCheckin.action")
	public String updateCheckin(Checkin checkin) {
		this.checkinService.updateCheckin(checkin);
		return "redirect:/checkin/getAllCheckin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCheckin.action")
	public String getAllCheckin(String number) {
		List<Checkin> checkinList = this.checkinService.getAllCheckin();
		PageHelper.getPage(checkinList, "checkin", null, null, 10, number, this.getRequest(), null);
		return "admin/listcheckin";
	}

	@RequestMapping("getTeacherCheckin.action")
	public String getTeacherCheckin(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Checkin checkin = new Checkin();
		checkin.setTeacherid(adminid);
		List<Checkin> checkinList = this.checkinService.getAllCheckin();
		PageHelper.getUserPage(checkinList, "checkin", "getTeacherCheckin", 10, number, this.getRequest());
		return "admin/xlistcheckin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCheckinByCond.action")
	public String queryCheckinByCond(String cond, String name, String number) {
		Checkin checkin = new Checkin();
		if (cond != null) {
			if ("teacherid".equals(cond)) {
				checkin.setTeacherid(name);
			}
			if ("courseid".equals(cond)) {
				checkin.setCourseid(name);
			}
			if ("usersid".equals(cond)) {
				checkin.setUsersid(name);
			}
			if ("addtime".equals(cond)) {
				checkin.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				checkin.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.checkinService.getCheckinByLike(checkin), "checkin", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycheckin";
	}

	// 按主键查询数据
	@RequestMapping("getCheckinById.action")
	public String getCheckinById(String id) {
		Checkin checkin = this.checkinService.getCheckinById(id);
		this.getRequest().setAttribute("checkin", checkin);
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editcheckin";
	}

	public CheckinService getCheckinService() {
		return checkinService;
	}

	public void setCheckinService(CheckinService checkinService) {
		this.checkinService = checkinService;
	}

}
// 
