package cn.mldn.test.service;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import cn.mldn.factory.Factory;
import cn.mldn.service.IMemberService;
import cn.mldn.vo.Member;
import junit.framework.TestCase;

public class IMemberServiceTest {
	private static int rand = 0 ; 
	static { 
		rand = new Random().nextInt(99999) ; 
		}

	@Test
	public void testAdd() throws Exception {
		IMemberService service=Factory.getServiceInstance("member.service");
		System.out.println("ggg");
		Member vo=new Member();
		vo.setMid("mldnjava-"+rand);
		vo.setName("wang"+rand);
		vo.setSal(8.8);
		vo.setBirthday(new Date());
		vo.setNote("man");
		vo.setDel(1);
		TestCase.assertTrue(service.add(vo));
	
	}

}
