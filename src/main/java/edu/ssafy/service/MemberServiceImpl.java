package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	@Qualifier("MemberRepositoryImpl")
	MemberRepository repo;

	public MemberServiceImpl() {
	}
	
	@Override
	public void insert(String id, String pw, String name, String tel) {
		repo.insert(new MemDTO(id, pw, name, tel));
	}

	@Override
	public void update(String id, String pw, String name, String tel) {
		repo.update(new MemDTO(id, pw, name, tel));		
	}

	@Override
	public void delete(String id) {
		repo.delete(id);		
	}

	@Override
	public MemDTO selectOne(String id) {
		return repo.selectOne(id);
	}

	@Override
	public List<MemDTO> selectList() {
		return repo.selectList();
	}

	@Override
	public boolean isLogin(String id, String pw) {
		return repo.isLogin(id, pw);
	}
}
