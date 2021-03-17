package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shin_student2.dao.ScoreDao;
import shin_student2.dto.Student;
import shin_student2.util.JdbcUtil;

public class ScoreDaoImpl implements ScoreDao {
	
	private static final ScoreDaoImpl instance = new ScoreDaoImpl();

	private ScoreDaoImpl() {
	}

	public static ScoreDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void scoUpdate(Student student) {
		String sql = "update scores  \r\n" + 
				"	set score = ?  \r\n" + 
				"	where subjectno = ? and stdno = ?  ";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			for (int i = 0; i < student.getScores().size();i++) {
				pstmt.setInt(1, student.getScores().get(i).getScoer());
				pstmt.setInt(2, student.getScores().get(i).getSubject().getSubNo());
				pstmt.setInt(3, student.getNo());
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
