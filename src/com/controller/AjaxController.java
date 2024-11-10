package com.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Card;
import com.service.CardService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ajax", produces = "text/plain;charset=utf-8")
public class AjaxController extends BaseController {
	@Autowired
	private CardService cardService;

	@RequestMapping("getCard.action")
	@ResponseBody
	public String getCard() throws JSONException {
		String courseid = this.getRequest().getParameter("courseid");
		Card card = new Card();
		card.setCourseid(courseid);
		List<Card> cardList = this.cardService.getCardByCond(card);
		JSONArray cardid = new JSONArray(); // 存放ID
		JSONArray cardno = new JSONArray(); // 存放名称
		for (Card x : cardList) {
			if (!"0".equals(x.getSurnum())) {
				cardid.put(x.getCardid());
				cardno.put(x.getCardno());
			}
		}
		JSONObject json = new JSONObject();
		json.put("cardid", cardid.toString().replaceAll("\"", ""));
		json.put("cardno", cardno.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
