package shin_student2.service;

import shin_student2.dao.Impl.ManagDaoImpl;
import shin_student2.dto.Attendings;
import shin_student2.dto.Days;
import shin_student2.dto.Department;
import shin_student2.dto.Militarys;

public class ManagService {
	ManagDaoImpl dao = ManagDaoImpl.getInstance();

	public int insertDept(Department department) {
		return dao.insertDept(department);
	}

	public int updateDept(Department department) {
		return dao.updateDept(department);
	}

	public int deleteDept(Department department) {
		return dao.deleteDept(department);
	}

	public int insertDays(Days days) {
		return dao.insertDays(days);
	}

	public int updateDays(Days days) {
		return dao.updateDays(days);
	}

	public int deleteDays(Days days) {
		return dao.deleteDays(days);
	}

	public int insertAtd(Attendings attendings) {
		return dao.insertAtd(attendings);
	}

	public int updateAtd(Attendings attendings) {
		return dao.updateAtd(attendings);
	}

	public int deleteAtd(Attendings attendings) {
		return dao.deleteAtd(attendings);
	}

	public int insertMilitays(Militarys militarys) {
		return dao.insertMilitays(militarys);
	}

	public int updateMilitays(Militarys militarys) {
		return dao.updateMilitays(militarys);
	}

	public int deleteMilitays(Militarys militarys) {
		return dao.deleteMilitays(militarys);
	}
}
