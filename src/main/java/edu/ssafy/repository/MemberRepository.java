package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;

public interface MemberRepository {
	public int insert(MemberDTO m) throws MyException;
	public int update(MemberDTO m);
	public int delete(String m);
	public MemberDTO selectOne(String m);
	public List<MemberDTO> selectList();
	public boolean isLogin(String id, String pw);
}
