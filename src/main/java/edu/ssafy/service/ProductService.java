package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.ProductDTO;

public interface ProductService {
	public int insert(String num, String name, int price);
	public int update(String num, String name, int price);
	public int delete(String num);
	public ProductDTO selectOne(String num);
	public List<ProductDTO> selectList();
}
