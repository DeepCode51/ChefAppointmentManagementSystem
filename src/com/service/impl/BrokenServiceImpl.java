package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BrokenDAO;
import com.entity.Broken;
import com.service.BrokenService;

@Service("brokenService")
public class BrokenServiceImpl implements BrokenService {
	@Autowired
	private BrokenDAO brokenDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBroken(Broken broken) {
		return this.brokenDAO.insertBroken(broken);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBroken(Broken broken) {
		return this.brokenDAO.updateBroken(broken);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBroken(String brokenid) {
		return this.brokenDAO.deleteBroken(brokenid);
	}

	@Override // 继承接口的查询全部
	public List<Broken> getAllBroken() {
		return this.brokenDAO.getAllBroken();
	}

	@Override // 继承接口的按条件精确查询
	public List<Broken> getBrokenByCond(Broken broken) {
		return this.brokenDAO.getBrokenByCond(broken);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Broken> getBrokenByLike(Broken broken) {
		return this.brokenDAO.getBrokenByLike(broken);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Broken getBrokenById(String brokenid) {
		return this.brokenDAO.getBrokenById(brokenid);
	}

}

// 
