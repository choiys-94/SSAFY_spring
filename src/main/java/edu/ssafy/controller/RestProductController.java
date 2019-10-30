package edu.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.service.ProductService;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"*"}, maxAge=6000)
public class RestProductController {
private static final Logger logger = LoggerFactory.getLogger(RestProductController.class);
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService ser;
	
//	@RequestMapping("/proreg")
	@PostMapping("/proreg")
	@ApiOperation(value="Product 등록 서비스")
	public ResponseEntity<Map<String, Object>> proReg(@RequestBody ProductDTO pro){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(pro.getNum(), pro.getName(), pro.getPrice());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "등록 성공");
			map.put("resValue", insert);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "등록 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/prolist")
	@GetMapping("/prolist")
	@ApiOperation(value="전체 Product 조회 서비스")
	public ResponseEntity<Map<String, Object>> proList(){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			List<ProductDTO> list = ser.selectList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 성공");
			map.put("resValue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/proview")
	@GetMapping("/proview/{num}")
	@ApiOperation(value="특정 Product 조회 서비스")
	public ResponseEntity<Map<String, Object>> proView(@PathVariable("num") String num){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			ProductDTO pro = ser.selectOne(num);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", num + " 조회 성공");
			map.put("resValue", pro);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/prodelete/{num}")
	@DeleteMapping("/prodelete/{num}")
	@ApiOperation(value="특정 Product 삭제 서비스")
	public ResponseEntity<Map<String, Object>> memDelete(@PathVariable("num") String num){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = ser.delete(num);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", num + " 삭제 성공");
			map.put("resValue", delete);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping("/proupdate")
	@PutMapping("/proupdate")
	@ApiOperation(value="특정 Product 수정 서비스")
	public ResponseEntity<Map<String, Object>> memUpdate(@RequestBody ProductDTO pro){
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int update = ser.update(pro.getNum(), pro.getName(), pro.getPrice());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "수정 성공");
			map.put("resValue", update);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resMsg", "수정 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
