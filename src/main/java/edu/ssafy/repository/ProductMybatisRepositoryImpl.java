package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;

@Repository("ProductMybatisRepositoryImpl")
public class ProductMybatisRepositoryImpl implements ProductRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public int insert(ProductDTO p) {
		return session.insert("ssafy.product.insert", p);
	}

	@Override
	public int update(ProductDTO p) {
		return session.update("ssafy.product.update", p);
	}

	@Override
	public int delete(String num) {
		return session.delete("ssafy.product.delete", num);
	}

	@Override
	public ProductDTO selectOne(String num) {
		ProductDTO dto = session.selectOne("ssafy.product.selectOne", num);
		return dto;
	}

	@Override
	public List<ProductDTO> selectList() {
		List<ProductDTO> list = session.selectList("ssafy.product.selectList");
		return list;
	}

}
