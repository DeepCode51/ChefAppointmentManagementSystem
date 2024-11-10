package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Bbs;
import com.entity.Card;
import com.entity.Cate;
import com.entity.Checkin;
import com.entity.Complains;
import com.entity.Course;
import com.entity.Equipment;
import com.entity.Orders;
import com.entity.Rebbs;
import com.entity.Teacher;
import com.entity.Topic;
import com.entity.Users;
import com.service.ArticleService;
import com.service.BbsService;
import com.service.CardService;
import com.service.CateService;
import com.service.CheckinService;
import com.service.ComplainsService;
import com.service.CourseService;
import com.service.EquipmentService;
import com.service.OrdersService;
import com.service.RebbsService;
import com.service.TeacherService;
import com.service.TopicService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CateService cateService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CardService cardService;
	@Autowired
	private CheckinService checkinService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private RebbsService rebbsService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "厨师预约系统");
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Course> hotList = this.courseService.getCourseByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getCateFront();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Course> courseList = this.courseService.getCourseByCate(cate.getCateid());
			cate.setCourseList(courseList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Teacher> teacherList = this.teacherService.getFrontTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		return "users/index";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", null, 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if ("锁定".equals(users.getStatus())) {
				this.getSession().setAttribute("message", "账户被锁定");
				return "redirect:/index/preLogin.action";
			}
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setStatus("锁定");
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs() {
		this.front();
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsService.insertBbs(bbs);
		return "redirect:/index/bbs.action";
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsService.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsService.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsService.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsService.insertRebbs(rebbs);
		Bbs bbs = this.bbsService.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsService.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("teacher.action")
	public String teacher(String number) {
		this.front();
		List<Teacher> teacherList = this.teacherService.getAllTeacher();
		PageHelper.getIndexPage(teacherList, "teacher", "teacher", null, 12, number, this.getRequest());
		return "users/teacher";
	}

	@RequestMapping("teacherDetail.action")
	public String teacherDetail(String id) {
		this.front();
		Teacher teacher = this.teacherService.getTeacherById(id);
		this.getRequest().setAttribute("teacher", teacher);
		Topic topic = new Topic();
		topic.setTeacherid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		return "users/teacherDetail";
	}

	@RequestMapping("equipment.action")
	public String equipment(String number) {
		this.front();
		Equipment equipment = new Equipment();
		equipment.setStatus("正常");
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(equipment);
		PageHelper.getIndexPage(equipmentList, "equipment", "equipment", null, 12, number, this.getRequest());
		return "users/equipment";
	}

	@RequestMapping("equipmentDetail.action")
	public String equipmentDetail(String id) {
		this.front();
		Equipment equipment = this.equipmentService.getEquipmentById(id);
		this.getRequest().setAttribute("equipment", equipment);
		return "users/equipmentDetail";
	}

	@RequestMapping("course.action")
	public String course(String number) {
		this.front();
		List<Course> courseList = this.courseService.getAllCourse();
		PageHelper.getIndexPage(courseList, "course", "course", null, 12, number, this.getRequest());
		return "users/course";
	}

	@RequestMapping("cate.action")
	public String course(String number, String id) {
		this.front();
		Course course = new Course();
		course.setCateid(id);
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getIndexPage(courseList, "course", "cate", id, 12, number, this.getRequest());
		return "users/course";
	}

	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		Course course = new Course();
		course.setRecommend("是");
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getIndexPage(courseList, "course", "recommend", null, 12, number, this.getRequest());
		return "users/course";
	}

	@RequestMapping("special.action")
	public String special(String number) {
		this.front();
		Course course = new Course();
		course.setSpecial("是");
		List<Course> courseList = this.courseService.getCourseByCond(course);
		PageHelper.getIndexPage(courseList, "course", "special", null, 12, number, this.getRequest());
		return "users/course";
	}

	@RequestMapping("query.action")
	public String query(String number, String id) {
		this.front();
		Course course = new Course();
		course.setCoursename(this.getRequest().getParameter("keywords"));
		List<Course> courseList = this.courseService.getCourseByLike(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "users/course";
	}

	@RequestMapping("courseDetail.action")
	public String courseDetail(String id) {
		this.front();
		Course course = this.courseService.getCourseById(id);
		course.setHits("" + (Integer.parseInt(course.getHits()) + 1));
		this.getRequest().setAttribute("course", course);
		return "users/courseDetail";
	}

	@RequestMapping("myCard.action")
	public String myCard() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Card card = new Card();
		card.setUsersid(userid);
		List<Card> cardList = this.cardService.getCardByCond(card);
		this.getRequest().setAttribute("cardList", cardList);
		return "users/myCard";
	}

	@RequestMapping("myCheckin.action")
	public String myCheckin() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Checkin checkin = new Checkin();
		checkin.setUsersid(userid);
		List<Checkin> checkinList = this.checkinService.getCheckinByCond(checkin);
		this.getRequest().setAttribute("checkinList", checkinList);
		return "users/myCheckin";
	}

	@RequestMapping("preTopic.action")
	public String preTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("orders", orders);
		return "users/addTopic";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("已评价");
		this.ordersService.updateOrders(orders);
		Topic topic = new Topic();
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setUsersid(orders.getUsersid());
		topic.setTeacherid(orders.getTeacherid());
		topic.setNum(this.getRequest().getParameter("num"));
		topic.setContents(this.getRequest().getParameter("contents"));
		topic.setOrdersid(id);
		this.topicService.insertTopic(topic);
		return "redirect:/index/myorders.action";
	}

	@RequestMapping("preOrders.action")
	public String preOrders(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Teacher teacher = this.teacherService.getTeacherById(id);
		this.getRequest().setAttribute("teacher", teacher);
		this.getRequest().setAttribute("ordercode", "OD" + VeDate.getStringDatex());
		return "users/checkout";
	}

	@RequestMapping("addorder.action")
	public String addorder(Orders orders) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		orders.setUsersid(userid);
		orders.setStatus("未完成");
		Orders x = new Orders();
		x.setTeacherid(orders.getTeacherid());
		x.setSectionx(orders.getSectionx());
		x.setOrderdate(orders.getOrderdate());
		List<Orders> list = this.ordersService.getOrdersByCond(x);
		if (list.size() == 0) {
			this.ordersService.insertOrders(orders);
		} else {
			this.getSession().setAttribute("message", "已经有人预约");
			return "redirect:/index/teacherDetail.action?id=" + orders.getTeacherid();
		}
		return "redirect:/index/myorders.action";
	}

	@RequestMapping("myorders.action")
	public String myorders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> ordersList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(ordersList, "orders", "myorders", null, 10, number, this.getRequest());
		return "users/myorders";
	}
}
