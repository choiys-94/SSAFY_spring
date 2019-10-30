package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private List<ProductDTO> list = new ArrayList<ProductDTO>();
	
	public int insert(ProductDTO m) {
		if(list.add(m))
			return 1;
		
		return 0;
	}
	
	public int update(ProductDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m.getNum())) {
				list.set(i, m);
				return i;
			}
		}
		return 0;
	}
	
	public int delete(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				list.remove(i);
				return i;
			}
		}
		return 0;
	}
	
	public ProductDTO selectOne(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public List<ProductDTO> selectList(){
		return list;
	}

}
