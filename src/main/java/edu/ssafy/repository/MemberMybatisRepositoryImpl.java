package edu.ssafy.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;

@Repository("MemberMybatisRepositoryImpl")
public class MemberMybatisRepositoryImpl implements MemberRepository {
	@Autowired
	SqlSession session;
	
	@Override
	public void insert(MemberDTO m) throws MyException {
		session.insert("ssafy.member.insert", m);
	}

	@Override
	public void update(MemberDTO m) {
		session.update("ssafy.member.update", m);
	}

	@Override
	public void delete(String m) {
		session.delete("ssafy.member.delete", m);
	}

	@Override
	public MemberDTO selectOne(String m) {
		MemberDTO dto = session.selectOne("ssafy.member.selectOne", m);
		return dto;
	}

	@Override
	public List<MemberDTO> selectList() {
		List<MemberDTO> list = session.selectList("ssafy.member.selectList");
		return list;
	}

	@Override
	public boolean isLogin(String id, String pw) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		int res = session.selectOne("ssafy.member.login", map);
		if(res != 0)
			return true;
		
		return false;
	}

}
