package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService service;
    
    @RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
    
        
        ModelAndView mav = service.checkLogin(id, pwd);
        User user = service.getUser();
        
        if(mav.getModel().get("msg").equals(Constants.LoginMsg.SUCCESS.getMsg())) {
            request.getSession().setAttribute("userSession", user);
        } 
        
        return mav;
    }
    
    @RequestMapping(value = "/loginController/login.do", method = RequestMethod.GET)
    public ModelAndView relogin(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav = new ModelAndView();
        mav.getModel().remove("msg");
        mav.setViewName("page");
        return mav;
    }
    @RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        request.getSession().removeAttribute("userSession");

        return "redirect:/";
            
    }
}
