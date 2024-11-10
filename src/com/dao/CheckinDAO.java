package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Checkin;

@Repository("checkinDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CheckinDAO {

	/**
* CheckinDAO 接口 可以按名称直接调用checkin.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包checkin.xml里的insertCheckin配置 返回值0(失败),1(成功)
	public int insertCheckin(Checkin checkin);

	// 更新数据 调用entity包checkin.xml里的updateCheckin配置 返回值0(失败),1(成功)
	public int updateCheckin(Checkin checkin);

	// 删除数据 调用entity包checkin.xml里的deleteCheckin配置 返回值0(失败),1(成功)
	public int deleteCheckin(String checkinid);

	// 查询全部数据 调用entity包checkin.xml里的getAllCheckin配置 返回List类型的数据
	public List<Checkin> getAllCheckin();

	// 按照Checkin类里面的值精确查询 调用entity包checkin.xml里的getCheckinByCond配置 返回List类型的数据
	public List<Checkin> getCheckinByCond(Checkin checkin);

	// 按照Checkin类里面的值模糊查询 调用entity包checkin.xml里的getCheckinByLike配置 返回List类型的数据
	public List<Checkin> getCheckinByLike(Checkin checkin);

	// 按主键查询表返回单一的Checkin实例 调用entity包checkin.xml里的getCheckinById配置
	public Checkin getCheckinById(String checkinid);

}


