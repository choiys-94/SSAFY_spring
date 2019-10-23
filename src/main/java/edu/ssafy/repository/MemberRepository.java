package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.MemDTO;

public interface MemberRepository {
	public void insert(MemDTO m);
	public void update(MemDTO m);
	public void delete(String m);
	public MemDTO selectOne(String m);
	public List<MemDTO> selectList();
	public boolean isLogin(String id, String pw);
}
