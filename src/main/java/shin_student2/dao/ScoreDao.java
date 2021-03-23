package shin_student2.dao;

import java.util.List;

import shin_student2.dto.Score;
import shin_student2.dto.Student;

public interface ScoreDao {
	List<Score> scoselect(Student student);
	
	void scoUpdate(Student student);
}
