package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student2.dao.IDDao;
import shin_student2.dto.ID;
import shin_student2.ui.exception.SqlConstraintException;
import shin_student2.util.JdbcUtil;

public class IDDaoImpl implements IDDao {
	private static final IDDaoImpl instance = new IDDaoImpl();

	private IDDaoImpl() {
	}

	public static IDDaoImpl getInstance() {
		return instance;
	}
	

	@Override
	public boolean selectId(ID id) {
		String sql = "select ID ,`grant`\r\n" + 
				"from manageruser \r\n" + 
				"where id = ? and pass = password(?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id.getId());
			pstmt.setString(2, id.getPass());
			System.out.println(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return rs.getBoolean("grant");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int insertId(ID id) {
		String sql = "insert into manageruser \r\n" + 
				"values (?,password(?),?,false)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id.getId());
			pstmt.setString(2, id.getPass());
			pstmt.setString(3, id.getEmail());
			
			return pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			throw new SqlConstraintException("이미 가입된 아이디 입니다.");
		}
	}

	@Override
	public int deleteId(ID id) {
		String sql = "delete from manageruser \r\n" + 
				"where id = ? and pass = password(?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id.getId());
			pstmt.setString(2, id.getPass());
			
			return pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updateID(ID id) {
		String sql = "update manageruser set `grant`=? where id= ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(2, id.getId());
			pstmt.setBoolean(1, id.isGrant());
			
			return pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ID> selectIdAll() {
		String sql = "select ID, `grant` from manageruser";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
				
			if(rs.next()) {
				List<ID> list = new ArrayList<ID>();
				do {
					list.add(new ID(rs.getString("ID"),rs.getBoolean("grant")));
				}while(rs.next());
				return list;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
