package kr.ac.mju;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Constants;
import kr.ac.mju.User;
import kr.ac.mju.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class JoinController {
    @Autowired
    private UserDao userDAO;
    
    @RequestMapping(value = "/joinController/regMember.do", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("userID");
        String password = request.getParameter("userPassword");
        String name = request.getParameter("name");
        String type = request.getParameter("type");

        ModelAndView mav = new ModelAndView();
        User user = new User(id, password, name, type);
        if(userDAO.create(new User(id, password, name, type))) {
            mav.setViewName("page");
            mav.addObject("msg", Constants.RegisterMsg.USEREGISTER.getMsg());
            request.getSession().setAttribute("userSession", user);
        }
        return mav;
    }
}
