package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository{
	private List<MemDTO> list = new ArrayList<MemDTO>();
	
	public MemberRepositoryImpl() {
	}
	
	public void insert(MemDTO m) {
		list.add(m);
	}
	
	public void update(MemDTO m) {
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
	
	public MemDTO selectOne(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(m)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<MemDTO> selectList(){
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
