package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CheckinDAO;
import com.entity.Checkin;
import com.service.CheckinService;

@Service("checkinService")
public class CheckinServiceImpl implements CheckinService {
	@Autowired
	private CheckinDAO checkinDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCheckin(Checkin checkin) {
		return this.checkinDAO.insertCheckin(checkin);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCheckin(Checkin checkin) {
		return this.checkinDAO.updateCheckin(checkin);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCheckin(String checkinid) {
		return this.checkinDAO.deleteCheckin(checkinid);
	}

	@Override // 继承接口的查询全部
	public List<Checkin> getAllCheckin() {
		return this.checkinDAO.getAllCheckin();
	}

	@Override // 继承接口的按条件精确查询
	public List<Checkin> getCheckinByCond(Checkin checkin) {
		return this.checkinDAO.getCheckinByCond(checkin);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Checkin> getCheckinByLike(Checkin checkin) {
		return this.checkinDAO.getCheckinByLike(checkin);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Checkin getCheckinById(String checkinid) {
		return this.checkinDAO.getCheckinById(checkinid);
	}

}

// 
