package edu.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="testmodelandview")
	public ModelAndView test(HttpServletRequest req, ModelAndView m) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		m.addObject("message", "Hello SSAFY " + id + ", " + pw);
//		m.setViewName("result");
		m.setViewName("redirect:result.jsp");
		return m;
	}
	
	@RequestMapping(value="testmodel")
	public String test(HttpServletRequest req, Model m) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		m.addAttribute("message", "Hello SSAFY " + id + ", " + pw);
//		return "result";
//		return "forward:result";
		return "forward:result.jsp";
	}
	
	@Autowired
	private MemberDTO dto;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println(dto.toString());
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
