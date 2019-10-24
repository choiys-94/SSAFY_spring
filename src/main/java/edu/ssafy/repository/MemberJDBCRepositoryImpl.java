package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.util.JDBCProxy;

@Repository("MemberJDBCRepositoryImpl")
public class MemberJDBCRepositoryImpl implements MemberRepository{

	@Override
	public void insert(MemberDTO m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "insert into members(id, pw, name, tel) values (?, ?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, m.getId());
			st.setString(2, m.getPw());
			st.setString(3, m.getName());
			st.setString(4, m.getTel());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public void update(MemberDTO m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "update members set pw=?, name=?, tel=? where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m.getPw());
			st.setString(2, m.getName());
			st.setString(3, m.getTel());
			st.setString(4, m.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public void delete(String m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		try {
			String sql = "delete from members where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st);
		}
	}

	@Override
	public MemberDTO selectOne(String m) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		try {
			String sql = "select id, pw, name, tel from members where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, m);
			rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				dto = new MemberDTO(id, pw, name, tel);
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
	public List<MemberDTO> selectList() {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			String sql = "select id, pw, name, tel from members";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				list.add(new MemberDTO(id, pw, name, tel));
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

	@Override
	public boolean isLogin(String id, String pw) {
		Connection conn = JDBCProxy.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean res = false;
		try {
			String sql = "select 1 from members where id=? and pw=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			while(rs.next()) {
				res = true; 
			}
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error!");
		} finally {
			JDBCProxy.close(conn, st, rs);
		}
		
		return false;
	}

}
