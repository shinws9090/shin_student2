package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		String sql = "select ID \r\n" + 
				"from manageruser \r\n" + 
				"where id = ? and pass = password(?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id.getId());
			pstmt.setString(2, id.getPass());
			System.out.println(pstmt);
			
			return pstmt.executeQuery().first();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int insertId(ID id) {
		String sql = "insert into manageruser \r\n" + 
				"values (?,password(?),?)";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
