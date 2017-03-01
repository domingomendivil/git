package git.security;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import git.dao.DAO;
import git.dao.ObjectNotFoundException;
import git.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class SecurityValidatorImplTest {
	
	
	@Mock
	private DAO dao;
	
	@Mock
	private Hasher hasher;
	
	
	@InjectMocks
	private SecurityValidatorImpl validator;
	
	@Test
	public void testValidate1() throws ObjectNotFoundException{
		String username="pepe";
		String hashedPassword="pepe";
		String password="password";
		User user = new User();
		user.setPassword(hashedPassword);
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username,password)).thenReturn(hashedPassword);
		boolean valid = validator.validate(username, password);
		assertTrue(valid);
	}

	
	@Test
	public void testValidate2() throws ObjectNotFoundException{
		String username="pepe";
		String hashedPassword="pepe";
		String password="password";
		User user = new User();
		user.setPassword(hashedPassword);
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username,password)).thenReturn("other");
		boolean valid = validator.validate(username, password);
		assertFalse(valid);
	}
	
	
	@Test
	public void testValidate3() throws ObjectNotFoundException{
		String username="pepe";
		String hashedPassword="pepe";
		String password="password";
		User user = new User();
		user.setPassword(hashedPassword);
		when(dao.getById(username)).thenThrow(ObjectNotFoundException.class);
		boolean valid = validator.validate(username, password);
		assertFalse(valid);
	}
	
	
	@Test
	//CHE0001 - Usuario no existe
	public void testChangePassword1() throws ObjectNotFoundException{
		String username="domingo";
		when(dao.getById(username)).thenThrow(ObjectNotFoundException.class);
		boolean exception=false;
		try {
			validator.changePassword(username, "","", "");
		} catch (IdentityAccessManagerException e) {
			exception=true;
			assertEquals("CHE0001",e.getErrorNro());
		}
		assertTrue(exception);
	}
	
	
	//CHE0002 - Password no coincide con el actual
	@Test
	public void testChangePassword2() throws ObjectNotFoundException{
		String username="domingo";
		User user = new User();
		user.setId("domingo");
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username,"")).thenReturn("otro");
		boolean exception=false;
		try {
			validator.changePassword(username, "","", "");
		} catch (IdentityAccessManagerException e) {
			exception=true;
			assertEquals("CHE0002",e.getErrorNro());
		}
		assertTrue(exception);
	}
	
	//CHE0003 - Password actual coincide con el actual, pero la nueva clave no cumple con las nuevas políticas 
	@Test
	public void testChangePassword3() throws ObjectNotFoundException{
		String username="domingo";
		User user = new User();
		user.setId("domingo");
		user.setPassword("password");
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username, "")).thenReturn("");
		boolean exception=false;
		try {
			validator.changePassword(username, "","", "");
		} catch (IdentityAccessManagerException e) {
			exception=true;
			assertEquals("CHE0003",e.getErrorNro());
		}
		assertTrue(exception);
	}
	
	//La clave cumple con todos los requisitos, se cambia
	@Test
	public void testChangePassword4() throws ObjectNotFoundException{
		String username="domingo";
		User user = new User();
		user.setId("domingo");
		user.setPassword("password");
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username, "")).thenReturn("");
		boolean exception=false;
		try {
			validator.changePassword(username, "","nuevaclave", "nuevaclave");

		} catch (IdentityAccessManagerException e) {
			exception=true;
		}
		String newHashPassword = hasher.hash(username, "nuevaclave");
		verify(user).setPassword(newHashPassword);
		verify(dao).update(user);		
		assertFalse(exception);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testChangePassword5() throws ObjectNotFoundException, IdentityAccessManagerException{
		validator.changePassword(null, "","nuevaclave", "nuevaclave");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testChangePassword6() throws ObjectNotFoundException, IdentityAccessManagerException{
		validator.changePassword(null, null,"nuevaclave", "nuevaclave");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testChangePassword7() throws ObjectNotFoundException, IdentityAccessManagerException{
		validator.changePassword(null, "",null, "nuevaclave");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testChangePassword8() throws ObjectNotFoundException, IdentityAccessManagerException{
		validator.changePassword(null, "","nuevaclave", null);
	}

	@Test
	public void testChangePassword9() throws ObjectNotFoundException, IdentityAccessManagerException{
		String username="domingo";
		User user = new User();
		user.setId("domingo");
		user.setPassword("password");
		when(dao.getById(username)).thenReturn(user);
		when(hasher.hash(username, "")).thenReturn("password");
		boolean exception=false;
		try {
			validator.changePassword(username, "","nuevaClave", "repClave");
		} catch (IdentityAccessManagerException e) {
			exception=true;
			assertEquals("CHE0004",e.getErrorNro());
		}
		assertTrue(exception);
	}


	

	

}
