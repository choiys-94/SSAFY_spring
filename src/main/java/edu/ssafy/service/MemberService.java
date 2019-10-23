package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.MemDTO;

public interface MemberService {
	public void insert(String id, String pw, String name, String tel);
	public void update(String id, String pw, String name, String tel);
	public void delete(String id);
	public MemDTO selectOne(String id);
	public List<MemDTO> selectList();
	public boolean isLogin(String id, String pw);
}
