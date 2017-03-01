package git.security;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

import git.dao.DAO;
import git.domain.User;

public class SecurityValidatorImplTest {
	
	
	@Mock
	private DAO dao;
	
	@Mock
	private Hasher hasher;
	
	
	@InjectMocks
	private SecurityValidatorImpl validator;
	
	public void test1(){
		String username="pepe";
		String hashedPassword="pepe";
		String password="password";
		User user = new User();
		user.setPassword(hashedPassword);
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username,password)).thenReturn(password);
		boolean valid = new SecurityValidatorImpl().validate(username, password);
		assertTrue(valid);
	}
	
	public void test2(){
		String username="pepe";
		String hashedPassword="pepe";
		String password="password";
		User user = new User();
		user.setPassword(hashedPassword);
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username,password)).thenReturn("other");
		boolean valid = new SecurityValidatorImpl().validate(username, password);
		assertTrue(false);
	}
	

}
