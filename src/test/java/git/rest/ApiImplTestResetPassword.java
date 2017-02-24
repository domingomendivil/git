package git.rest;

import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import git.api.ApiImpl;
import git.api.BusinessException;
import git.dao.DAO;
import git.domain.User;
import git.email.EMail;
import git.security.IdentityAccessManager;

@RunWith(MockitoJUnitRunner.class)
public class ApiImplTestResetPassword {
	
	@Mock
	private DAO dao;
	
	@Mock
	private EMail email;
	
	@Mock
	private IdentityAccessManager identityAccessManager;
	
	@InjectMocks
	private ApiImpl api;
	
	
 
	@Test(expected=BusinessException.class)
	public void testResetPassword1(){
		try{
			api.resetPassword("user1","pepe","","");
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword2(){
		try{
			api.resetPassword("user1","pepe","","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword3(){
		try{		
			api.resetPassword("user1","pepe","df","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testResetPassword4(){
		api.resetPassword("user1","pepe",null,null);
	}
	
	
	
	@Test(expected=BusinessException.class)
	public void testResetPassword5(){
		try{
			api.resetPassword("user1","pepe","as","as");	
		}catch(BusinessException e){
			Assert.assertEquals("BE01004",e.getErrorNro());
		}
	}

	
	@Test(expected=BusinessException.class)
	public void testResetPassword6(){
		api.resetPassword("user1","pepe","asdfgs1","asdfgs1");
		verify(email).sendEMail("", "", "Su contraseña ha sido cambiada");
		verify(identityAccessManager).changePassword("","pepe","asdfgs1", "asdfgs1");
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword8(){
		try{
			api.resetPassword("user1","pepe",null,null);
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testResetPassword9(){
		try{
			api.resetPassword("user1","",null,null);
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	
	@Test(expected=BusinessException.class)
	public void testResetPassword10(){
		try{
			api.resetPassword("user1","pepe","pepe","pepe");	
		}catch(BusinessException e){
			Assert.assertEquals("BE01004",e.getErrorNro());
		}
	}



	
	


	
	
	
	
	

	
	
	

}
