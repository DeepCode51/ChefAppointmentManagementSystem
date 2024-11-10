package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Card;

@Repository("cardDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CardDAO {

	/**
* CardDAO 接口 可以按名称直接调用card.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包card.xml里的insertCard配置 返回值0(失败),1(成功)
	public int insertCard(Card card);

	// 更新数据 调用entity包card.xml里的updateCard配置 返回值0(失败),1(成功)
	public int updateCard(Card card);

	// 删除数据 调用entity包card.xml里的deleteCard配置 返回值0(失败),1(成功)
	public int deleteCard(String cardid);

	// 查询全部数据 调用entity包card.xml里的getAllCard配置 返回List类型的数据
	public List<Card> getAllCard();

	// 按照Card类里面的值精确查询 调用entity包card.xml里的getCardByCond配置 返回List类型的数据
	public List<Card> getCardByCond(Card card);

	// 按照Card类里面的值模糊查询 调用entity包card.xml里的getCardByLike配置 返回List类型的数据
	public List<Card> getCardByLike(Card card);

	// 按主键查询表返回单一的Card实例 调用entity包card.xml里的getCardById配置
	public Card getCardById(String cardid);

}


