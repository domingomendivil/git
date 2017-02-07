package git.rest;

import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;

import git.dao.DAO;
import git.domain.User;
import git.email.EMail;

public class ApiImplTest {
	
	private DAO dao;
	private EMail email;
	
	private ApiImpl api;
	
	
 
	@Test(expected=BusinessException.class)
	public void testResetPassword1(){
		try{
			api.resetPassword("pepe","","");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword2(){
		try{
			api.resetPassword("pepe","","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword3(){
		try{		
			api.resetPassword("pepe","df","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01002",e.getErrorNro());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testResetPassword4(){
		api.resetPassword("pepe",null,null);
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword5(){
		try{
			api.resetPassword("pepe","as","as");	
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}

	
	@Test(expected=BusinessException.class)
	public void testResetPassword6(){
		api.resetPassword("pepe","asdfgs1","asdfgs1");
		verify(email).sendEMail("", "", "Su contraseña ha sido cambiada");
		User user = new User();
		user.setId("pepe");
		verify(dao).update(user);
	}
	
	
	

	
	
	

}
