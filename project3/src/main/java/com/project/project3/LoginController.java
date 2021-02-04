package com.project.project3;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.LoginService;

@Controller
public class LoginController {

	@Resource(name = "loginService")
	private LoginService loginService;

	@RequestMapping(value = "/loginProcess")
	public String loginProcess(HttpSession session, @RequestParam(value = "id") String id,
			@RequestParam(value = "pw") String pw) throws Exception {

		if (loginService.loginCheck(id, pw)) { // id,pw검사를 통해 True,false를 return
			session.setAttribute("loginCheck", true);
			session.setAttribute("id", id);
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value="/logoutProcess")
    public String logoutProcess(HttpSession session) {
                            
        session.setAttribute("loginCheck",null);
        session.setAttribute("id",null);
        
        return "index";
    }
    
    @RequestMapping(value="/needLogin")
    public String needLoginPage(HttpSession session) {
    
        //세션 검사를 통해 Access control
        if(session.getAttribute("loginCheck")!=null){
            return "needLogin";
        }else{
            return "login";
        }
    }
	
}
