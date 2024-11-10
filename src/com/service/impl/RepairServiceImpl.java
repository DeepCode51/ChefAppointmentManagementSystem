package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RepairDAO;
import com.entity.Repair;
import com.service.RepairService;

@Service("repairService")
public class RepairServiceImpl implements RepairService {
	@Autowired
	private RepairDAO repairDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRepair(Repair repair) {
		return this.repairDAO.insertRepair(repair);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRepair(Repair repair) {
		return this.repairDAO.updateRepair(repair);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRepair(String repairid) {
		return this.repairDAO.deleteRepair(repairid);
	}

	@Override // 继承接口的查询全部
	public List<Repair> getAllRepair() {
		return this.repairDAO.getAllRepair();
	}

	@Override // 继承接口的按条件精确查询
	public List<Repair> getRepairByCond(Repair repair) {
		return this.repairDAO.getRepairByCond(repair);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Repair> getRepairByLike(Repair repair) {
		return this.repairDAO.getRepairByLike(repair);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Repair getRepairById(String repairid) {
		return this.repairDAO.getRepairById(repairid);
	}

}

// 
