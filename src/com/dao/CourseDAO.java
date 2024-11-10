package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Course;

@Repository("courseDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CourseDAO {

	/**
	 * CourseDAO 接口 可以按名称直接调用course.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包course.xml里的insertCourse配置 返回值0(失败),1(成功)
	public int insertCourse(Course course);

	// 更新数据 调用entity包course.xml里的updateCourse配置 返回值0(失败),1(成功)
	public int updateCourse(Course course);

	// 删除数据 调用entity包course.xml里的deleteCourse配置 返回值0(失败),1(成功)
	public int deleteCourse(String courseid);

	// 查询全部数据 调用entity包course.xml里的getAllCourse配置 返回List类型的数据
	public List<Course> getAllCourse();

	public List<Course> getCourseByNews();

	public List<Course> getCourseByHot();

	public List<Course> getCourseByCate(String cateid);

	// 按照Course类里面的值精确查询 调用entity包course.xml里的getCourseByCond配置 返回List类型的数据
	public List<Course> getCourseByCond(Course course);

	// 按照Course类里面的值模糊查询 调用entity包course.xml里的getCourseByLike配置 返回List类型的数据
	public List<Course> getCourseByLike(Course course);

	// 按主键查询表返回单一的Course实例 调用entity包course.xml里的getCourseById配置
	public Course getCourseById(String courseid);

}
