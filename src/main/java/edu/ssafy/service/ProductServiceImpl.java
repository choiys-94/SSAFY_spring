package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository repo;
	
	@Override
	public void insert(String num, String name, String price) {
		repo.insert(new ProductDTO(num, name, price));
	}
	
	@Override
	public void update(String num, String name, String price) {
		repo.update(new ProductDTO(num, name, price));
	}
	
	@Override
	public void delete(String num) {
		repo.delete(num);
	}
	
	@Override
	public ProductDTO selectOne(String num) {
		return repo.selectOne(num);
	}
	
	@Override
	public List<ProductDTO> selectList(){
		return repo.selectList();
	}
}
