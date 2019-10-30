package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemberDTO;
import edu.ssafy.exception.MyException;
import edu.ssafy.util.JDBCProxy;

//@Repository("MemberJDBCTemplateRepositoryImpl")
public class MemberJDBCTemplateRepositoryImpl implements MemberRepository{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(MemberDTO m) throws MyException {
		String sql = "insert into members(id, pw, name, tel) values (?, ?, ?, ?)";
		return jt.update(sql, new Object[] {m.getId(), m.getPw(), m.getName(), m.getTel()});
	}

	@Override
	public int update(MemberDTO m) {
		String sql = "update members set pw=?, name=?, tel=? where id=?";
		return jt.update(sql, new Object[] {m.getPw(), m.getName(), m.getTel(), m.getId()});		
	}

	@Override
	public int delete(String m) {
		String sql = "delete from members where id=?";
		return jt.update(sql, new Object[] {m});
	}

	class MemberMapper implements RowMapper<MemberDTO>{
		@Override
		public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDTO m = new MemberDTO();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setTel(rs.getString("tel"));
			return m;
		}
	}
	
	@Override
	public MemberDTO selectOne(String m) {
		String sql = "select id, pw, name, tel from members where id=?";
		MemberDTO dto = jt.queryForObject(sql, new Object[] {m}, new MemberMapper());
		return dto;
	}

	@Override
	public List<MemberDTO> selectList() {
		String sql = "select id, pw, name, tel from members";
		List<MemberDTO> list = jt.query(sql, new MemberMapper());
		return list;
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
