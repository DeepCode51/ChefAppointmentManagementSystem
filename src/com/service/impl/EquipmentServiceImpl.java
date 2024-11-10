package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EquipmentDAO;
import com.entity.Equipment;
import com.service.EquipmentService;

@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDAO equipmentDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertEquipment(Equipment equipment) {
		return this.equipmentDAO.insertEquipment(equipment);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateEquipment(Equipment equipment) {
		return this.equipmentDAO.updateEquipment(equipment);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteEquipment(String equipmentid) {
		return this.equipmentDAO.deleteEquipment(equipmentid);
	}

	@Override // 继承接口的查询全部
	public List<Equipment> getAllEquipment() {
		return this.equipmentDAO.getAllEquipment();
	}

	@Override // 继承接口的按条件精确查询
	public List<Equipment> getEquipmentByCond(Equipment equipment) {
		return this.equipmentDAO.getEquipmentByCond(equipment);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Equipment> getEquipmentByLike(Equipment equipment) {
		return this.equipmentDAO.getEquipmentByLike(equipment);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Equipment getEquipmentById(String equipmentid) {
		return this.equipmentDAO.getEquipmentById(equipmentid);
	}

}

// 
