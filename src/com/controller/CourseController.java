package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Course;
import com.service.CourseService;
import com.entity.Cate;
import com.entity.Teacher;
import com.service.CateService;
import com.service.TeacherService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/course", produces = "text/plain;charset=utf-8")
public class CourseController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private CourseService courseService;
	@Autowired
	private CateService cateService;
	@Autowired
	private TeacherService teacherService;

	// 准备添加数据
	@RequestMapping("createCourse.action")
	public String createCourse() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		return "admin/addcourse";
	}

	// 添加数据
	@RequestMapping("addCourse.action")
	public String addCourse(Course course) {
		course.setAddtime(VeDate.getStringDateShort());
		course.setHits("0");
		course.setNum("0");
		this.courseService.insertCourse(course);
		return "redirect:/course/createCourse.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCourse.action")
	public String deleteCourse(String id) {
		this.courseService.deleteCourse(id);
		return "redirect:/course/getAllCourse.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCourseByIds.action")
	public String deleteCourseByIds() {
		String[] ids = this.getRequest().getParameterValues("courseid");
		for (String courseid : ids) {
			this.courseService.deleteCourse(courseid);
		}
		return "redirect:/course/getAllCourse.action";
	}

	// 更新数据
	@RequestMapping("updateCourse.action")
	public String updateCourse(Course course) {
		this.courseService.updateCourse(course);
		return "redirect:/course/getAllCourse.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCourse.action")
	public String getAllCourse(String number) {
		List<Course> courseList = this.courseService.getAllCourse();
		PageHelper.getPage(courseList, "course", null, null, 10, number, this.getRequest(), null);
		return "admin/listcourse";
	}

	@RequestMapping("getTeacherCourse.action")
	public String getTeacherCourse(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Course course = new Course();
		course.setTeacherid(adminid);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getUserPage(courseList, "course", "getTeacherCourse", 10, number, this.getRequest());
		return "admin/xlistcourse";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCourseByCond.action")
	public String queryCourseByCond(String cond, String name, String number) {
		Course course = new Course();
		if (cond != null) {
			if ("coursename".equals(cond)) {
				course.setCoursename(name);
			}
			if ("image".equals(cond)) {
				course.setImage(name);
			}
			if ("cateid".equals(cond)) {
				course.setCateid(name);
			}
			if ("teacherid".equals(cond)) {
				course.setTeacherid(name);
			}
			if ("price".equals(cond)) {
				course.setPrice(name);
			}
			if ("recommend".equals(cond)) {
				course.setRecommend(name);
			}
			if ("special".equals(cond)) {
				course.setSpecial(name);
			}
			if ("addtime".equals(cond)) {
				course.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				course.setHits(name);
			}
			if ("num".equals(cond)) {
				course.setNum(name);
			}
			if ("worktime".equals(cond)) {
				course.setWorktime(name);
			}
			if ("contents".equals(cond)) {
				course.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.courseService.getCourseByLike(course), "course", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycourse";
	}

	// 按主键查询数据
	@RequestMapping("getCourseById.action")
	public String getCourseById(String id) {
		Course course = this.courseService.getCourseById(id);
		this.getRequest().setAttribute("course", course);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		return "admin/editcourse";
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

}
// 
