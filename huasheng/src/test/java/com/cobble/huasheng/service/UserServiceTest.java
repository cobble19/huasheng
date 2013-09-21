package com.cobble.huasheng.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.cobble.huasheng.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { TransactionalTestExecutionListener.class})  
@ContextConfiguration({"/applicationContext.xml", "/applicationContext-service.xml"
	, "/applicationContext-dao.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests   {
	
	@Autowired
	private UserService userService;
	@Test
	@Rollback(false)
	public void testAdd() throws Exception {
		System.err.println("testAdd");
		UserDTO userDTO = new UserDTO();
		userDTO.setAccountNo("admin");
		userDTO.setPassword("p1");
		userDTO.setName("Admin");
		userService.add(userDTO);
		List<UserDTO> userDTOs = userService.finds(null);
		System.err.println(userDTOs.isEmpty());
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFinds() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCount() {
		//fail("Not yet implemented");
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
