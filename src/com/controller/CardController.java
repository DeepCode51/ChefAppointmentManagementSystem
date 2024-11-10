package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Card;
import com.service.CardService;
import com.entity.Users;
import com.entity.Course;
import com.service.UsersService;
import com.service.CourseService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/card", produces = "text/plain;charset=utf-8")
public class CardController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private CardService cardService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CourseService courseService;

	// 准备添加数据
	@RequestMapping("createCard.action")
	public String createCard() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		this.getRequest().setAttribute("cardno", "CNO" + VeDate.getStringDatex());
		return "admin/addcard";
	}

	// 添加数据
	@RequestMapping("addCard.action")
	public String addCard(Card card) {
		card.setAddtime(VeDate.getStringDateShort());
		card.setUsenum("0");
		card.setSurnum(card.getNum());
		this.cardService.insertCard(card);
		Course course = this.courseService.getCourseById(card.getCourseid());
		course.setNum("" + (Integer.parseInt(course.getNum()) + 1));
		this.courseService.updateCourse(course);
		return "redirect:/card/createCard.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCard.action")
	public String deleteCard(String id) {
		this.cardService.deleteCard(id);
		return "redirect:/card/getAllCard.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCardByIds.action")
	public String deleteCardByIds() {
		String[] ids = this.getRequest().getParameterValues("cardid");
		for (String cardid : ids) {
			this.cardService.deleteCard(cardid);
		}
		return "redirect:/card/getAllCard.action";
	}

	// 更新数据
	@RequestMapping("updateCard.action")
	public String updateCard(Card card) {
		this.cardService.updateCard(card);
		return "redirect:/card/getAllCard.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCard.action")
	public String getAllCard(String number) {
		List<Card> cardList = this.cardService.getAllCard();
		PageHelper.getPage(cardList, "card", null, null, 10, number, this.getRequest(), null);
		return "admin/listcard";
	}

	@RequestMapping("getTeacherCard.action")
	public String getTeacherCard(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Card card = new Card();
		card.setTeacherid(adminid);
		List<Card> cardList = this.cardService.getCardByCond(card);
		PageHelper.getUserPage(cardList, "card", "getTeacherCard", 10, number, this.getRequest());
		return "admin/xlistcard";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCardByCond.action")
	public String queryCardByCond(String cond, String name, String number) {
		Card card = new Card();
		if (cond != null) {
			if ("cardno".equals(cond)) {
				card.setCardno(name);
			}
			if ("usersid".equals(cond)) {
				card.setUsersid(name);
			}
			if ("courseid".equals(cond)) {
				card.setCourseid(name);
			}
			if ("money".equals(cond)) {
				card.setMoney(name);
			}
			if ("addtime".equals(cond)) {
				card.setAddtime(name);
			}
			if ("num".equals(cond)) {
				card.setNum(name);
			}
			if ("usenum".equals(cond)) {
				card.setUsenum(name);
			}
			if ("surnum".equals(cond)) {
				card.setSurnum(name);
			}
			if ("memo".equals(cond)) {
				card.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.cardService.getCardByLike(card), "card", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycard";
	}

	// 按主键查询数据
	@RequestMapping("getCardById.action")
	public String getCardById(String id) {
		Card card = this.cardService.getCardById(id);
		this.getRequest().setAttribute("card", card);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Course> courseList = this.courseService.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		return "admin/editcard";
	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

}
// 
