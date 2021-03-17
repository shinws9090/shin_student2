package shin_student2.dao;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shin_student2.dao.Impl.IDDaoImpl;
import shin_student2.dto.ID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IDDaoTest {
	IDDao dao = IDDaoImpl.getInstance();
	@Test
	public void test02SelectId() {
		boolean a = dao.selectId(new ID("shinws9090","1234","shinws9090@naver.com"));
		System.out.println(a);
		Assert.assertEquals(a, true);
	}

	@Test
	public void test01InsertId() {
		int a = dao.insertId(new ID("shinws9090","1234","shinws9090@naver.com"));
		Assert.assertEquals(1, a);
	}

	@Test
	public void test03DeleteId() {
		int a = dao.deleteId(new ID("shinws9090","1234","shinws9090@naver.com"));
		Assert.assertEquals(1, a);
	}

}
