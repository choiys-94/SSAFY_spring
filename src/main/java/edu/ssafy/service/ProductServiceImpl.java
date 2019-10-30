package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.repository.ProductRepository;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("ProductMybatisRepositoryImpl")
	ProductRepository repo;
	
	@Override
	@Transactional
	public int insert(String num, String name, int price) {
		return repo.insert(new ProductDTO(num, name, price));
	}
	
	@Override
	@Transactional
	public int update(String num, String name, int price) {
		return repo.update(new ProductDTO(num, name, price));
	}
	
	@Override
	@Transactional
	public int delete(String num) {
		return repo.delete(num);
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
