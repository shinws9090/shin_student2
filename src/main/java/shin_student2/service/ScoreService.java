package shin_student2.service;

import java.util.List;

import shin_student2.dao.Impl.ScoreDaoImpl;
import shin_student2.dto.Score;
import shin_student2.dto.Student;

public class ScoreService {
	private ScoreDaoImpl dao = ScoreDaoImpl.getInstance();

	private static final ScoreService instance = new ScoreService();

	private ScoreService() {
	}

	public static ScoreService getInstance() {
		return instance;
	}
	
	public void modifyScores(Student student) {
		dao.scoUpdate(student);
	}
	public List<Score> selectScores(Student student) {
		return dao.scoselect(student);
	}
	
	
	
}
