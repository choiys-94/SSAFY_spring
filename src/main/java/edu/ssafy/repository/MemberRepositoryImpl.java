package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemberDTO;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository{
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	
	public MemberRepositoryImpl() {
	}
	
	public void insert(MemberDTO m) {
		list.add(m);
	}
	
	public void update(MemberDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(m.getId())) {
				list.set(i, m);
				break;
			}
		}
	}
	
	public void delete(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(m)) {
				list.remove(i);
				break;
			}
		}
	}
	
	public MemberDTO selectOne(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(m)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<MemberDTO> selectList(){
		return list;
	}

	@Override
	public boolean isLogin(String id, String pw) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
}
