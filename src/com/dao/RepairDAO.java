package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Repair;

@Repository("repairDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface RepairDAO {

	/**
* RepairDAO 接口 可以按名称直接调用repair.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包repair.xml里的insertRepair配置 返回值0(失败),1(成功)
	public int insertRepair(Repair repair);

	// 更新数据 调用entity包repair.xml里的updateRepair配置 返回值0(失败),1(成功)
	public int updateRepair(Repair repair);

	// 删除数据 调用entity包repair.xml里的deleteRepair配置 返回值0(失败),1(成功)
	public int deleteRepair(String repairid);

	// 查询全部数据 调用entity包repair.xml里的getAllRepair配置 返回List类型的数据
	public List<Repair> getAllRepair();

	// 按照Repair类里面的值精确查询 调用entity包repair.xml里的getRepairByCond配置 返回List类型的数据
	public List<Repair> getRepairByCond(Repair repair);

	// 按照Repair类里面的值模糊查询 调用entity包repair.xml里的getRepairByLike配置 返回List类型的数据
	public List<Repair> getRepairByLike(Repair repair);

	// 按主键查询表返回单一的Repair实例 调用entity包repair.xml里的getRepairById配置
	public Repair getRepairById(String repairid);

}


