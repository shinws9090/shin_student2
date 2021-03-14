package shin_student2.service;

import java.util.List;

import org.junit.Test;

import shin_student2.dto.Student;

public class SelectByWhereTest {

	@Test
	public void testSelectByWhere() {
		StudentService dao = StudentService.getInstance();
		List<Student> list = dao.selectByWhere("");
		System.out.println(list);
		
	}

}
