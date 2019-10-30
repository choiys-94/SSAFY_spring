package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;

	@ExceptionHandler(MyException.class)
	public String myException(HttpServletRequest req, Exception e) {
		req.setAttribute("message", e.getMessage());
		return "myErrorPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String allException(HttpServletRequest req, Exception e) {
		req.setAttribute("message", e.getMessage());
		return "allErrorPage";
	}
	
	@RequestMapping("/memregpage")
	public String memRegPage(){
		return "/member/memreg";
	}
	
	@RequestMapping("/memreg")
	public ModelAndView memReg(HttpServletRequest req, ModelAndView mv) throws MyException{
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name  = req.getParameter("name");
		String tel = req.getParameter("tel");
		try {
			int insert = ser.insert(id, pw, name, tel);
			mv.addObject("cnt", insert);
			mv.setViewName("redirect:memlist");
		} catch(RuntimeException e) {
			mv.addObject("message", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		
		return mv;
	}
	
	@RequestMapping("/memlist")
	public ModelAndView memList(ModelAndView mv){
		List<MemberDTO> list = ser.selectList();
		mv.addObject("mems", list);
		mv.setViewName("/member/memlist");
		return mv;
	}
	
	@RequestMapping("/memview")
	public ModelAndView memView(@RequestParam("id") String id, ModelAndView mv){
//		String id = req.getParameter("id");
		MemberDTO mem = ser.selectOne(id);
		mv.addObject("mem", mem);
		mv.setViewName("/member/memview");
		return mv;
	}
	
	@RequestMapping("/memdelete")
	public ModelAndView memDelete(@RequestParam("id") String id, ModelAndView mv){
		try {
			int delete = ser.delete(id);
			mv.addObject("cnt", delete);
			mv.setViewName("redirect:memlist");
		} catch(RuntimeException e) {
			mv.addObject("message", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		
		return mv;
	}
	
	@RequestMapping("/memupdate")
	public ModelAndView memUpdate(MemberDTO mem, ModelAndView mv){
		try {
			int update = ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getTel());
			mv.addObject("cnt", update);
			mv.setViewName("redirect:memlist");
		} catch(RuntimeException e) {
			mv.addObject("message", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mv) {
		try {
			if(ser.isLogin(id, pw)) {
				mv.addObject("islogin", "1");
				req.getSession().setAttribute("userid", id);
			}
		} catch (Exception e) {
			mv.addObject("islogin", "0");
		}
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, ModelAndView mv) {
		req.getSession().invalidate();
		mv.setViewName("redirect:/");
		
		return mv;
	}
}
