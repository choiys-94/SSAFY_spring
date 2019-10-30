package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemberService;

@Controller
@RequestMapping("/api")
public class RestMemberController {
private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;
	
//	@RequestMapping(value="/memreg", method=RequestMethod.POST)
	@PostMapping("/memreg")
	public void memReg(@RequestBody MemberDTO m) throws MyException{
		try {
			int insert = ser.insert(m.getId(), m.getPw(), m.getName(), m.getTel());
		} catch(RuntimeException e) {
			
		}
	}
	
//	@RequestMapping(value="/memlist", method=RequestMethod.GET)
	@GetMapping("/memlist")
	public @ResponseBody List<MemberDTO> memList(){
		List<MemberDTO> list = null;
		try {
			list = ser.selectList();
		} catch (RuntimeException e) {
			
		}
		return list;
	}
	
//	@RequestMapping("/memview/{id}")
	@GetMapping("/memview/{id}")
	public @ResponseBody MemberDTO memView(@PathVariable("id") String id){
		MemberDTO mem = null;
		try {
			mem = ser.selectOne(id);
		} catch (RuntimeException e) {
			
		}
		return mem;
	}
	
//	@RequestMapping("/memdelete/{id}")
	@DeleteMapping("/memdelete/{id}")
	public void memDelete(@PathVariable("id") String id){
		try {
			int delete = ser.delete(id);
		} catch(RuntimeException e) {
		}
	}
	
//	@RequestMapping("/memupdate")
	@PutMapping("/memupdate")
	public void memUpdate(@RequestBody MemberDTO mem){
		try {
			int update = ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getTel());
		} catch(RuntimeException e) {
		}
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mv) {
		if(ser.isLogin(id, pw)) {
			mv.addObject("islogin", "1");
			req.getSession().setAttribute("userid", id);
		}
		else {
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
