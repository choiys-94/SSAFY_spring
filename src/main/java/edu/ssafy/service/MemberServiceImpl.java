package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	@Qualifier("MemberMybatisRepositoryImpl")
	MemberRepository repo;

	public MemberServiceImpl() {
	}
	
	@Override
	@Transactional
	public void insert(String id, String pw, String name, String tel) throws MyException {
		repo.insert(new MemberDTO(id, pw, name, tel));
		repo.insert(new MemberDTO(id, pw, name, tel));
		repo.insert(new MemberDTO(id, pw, name, tel));
		repo.insert(new MemberDTO(id, pw, name, tel));
	}

	@Override
	@Transactional
	public void update(String id, String pw, String name, String tel) {
		repo.update(new MemberDTO(id, pw, name, tel));		
	}

	@Override
	@Transactional
	public void delete(String id) {
		repo.delete(id);		
	}

	@Override
	public MemberDTO selectOne(String id) {
		return repo.selectOne(id);
	}

	@Override
	public List<MemberDTO> selectList() {
		return repo.selectList();
	}

	@Override
	public boolean isLogin(String id, String pw) {
		return repo.isLogin(id, pw);
	}
}
