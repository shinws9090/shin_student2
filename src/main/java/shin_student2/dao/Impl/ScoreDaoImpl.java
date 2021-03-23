package shin_student2.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shin_student2.dao.ScoreDao;
import shin_student2.dto.Score;
import shin_student2.dto.Student;
import shin_student2.dto.Subject;
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
		String sql = "update scores  \r\n" + "	set score = ?  \r\n" + "	where subjectno = ? and stdno = ?  ";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			for (int i = 0; i < student.getScores().size(); i++) {
				pstmt.setInt(1, student.getScores().get(i).getScoer());
				pstmt.setInt(2, student.getScores().get(i).getSubject().getSubNo());
				pstmt.setInt(3, student.getNo());
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Score> scoselect(Student student) {
		String sql = "select stdno, s.subjectno, score, subjectname\r\n"
				+ "from scores s join subjects s2 on s.subjectno = s2.subjectno \r\n" 
				+ "where stdno = ?;";
		try (Connection con = JdbcUtil.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, student.getNo());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Score> list = new ArrayList<Score>();
					do {
						list.add(getScore(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Score getScore(ResultSet rs) throws SQLException {

		return new Score(new Subject(rs.getInt("subjectno"), rs.getString("subjectname")), rs.getInt("score"));
	}

}
