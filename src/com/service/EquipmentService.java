package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Equipment;
@Service("equipmentService")
public interface EquipmentService {
	// 插入数据 调用equipmentDAO里的insertEquipment配置
	public int insertEquipment(Equipment equipment);

	// 更新数据 调用equipmentDAO里的updateEquipment配置
	public int updateEquipment(Equipment equipment);

	// 删除数据 调用equipmentDAO里的deleteEquipment配置
	public int deleteEquipment(String equipmentid);

	// 查询全部数据 调用equipmentDAO里的getAllEquipment配置
	public List<Equipment> getAllEquipment();

	// 按照Equipment类里面的字段名称精确查询 调用equipmentDAO里的getEquipmentByCond配置
	public List<Equipment> getEquipmentByCond(Equipment equipment);

	// 按照Equipment类里面的字段名称模糊查询 调用equipmentDAO里的getEquipmentByLike配置
	public List<Equipment> getEquipmentByLike(Equipment equipment);

	// 按主键查询表返回单一的Equipment实例 调用equipmentDAO里的getEquipmentById配置
	public Equipment getEquipmentById(String equipmentid);

}

