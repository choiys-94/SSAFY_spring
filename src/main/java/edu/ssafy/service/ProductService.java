package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.ProductDTO;

public interface ProductService {
	public void insert(String num, String name, String price);
	public void update(String num, String name, String price);
	public void delete(String num);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
