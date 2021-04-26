package shin_student2.service;

import java.util.List;

import shin_student2.dao.IDDao;
import shin_student2.dao.Impl.IDDaoImpl;
import shin_student2.dto.ID;

public class IDService {
	
	IDDaoImpl dao = IDDaoImpl.getInstance();
	
	public boolean selectId(ID id) {
		return dao.selectId(id);
		
	}
	public int insertId(ID id) {
		return dao.insertId(id);
		
	}
	public int deleteId(ID id) {
		return dao.deleteId(id);
		
	}
	public int updateID(ID id) {
		return dao.updateID(id);
		
	}
	public List<ID> selectIdAll() {
		return dao.selectIdAll();
		
	}
}
