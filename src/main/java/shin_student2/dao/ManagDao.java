package shin_student2.dao;

import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;

public interface ManagDao {
	int insertDept(Department department);
	int updateDept(Department department);
	int deleteDept(Department department);
	int insertDays(Days days);
	int updateDays(Days days);
	int deleteDays(Days days);
	int insertAtd(Attendings attendings);
	int updateAtd(Attendings attendings);
	int deleteAtd(Attendings attendings);
	int insertMilitays(Militarys militarys);
	int updateMilitays(Militarys militarys);
	int deleteMilitays(Militarys militarys);
	
}
