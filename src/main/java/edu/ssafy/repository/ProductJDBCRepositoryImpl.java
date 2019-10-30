package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.ProductDTO;
import edu.ssafy.util.JDBCProxy;

@Repository("ProductJDBCRepositoryImpl")
public class ProductJDBCRepositoryImpl implements ProductRepository{

	@Override
	public int insert(ProductDTO m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "insert into product(num, name, price) values (?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, m.getNum());
			st.setString(2, m.getName());
			st.setInt(3, m.getPrice());
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
			return 0;
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public int update(ProductDTO m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "update product set name=?, price=? where num=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m.getName());
			st.setInt(2, m.getPrice());
			st.setString(3, m.getNum());
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
			return 0;
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public int delete(String m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "delete from product where num=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m);
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
			return 0;
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public ProductDTO selectOne(String m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		ProductDTO dto = null;
		try {
			String sql = "select num, name, price from product where num=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m);
			rs = st.executeQuery();
			while(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				dto = new ProductDTO(num, name, price);
			}
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st, rs);
		}
		
		return null;
	}

	@Override
	public List<ProductDTO> selectList() {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		try {
			String sql = "select num, name, price from product";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				list.add(new ProductDTO(num, name, price));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st, rs);
		}
		
		return null;
	}
}