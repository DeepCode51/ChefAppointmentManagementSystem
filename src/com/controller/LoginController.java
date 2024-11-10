package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.entity.Teacher;
import com.service.AdminService;
import com.service.TeacherService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/login")
public class LoginController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private AdminService adminService;
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private TeacherService teacherService;

	// 管理员登录 1 验证用户名是否存在 2 验证密码是否正确
	@RequestMapping("login.action")
	public String login() {
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String role = this.getRequest().getParameter("role");
		if ("管理员".equals(role)) {
			Admin adminEntity = new Admin();
			adminEntity.setUsername(username);
			List<Admin> adminlist = this.adminService.getAdminByCond(adminEntity);
			if (adminlist.size() == 0) {
				this.getSession().setAttribute("message", "用户名不存在");
			} else {
				Admin admin = adminlist.get(0);
				if (password.equals(admin.getPassword())) {
					this.getSession().setAttribute("adminid", admin.getAdminid());
					this.getSession().setAttribute("adminname", admin.getUsername());
					this.getSession().setAttribute("realname", admin.getRealname());
					this.getSession().setAttribute("role", "管理员");
					return "admin/main";
				} else {
					this.getSession().setAttribute("message", "密码错误");
				}
			}
		} else {
			Teacher teacher = new Teacher();
			teacher.setUsername(username);
			List<Teacher> teacherList = this.teacherService.getTeacherByCond(teacher);
			if (teacherList.size() == 0) {
				this.getSession().setAttribute("message", "用户名不存在");
			} else {
				Teacher d = new Teacher();
				d = teacherList.get(0);
				if (password.equals(d.getPassword())) {
					this.getSession().setAttribute("adminid", d.getTeacherid());
					this.getSession().setAttribute("adminname", d.getUsername());
					this.getSession().setAttribute("realname", d.getTeachername());
					this.getSession().setAttribute("role", role);
					return "admin/main";
				} else {
					this.getSession().setAttribute("message", "密码错误");
				}
			}
		}
		return "admin/index";
	}

	@RequestMapping("exit.action")
	public String exit() {
		this.getSession().removeAttribute("adminid");
		this.getSession().removeAttribute("adminname");
		this.getSession().removeAttribute("realname");
		return "redirect:/admin/index.action";
	}
}
