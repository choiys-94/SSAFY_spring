package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("ProductMybatisRepositoryImpl")
	ProductRepository repo;
	
	@Override
	@Transactional
	public void insert(String num, String name, int price) {
		repo.insert(new ProductDTO(num, name, price));
	}
	
	@Override
	@Transactional
	public void update(String num, String name, int price) {
		repo.update(new ProductDTO(num, name, price));
	}
	
	@Override
	@Transactional
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
