package shin_student2.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;
import shin_student2.dto.Rank;
import shin_student2.util.JdbcUtil;

public class ComboBoxList {
	private static final ComboBoxList instance = new ComboBoxList();

	private ComboBoxList() {
	}

	public static ComboBoxList getInstance() {
		return instance;
	}
	public Object[] ComboListSelect(String sql, String sql1) {
		String a = "select * from " + sql;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				ArrayList<String> combolist = new ArrayList<String>();
				combolist.add("");
				do {
					combolist.add(rs.getString(sql1));
				} while (rs.next());
				
				return Arrays.stream(combolist.toArray()).distinct().sorted().toArray();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Rank> RankComboBox() {
		String a = "select rank, ranksco  from ranking";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				List<Rank> list = new ArrayList<Rank>();
				list.add(new Rank());
				do {
					list.add(new Rank(rs.getString("rank"),rs.getInt("ranksco")));
				} while (rs.next());
				
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Days> DaysComboBox() {
		String a = "select * from days";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				List<Days> list = new ArrayList<Days>();
				list.add(new Days());
				do {
					list.add(new Days(rs.getInt("dayTimeno"),rs.getString("dayTimename")));
				} while (rs.next());
				
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Department> DeptComboBox() {
		String a = "select * from department";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {
			
			if (rs.next()) {
				List<Department> list = new ArrayList<Department>();
				list.add(new Department());
				do {
					list.add(new Department(rs.getInt("deptno"),rs.getString("deptname")));
				} while (rs.next());
				
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Attendings> AtdComboBox() {
		String a = "select * from attendings";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {
			
			if (rs.next()) {
				List<Attendings> list = new ArrayList<Attendings>();
				list.add(new Attendings());
				do {
					list.add(new Attendings(rs.getString("atdno"),rs.getString("atdname")));
				} while (rs.next());
				
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Militarys> MiltComboBox() {
		String a = "select * from militarys";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(a);
				ResultSet rs = pstmt.executeQuery()) {
			
			if (rs.next()) {
				List<Militarys> list = new ArrayList<Militarys>();
				list.add(new Militarys());
				do {
					list.add(new Militarys(rs.getString("miltno"),rs.getString("miltname")));
				} while (rs.next());
				
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
