package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	private List<ProductDTO> list = new ArrayList<ProductDTO>();
	
	public void insert(ProductDTO m) {
		list.add(m);
	}
	
	public void update(ProductDTO m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m.getNum())) {
				list.set(i, m);
				break;
			}
		}
	}
	
	public void delete(String m) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(m)) {
				list.remove(i);
				break;
			}
		}
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
