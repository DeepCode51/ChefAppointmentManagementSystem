package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Teacher;

@Repository("teacherDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface TeacherDAO {

	/**
	 * TeacherDAO 接口 可以按名称直接调用teacher.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包teacher.xml里的insertTeacher配置 返回值0(失败),1(成功)
	public int insertTeacher(Teacher teacher);

	// 更新数据 调用entity包teacher.xml里的updateTeacher配置 返回值0(失败),1(成功)
	public int updateTeacher(Teacher teacher);

	// 删除数据 调用entity包teacher.xml里的deleteTeacher配置 返回值0(失败),1(成功)
	public int deleteTeacher(String teacherid);

	// 查询全部数据 调用entity包teacher.xml里的getAllTeacher配置 返回List类型的数据
	public List<Teacher> getAllTeacher();

	public List<Teacher> getFrontTeacher();

	// 按照Teacher类里面的值精确查询 调用entity包teacher.xml里的getTeacherByCond配置 返回List类型的数据
	public List<Teacher> getTeacherByCond(Teacher teacher);

	// 按照Teacher类里面的值模糊查询 调用entity包teacher.xml里的getTeacherByLike配置 返回List类型的数据
	public List<Teacher> getTeacherByLike(Teacher teacher);

	// 按主键查询表返回单一的Teacher实例 调用entity包teacher.xml里的getTeacherById配置
	public Teacher getTeacherById(String teacherid);

}
