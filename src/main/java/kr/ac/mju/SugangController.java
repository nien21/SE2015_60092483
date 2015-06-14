package kr.ac.mju;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Lecture;
import kr.ac.mju.LectureDAO;
import kr.ac.mju.Constants;
import kr.ac.mju.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SugangController {
	@Autowired
	private SugangDAO sugangDAO;
	@RequestMapping(value = "/sugangController/getSugangList", method = RequestMethod.POST)
	public ModelAndView getSugangList(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","");
		int lectureId = Integer.parseInt(request.getParameter("lectureID"));
		User user = (User) request.getSession().getAttribute("userSession");
		if(user.getType().equals("교수")) {
			Vector<Sugang> sugangs = sugangDAO.selectByLecture(lectureId, user.getName());
			if(!sugangs.isEmpty()) {
				mav.addObject("sugangArray", sugangs);
				mav.setViewName("gradeAssign");
			} else {
				LectureDAO lectureDAO = new LectureDAO();
				mav.addObject("lectureArray", lectureDAO .searchByProf(user.getName()));
				mav.addObject("msg", Constants.ScoreMsg.WRONG.getMsg());
				mav.setViewName("gradeAssignMain");
			}
		}
		return mav;
	}
	@RequestMapping(value = "/sugangController/gradeAssignMain", method = RequestMethod.GET)
	public ModelAndView getLectureList(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		mav.getModel().remove("msg");
		User user = (User) request.getSession().getAttribute("userSession");
		if (user.getType().equals("학생")) {
			mav.addObject("lectureArray", sugangDAO.selectByStu(user.getName()));
		
			mav.setViewName("viewGrade");
		}
		return mav;
	}
	
	@RequestMapping(value = "/sugangController/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		int lectureID = Integer.parseInt( request.getParameter("lectureID"));
		String professorName = request.getParameter("professorName");
		String result = request.getParameter("result");
		User user = (User) request.getSession().getAttribute("userSession");
		LectureDAO lectureDAO = new LectureDAO();
		Lecture lecture = lectureDAO.searchByLectureID(lectureID);
		
		mav.addObject("msg","");
		if(lecture.getCurrentMaxNum() < lecture.getMaxNum()) {
			if(sugangDAO.checkRegister(lectureID, professorName, user.getName()) == null) {
				if(sugangDAO.create(new Sugang(lectureID, user.getName(), professorName, result))) {
					lectureDAO.update(lectureID);
					mav.addObject("msg", Constants.RegisterMsg.LECTUREREGISTER.getMsg());
				}
			} else {
				mav.addObject("msg", Constants.RegisterMsg.FAILREGISTER.getMsg());
				
			}
			
		} else {
			mav.addObject("msg", Constants.RegisterMsg.MAXOVER.getMsg());
			
		}
		mav.setViewName("page");
		return mav;
	}
	
	@RequestMapping(value = "/assignController/gradeAssign", method = RequestMethod.POST)
	public ModelAndView giveScore(HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		int lectureId = Integer.parseInt( request.getParameter("lectureID"));
		String studentName = request.getParameter("studentName");
		String result = request.getParameter("result");
		User user = (User) request.getSession().getAttribute("userSession");
		SugangDAO scoreDAO = new SugangDAO();
		
		mav.addObject("msg","");
		if(scoreDAO.update(new Sugang(lectureId, studentName, user.getName(), result))) {
			mav.addObject("msg", Constants.ScoreMsg.Success.getMsg());
			mav.addObject("sugangArray", sugangDAO.selectByLecture(lectureId, user.getName()));
			mav.setViewName("gradeAssign");
		} else {
			mav.addObject("msg", Constants.ScoreMsg.Fail.getMsg());
		}
		
		return mav;
	}

	
}
