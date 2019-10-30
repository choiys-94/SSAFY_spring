package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;

public interface MemberService {
	public int insert(String id, String pw, String name, String tel)  throws MyException;
	public int update(String id, String pw, String name, String tel);
	public int delete(String id);
	public MemberDTO selectOne(String id);
	public List<MemberDTO> selectList();
	public boolean isLogin(String id, String pw);
}
