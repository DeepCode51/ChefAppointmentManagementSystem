package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Equipment;

@Repository("equipmentDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface EquipmentDAO {

	/**
* EquipmentDAO 接口 可以按名称直接调用equipment.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包equipment.xml里的insertEquipment配置 返回值0(失败),1(成功)
	public int insertEquipment(Equipment equipment);

	// 更新数据 调用entity包equipment.xml里的updateEquipment配置 返回值0(失败),1(成功)
	public int updateEquipment(Equipment equipment);

	// 删除数据 调用entity包equipment.xml里的deleteEquipment配置 返回值0(失败),1(成功)
	public int deleteEquipment(String equipmentid);

	// 查询全部数据 调用entity包equipment.xml里的getAllEquipment配置 返回List类型的数据
	public List<Equipment> getAllEquipment();

	// 按照Equipment类里面的值精确查询 调用entity包equipment.xml里的getEquipmentByCond配置 返回List类型的数据
	public List<Equipment> getEquipmentByCond(Equipment equipment);

	// 按照Equipment类里面的值模糊查询 调用entity包equipment.xml里的getEquipmentByLike配置 返回List类型的数据
	public List<Equipment> getEquipmentByLike(Equipment equipment);

	// 按主键查询表返回单一的Equipment实例 调用entity包equipment.xml里的getEquipmentById配置
	public Equipment getEquipmentById(String equipmentid);

}


