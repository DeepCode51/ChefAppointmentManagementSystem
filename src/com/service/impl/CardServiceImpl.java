package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CardDAO;
import com.entity.Card;
import com.service.CardService;

@Service("cardService")
public class CardServiceImpl implements CardService {
	@Autowired
	private CardDAO cardDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCard(Card card) {
		return this.cardDAO.insertCard(card);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCard(Card card) {
		return this.cardDAO.updateCard(card);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCard(String cardid) {
		return this.cardDAO.deleteCard(cardid);
	}

	@Override // 继承接口的查询全部
	public List<Card> getAllCard() {
		return this.cardDAO.getAllCard();
	}

	@Override // 继承接口的按条件精确查询
	public List<Card> getCardByCond(Card card) {
		return this.cardDAO.getCardByCond(card);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Card> getCardByLike(Card card) {
		return this.cardDAO.getCardByLike(card);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Card getCardById(String cardid) {
		return this.cardDAO.getCardById(cardid);
	}

}

// 
