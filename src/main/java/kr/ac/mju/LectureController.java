package kr.ac.mju;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Constants;
import kr.ac.mju.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LectureController {
	@Autowired
	private LectureDAO lectureDAO;
	@RequestMapping(value = "/lectureController/getGradeAssignMain", method = RequestMethod.GET)
	public ModelAndView gradeAssign(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("getGradeAssignMain");
		User user = (User) request.getSession().getAttribute("userSession");
		
		mav.addObject("msg","");
		if(user.getType().equals("교수")) {
			mav.addObject("lectureArray", lectureDAO.searchByProf(user.getName()));
			mav.setViewName("gradeAssignMain");
		} else if (user.getType().equals("학생")){
			mav.addObject("lectureArray", lectureDAO.read());
			mav.setViewName("sugang");
		}
		return mav;
	}
	
	@RequestMapping(value = "/lectureController/regLecture", method = RequestMethod.GET)
	public ModelAndView regLecture(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("regLecture");
		mav.addObject("msg","");
		return mav;
	}
	
	@RequestMapping(value = "lectureController/register.do", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt( request.getParameter("id"));
		int year = Integer.parseInt( request.getParameter("year"));
		int grade = Integer.parseInt( request.getParameter("grade"));
		int maxNum = Integer.parseInt( request.getParameter("maxNum"));
		int credit = Integer.parseInt( request.getParameter("credit"));
		String name = request.getParameter("name");

		User user = (User) request.getSession().getAttribute("userSession");
		lectureDAO.create(new Lecture(id, name, user.getName(), year, grade, maxNum, credit));
		mav.setViewName("page");
		mav.addObject("msg", Constants.CreateMsg.LECTURE.getMsg());
		return mav;
	}
}
