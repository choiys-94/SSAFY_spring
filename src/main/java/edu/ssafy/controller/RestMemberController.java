package edu.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;

//@Controller
@RestController
// RequestBody, ResponseBody 안써도 되게끔 rest 컨트롤러로 만들어줌
// 그런데 다른 서버에서 들어올 경우 못받음
@CrossOrigin(origins= {"*"}, maxAge=6000)
// 다른 서버에서 받을 수 있게끔.
// maxAge 6초
@RequestMapping("/api")
public class RestMemberController {
private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;
	
//	@RequestMapping(value="/memreg", method=RequestMethod.POST)
	@PostMapping("/memreg")
	@ApiOperation(value="Member 등록 서비스")
	// AppConfig에서 Swagger2를 이용해 문서를 만들기 위한 것
	public ResponseEntity<Map<String, Object>> memReg(@RequestBody MemberDTO m) throws MyException{
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(m.getId(), m.getPw(), m.getName(), m.getTel());
//			String msg = insert + " 입력했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resMsg", "입력 성공");
			msg.put("resValue", insert);
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		} catch(RuntimeException e) {
//			String msg = "입력 실패했습니다";
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("resMsg", "입력 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping(value="/memlist", method=RequestMethod.GET)
	@GetMapping("/memlist")
	@ApiOperation(value="전체 Member 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memList(){
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<MemberDTO> list = null;
		try {
			list = ser.selectList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 성공");
			map.put("resValue", list);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/memview/{id}")
	@GetMapping("/memview/{id}")
	@ApiOperation(value="id를 받아 특정 Member 조회 서비스", response=MemberDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> memView(@PathVariable("id") String id){
		ResponseEntity<Map<String, Object>> resEntity = null;
		MemberDTO mem = null;
		try {
			mem = ser.selectOne(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", id + " 조회 성공");
			map.put("resValue", mem);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/memdelete/{id}")
	@DeleteMapping("/memdelete/{id}")
	@ApiOperation(value="id를 받아 특정 Member 삭제 서비스")
	public ResponseEntity<Map<String, Object>> memDelete(@PathVariable("id") String id){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = ser.delete(id);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", id + " 삭제 성공");
			map.put("resValue", delete);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch(RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "삭제 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/memupdate")
	@PutMapping("/memupdate")
	@ApiOperation(value="id를 받아 특정 Member 수정 서비스")
	public ResponseEntity<Map<String, Object>> memUpdate(@RequestBody MemberDTO mem){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int update = ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getTel());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "수정 성공");
			map.put("resValue", update);
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch(RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "수정 실패");
			resEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
