package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Teacher;
import com.service.TeacherService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/teacher", produces = "text/plain;charset=utf-8")
public class TeacherController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private TeacherService teacherService;

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		return "admin/teditpwd";
	}

	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Teacher teacher = this.teacherService.getTeacherById(adminid);
		if (password.equals(teacher.getPassword())) {
			teacher.setPassword(repassword);
			this.teacherService.updateTeacher(teacher);
		} else {
			this.getRequest().setAttribute("message", "旧密码错误");
		}
		return "redirect:/teacher/prePwd.action";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Teacher teacher = this.teacherService.getTeacherById(adminid);
		this.getRequest().setAttribute("teacher", teacher);
		return "admin/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Teacher teacher) {
		this.teacherService.updateTeacher(teacher);
		return "redirect:/teacher/userinfo.action";
	}

	// 准备添加数据
	@RequestMapping("createTeacher.action")
	public String createTeacher() {
		return "admin/addteacher";
	}

	// 添加数据
	@RequestMapping("addTeacher.action")
	public String addTeacher(Teacher teacher) {
		this.teacherService.insertTeacher(teacher);
		return "redirect:/teacher/createTeacher.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTeacher.action")
	public String deleteTeacher(String id) {
		this.teacherService.deleteTeacher(id);
		return "redirect:/teacher/getAllTeacher.action";
	}

	// 批量删除数据
	@RequestMapping("deleteTeacherByIds.action")
	public String deleteTeacherByIds() {
		String[] ids = this.getRequest().getParameterValues("teacherid");
		for (String teacherid : ids) {
			this.teacherService.deleteTeacher(teacherid);
		}
		return "redirect:/teacher/getAllTeacher.action";
	}

	// 更新数据
	@RequestMapping("updateTeacher.action")
	public String updateTeacher(Teacher teacher) {
		this.teacherService.updateTeacher(teacher);
		return "redirect:/teacher/getAllTeacher.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTeacher.action")
	public String getAllTeacher(String number) {
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		PageHelper.getPage(teacherList, "teacher", null, null, 10, number, this.getRequest(), null);
		return "admin/listteacher";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTeacherByCond.action")
	public String queryTeacherByCond(String cond, String name, String number) {
		Teacher teacher = new Teacher();
		if (cond != null) {
			if ("username".equals(cond)) {
				teacher.setUsername(name);
			}
			if ("password".equals(cond)) {
				teacher.setPassword(name);
			}
			if ("teachername".equals(cond)) {
				teacher.setTeachername(name);
			}
			if ("sex".equals(cond)) {
				teacher.setSex(name);
			}
			if ("birthday".equals(cond)) {
				teacher.setBirthday(name);
			}
			if ("image".equals(cond)) {
				teacher.setImage(name);
			}
			if ("workdate".equals(cond)) {
				teacher.setWorkdate(name);
			}
			if ("contact".equals(cond)) {
				teacher.setContact(name);
			}
			if ("contents".equals(cond)) {
				teacher.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.teacherService.getTeacherByLike(teacher), "teacher", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryteacher";
	}

	// 按主键查询数据
	@RequestMapping("getTeacherById.action")
	public String getTeacherById(String id) {
		Teacher teacher = this.teacherService.getTeacherById(id);
		this.getRequest().setAttribute("teacher", teacher);
		return "admin/editteacher";
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
// 
