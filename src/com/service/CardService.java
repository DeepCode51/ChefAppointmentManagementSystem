package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Card;
@Service("cardService")
public interface CardService {
	// 插入数据 调用cardDAO里的insertCard配置
	public int insertCard(Card card);

	// 更新数据 调用cardDAO里的updateCard配置
	public int updateCard(Card card);

	// 删除数据 调用cardDAO里的deleteCard配置
	public int deleteCard(String cardid);

	// 查询全部数据 调用cardDAO里的getAllCard配置
	public List<Card> getAllCard();

	// 按照Card类里面的字段名称精确查询 调用cardDAO里的getCardByCond配置
	public List<Card> getCardByCond(Card card);

	// 按照Card类里面的字段名称模糊查询 调用cardDAO里的getCardByLike配置
	public List<Card> getCardByLike(Card card);

	// 按主键查询表返回单一的Card实例 调用cardDAO里的getCardById配置
	public Card getCardById(String cardid);

}

