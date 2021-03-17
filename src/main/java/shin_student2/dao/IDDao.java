package shin_student2.dao;

import shin_student2.dto.ID;

public interface IDDao {
	
	boolean selectId(ID id);
	int insertId(ID id);
	int deleteId(ID id);
}
