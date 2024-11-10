package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CourseDAO;
import com.entity.Course;
import com.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCourse(Course course) {
		return this.courseDAO.insertCourse(course);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCourse(Course course) {
		return this.courseDAO.updateCourse(course);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCourse(String courseid) {
		return this.courseDAO.deleteCourse(courseid);
	}

	@Override // 继承接口的查询全部
	public List<Course> getAllCourse() {
		return this.courseDAO.getAllCourse();
	}

	@Override // 继承接口的查询全部
	public List<Course> getCourseByNews() {
		return this.courseDAO.getCourseByNews();
	}

	@Override // 继承接口的查询全部
	public List<Course> getCourseByHot() {
		return this.courseDAO.getCourseByHot();
	}

	@Override // 继承接口的查询全部
	public List<Course> getCourseByCate(String cateid) {
		return this.courseDAO.getCourseByCate(cateid);
	}

	@Override // 继承接口的按条件精确查询
	public List<Course> getCourseByCond(Course course) {
		return this.courseDAO.getCourseByCond(course);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Course> getCourseByLike(Course course) {
		return this.courseDAO.getCourseByLike(course);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Course getCourseById(String courseid) {
		return this.courseDAO.getCourseById(courseid);
	}

}

// 
