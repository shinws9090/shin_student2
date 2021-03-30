package shin_student2.dao;

import java.util.List;

import shin_student2.dto.ID;

public interface IDDao {
	
	List<ID> selectIdAll();
	boolean selectId(ID id);
	int insertId(ID id);
	int deleteId(ID id);
	int updateID(ID id);
}
