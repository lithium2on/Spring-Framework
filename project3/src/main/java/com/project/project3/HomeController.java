package com.project.project3;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.dto.ProjectDTO;
import com.project.dto.RichDTO;
import com.project.dto.ListDTO;
import com.project.service.ProjectService;

import api.ApiBatch;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Resource(name = "projectService")
	private ProjectService projectService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/projectList.do")
	public String projectList(Model model) throws Exception {

		List<ProjectDTO> list = projectService.selectProjectList();

		logger.info(list.toString());

		model.addAttribute("list", list);
		System.out.println(list);

		return "projectList";
	}

	/**
	 * 게시판 등록폼
	 * 
	 * @param projectVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/projectRegisterForm.do")
	public String projectRegisterForm(@ModelAttribute("projectDTO") ProjectDTO projectDTO, Model model)
			throws Exception {

		return "projectRegisterForm";
	}

	/**
	 * 글을 등록합니다.
	 * 
	 * @return
	 */
	@RequestMapping("/projectInsert.do")
	public String projectInsert(@ModelAttribute("projectDTO") ProjectDTO projectDTO, Model model) {
		System.out.println(projectDTO);
		projectService.insertProject(projectDTO);

		return "redirect:/projectList.do";
	}

	/**
	 * 게시판 수정폼
	 * 
	 * @param projectVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/projectUpdateForm.do")
	public String projectUpdateForm(@ModelAttribute("projectDTO") ProjectDTO projectDTO, Model model) throws Exception {

		return "projectUpdateForm";
	}

	/**
	 * 글을 수정합니다.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/projectUpdate.do")
	public String projectUpdate(@ModelAttribute("projectDTO") ProjectDTO projectDTO, Model model) {

		projectService.updateProject(projectDTO);

		return "redirect:/projectList.do";
	}

	/**
	 * 글을 삭제합니다.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/projectDelete.do")
	public String projectDelete(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {

		projectService.deleteProject(projectDTO);

		return "redirect:/projectList.do";
	}

//	@RequestMapping("/android3")
//	public void androidTestWithRequest(HttpServletRequest request) {
//		logger.info("Welcome home! The client locale is {}.", request);
//		System.out.println(request.getParameter("PRO_ID"));
//		System.out.println(request.getParameter("PRO_TITLE"));
//	}

//	}
//	// 안드로이드 요청(id, pw 받아서 db연동)
//	@RequestMapping(value = "/android", method = { RequestMethod.POST })
//	public String androidPage(HttpServletRequest request, Model model) {
//		System.out.println("서버에서 안드로이드 접속 요청함");
//		
//		try {
//			String androidID = request.getParameter("PRO_ID");
//			String androidPW = request.getParameter("PRO_TITLE");
//			String androidBD = request.getParameter("PRO_BODY");
//			System.out.println("안드로이드에서 받아온 id : " + androidID);
//			System.out.println("안드로이드에서 받아온 pw : " + androidPW);
//			System.out.println("안드로이드에서 받아온 pw : " + androidBD);
//			model.addAttribute("android", androidID);
//			return "android";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "null";
//		}
//	}
//	@ResponseBody
//	@RequestMapping(value = "/android2/register", method = { RequestMethod.POST })
//	public String anRegister(@RequestParam("id") String id, @RequestParam("passwd") String passwd,
//			@RequestParam("email") String email, ProjectVO projectVO) {
//		System.out.println("안드로이드에서 회원가입 요청함");
//
//		projectVO.setId(id);
//		projectVO.setPasswd(passwd);
//		projectVO.setEmail(email);
//		System.out.println(id + passwd + email);
//
//		projectService.insertProject2(projectVO);
//		return "register";
//	}
	
//	android
	@ResponseBody
	@RequestMapping(value = "/android2/register", method = { RequestMethod.POST })
	public String Register(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
		System.out.println("안드로이드에서 회원가입 요청함");
		System.out.println(projectDTO);
		projectService.insertProject2(projectDTO);
		return "register";
	}

//	@RequestMapping("/projectInsert.do")
//	public String projectInsert(@ModelAttribute("projectVO") ProjectVO projectVO, Model model) {
//
//		projectService.insertProject(projectVO);
//
//		return "redirect:/projectList.do";
//	@RequestMapping("/projectList.do")
//	public String projectList(Model model) throws Exception {
//
//		List<ProjectVO> list = projectService.selectProjectList();
//
//		logger.info(list.toString());
//
//		model.addAttribute("list", list);
//		System.out.println(list);
//
//		return "projectList";
//	}
//	@ResponseBody
//	@RequestMapping(value = "/android2/login", method = { RequestMethod.GET, RequestMethod.POST })
//	public ProjectDTO anLogin(@ModelAttribute("projectVO") ProjectDTO projectDto) throws Exception {
//		System.out.println("anLogin()");
//
//		ProjectDTO login = projectService.loginProject(projectDto);
//		System.out.println("login : " + login);
//		return login;
//	}

	@ResponseBody
	@RequestMapping(value = "/android2/login", method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String Login(@ModelAttribute("projectDTO") ProjectDTO projectDTO) throws Exception {
		System.out.println("안드로이드에서 로그인 요청함");
		Date now = new Date();
		System.out.println(now);
		// System.out.println("mapper 가기전" + projectVO);
		// List<ProjectVO> list = projectService.loginProject(projectVO);
		JsonObject json = new JsonObject();
		ProjectDTO login = projectService.loginProject(projectDTO);

		// logger.info(list.toString());

		// model.addAttribute("android2/login", list);
		// System.out.println("mapper 간 후" + projectVO);
//		logger.info(login.toString());
//
//		model.addAttribute("list", login);
		System.out.println("login : " + login);
		if (login != null) {
//			logger.info("DB 암호 해독   패스워드 " + login.getPasswd());
//			logger.info("유저 아이디   " + login.getId());
			// 널이 아니면 이메일이 존재하는 것이다. 따라서 등록된 가입자 이다.
			System.out.println("비번이 맞네 이전");
			// 패스워드 매치를 통해 다시 비밀번호 확인 한다
			System.out.println(projectDTO.getPasswd());
			System.out.println(login.getPasswd());

			if (projectDTO.getPasswd().equals(login.getPasswd())) {
//				if (3 == 3) {
				// 로그인 성공 - 로그인이 가능한 유저 확인 정보 가져오기
				System.out.println("비번이 맞네 ㅎㅎ");
				// MemberDTO loginUser = memberService.viewMember(member.getUserid());
				json.addProperty("message", login.getId() + " 님 환영합니다.");
				json.addProperty("id", login.getId());
				json.addProperty("passwd", login.getPasswd());
				json.addProperty("email", login.getEmail());
//				json.put("userid", loginUser.getUserid());
//				json.put("username", loginUser.getUsername());
//				json.put("email", loginUser.getEmail());
//				json.put("tel", loginUser.getTel());

			} else {
				// 비밀 번호 오류
				json.addProperty("message", "비밀 번호가 틀립니다.");
			}

		} else {
			// 등록 되지 않은 이메일
			json.addProperty("message", "등록 되지 않은 이메일 입니다.");

		}
		System.out.println(json);
		return json.toString(); // json 객체 리턴

	}
//	@ResponseBody
//	@RequestMapping(value = "/android2/login", method = { RequestMethod.POST },produces="application/json;charset=utf-8")
//	public ProjectVO anLogin(@ModelAttribute("projectVO") ProjectVO projectVO) throws Exception {
//		System.out.println("안드로이드에서 로그인 요청함");
//		Date now = new Date();
//		System.out.println(now);
//		System.out.println("mapper 가기전"+projectVO);
//		// List<ProjectVO> list = projectService.loginProject(projectVO);
//		ProjectVO login = projectService.loginProject(projectVO);
//
//		// logger.info(list.toString());
//
//		// model.addAttribute("android2/login", list);
//		System.out.println("mapper 간 후"+projectVO);
//		System.out.println(login);
//
////		logger.info(login.toString());
////
////		model.addAttribute("list", login);
//		System.out.println("login"+login);
//
//		return login;
//	}

//	@ResponseBody
//	@RequestMapping(value = "/android2/login2", method = { RequestMethod.POST })
//	public Map<String, Object> anLogin2(HttpServletRequest request, HttpServletResponse response, ProjectVO projectVO)
//			throws Exception {
//		System.out.println("안드로이드에서 로그인 요청함");
//
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
//
//		projectVO.setId(id);
//		projectVO.setPasswd(passwd);
//
//		System.out.println(id + passwd);
//
//		projectService.loginProject(projectVO);
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", projectVO.getId());
//		map.put("passwd", projectVO.getPasswd());
//
//		return map;
//	}

	@ResponseBody
	@RequestMapping(value = "/android2/list", method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String list() throws Exception {
		Gson gson = new Gson();
		List<ListDTO> list = projectService.listProject();

		String jsonPlace = gson.toJson(list);

//		json.addProperty("id",list.get(id) );
//		json.addProperty("price",list.getPrice() );
//		json.addProperty("day",list.getDay() );
//		json.addProperty("title",list.getTitle() );
//		json.addProperty("body",list.getBody() );
		System.out.println(jsonPlace);
		return jsonPlace.toString();

	}

	@ResponseBody
	@RequestMapping(value = "/android2/listInsert", method = { RequestMethod.POST })
	public String listInsert(@ModelAttribute("listDTO") ListDTO listDTO) {
		System.out.println(listDTO);
		projectService.insertList(listDTO);
		return "insert commit";
	}

	@ResponseBody
	@RequestMapping(value = "/android2/listDetail", method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String listDetail(@ModelAttribute("listDTO") ListDTO listDTO) throws Exception {
		JsonObject json = new JsonObject();
		ListDTO list = projectService.listDetail(listDTO);

		json.addProperty("title", list.getTitle());
		json.addProperty("body", list.getBody());
		System.out.println(json);
		return json.toString(); // json 객체 리턴

	}

//	@ResponseBody
//	@RequestMapping(value = "/android2/listDetail", method = {
//			RequestMethod.POST }, produces = "application/json;charset=utf-8")
//	public String listDetail(@ModelAttribute("listDTO") ListDTO listDTO) throws Exception {
//		Gson gson = new Gson();
//		List<ListDTO> list = projectService.listDetail(listDTO);
//
//		String jsonPlace = gson.toJson(list);
//		System.out.println(listDTO);
//		System.out.println(list);
//		System.out.println(jsonPlace);
//		return jsonPlace.toString();
//
//	}

//	test
	@ResponseBody
	@RequestMapping("/join")
	public String join() {
		return "ㅎㅇㅎㅇ";
	}

	@ResponseBody
	@RequestMapping("/join2")
	public ProjectDTO test(ProjectDTO projectDTO) throws Exception {
		projectDTO.setId("test");
		projectDTO.setPasswd("testName");
		return projectDTO;
	}

//	rich project
	@RequestMapping("/richList.do")
	public String richList(Model model) throws Exception {
		ApiBatch apiBatch = new ApiBatch();
		apiBatch.main(null);
		List<RichDTO> list = projectService.richList();

		logger.info(list.toString());

		model.addAttribute("list", list);
		System.out.println(list);

		return "richList";
	}
	


}
