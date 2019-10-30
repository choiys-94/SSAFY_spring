package edu.ssafy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService ser;
	
	@RequestMapping("/proregpage")
	public String memRegPage(){
		return "/product/proreg";
	}
	
	@RequestMapping("/proreg")
	public ModelAndView proReg(ProductDTO pro, ModelAndView mv){
		ser.insert(pro.getNum(), pro.getName(), pro.getPrice());
		
		mv.setViewName("redirect:prolist");
		return mv;
	}
	
	@RequestMapping("/prolist")
	public ModelAndView proList(ModelAndView mv){
		List<ProductDTO> list = ser.selectList();
		mv.addObject("pros", list);
		mv.setViewName("/product/prolist");
		return mv;
	}
	
	@RequestMapping("/proview")
	public ModelAndView proView(@RequestParam("num") String num, ModelAndView mv){
		ProductDTO pro = ser.selectOne(num);
		mv.addObject("pro", pro);
		mv.setViewName("/product/proview");
		return mv;
	}
	
	@RequestMapping("/prodelete")
	public ModelAndView memDelete(@RequestParam("num") String num, ModelAndView mv){
		ser.delete(num);
		mv.setViewName("redirect:prolist");
		return mv;
	}
	
	@RequestMapping("/proupdate")
	public ModelAndView memUpdate(ProductDTO pro, ModelAndView mv){
		ser.update(pro.getNum(), pro.getName(), pro.getPrice());
		mv.setViewName("redirect:prolist");
		return mv;
	}
}
