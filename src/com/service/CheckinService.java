package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Checkin;
@Service("checkinService")
public interface CheckinService {
	// 插入数据 调用checkinDAO里的insertCheckin配置
	public int insertCheckin(Checkin checkin);

	// 更新数据 调用checkinDAO里的updateCheckin配置
	public int updateCheckin(Checkin checkin);

	// 删除数据 调用checkinDAO里的deleteCheckin配置
	public int deleteCheckin(String checkinid);

	// 查询全部数据 调用checkinDAO里的getAllCheckin配置
	public List<Checkin> getAllCheckin();

	// 按照Checkin类里面的字段名称精确查询 调用checkinDAO里的getCheckinByCond配置
	public List<Checkin> getCheckinByCond(Checkin checkin);

	// 按照Checkin类里面的字段名称模糊查询 调用checkinDAO里的getCheckinByLike配置
	public List<Checkin> getCheckinByLike(Checkin checkin);

	// 按主键查询表返回单一的Checkin实例 调用checkinDAO里的getCheckinById配置
	public Checkin getCheckinById(String checkinid);

}

