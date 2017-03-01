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
import git.email.EMail;
import git.security.IdentityAccessManager;
import git.security.IdentityAccessManagerException;

@RunWith(MockitoJUnitRunner.class)
public class ApiImplTestChangePassword {
	
	@Mock
	private DAO dao;
	
	@Mock
	private EMail email;
	
	@Mock
	private IdentityAccessManager identityAccessManager;
	
	@InjectMocks
	private ApiImpl api;
	
	
 
	@Test(expected=BusinessException.class)
	public void testchangePassword1(){
		try{
			api.changePassword("user1","pepe","","");
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testchangePassword2(){
		try{
			api.changePassword("user1","pepe","","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testchangePassword3(){
		try{		
			api.changePassword("user1","pepe","df","as");
		}catch(BusinessException e){
			Assert.assertEquals("BE01001",e.getErrorNro());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testchangePassword4(){
		api.changePassword("user1","pepe",null,null);
	}
	
	
	
	@Test(expected=BusinessException.class)
	public void testchangePassword5(){
		try{
			api.changePassword("user1","pepe","as","as");	
		}catch(BusinessException e){
			Assert.assertEquals("BE01004",e.getErrorNro());
		}
	}

	
	@Test(expected=BusinessException.class)
	public void testchangePassword6() throws IdentityAccessManagerException{
		api.changePassword("user1","pepe","asdfgs1","asdfgs1");
		verify(email).sendEMail("", "", "Su contraseña ha sido cambiada");
		verify(identityAccessManager).changePassword("","pepe","asdfgs1", "asdfgs1");
	}
	
	@Test(expected=BusinessException.class)
	public void testchangePassword8(){
		try{
			api.changePassword("user1","pepe",null,null);
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	@Test(expected=BusinessException.class)
	public void testchangePassword9(){
		try{
			api.changePassword("user1","",null,null);
		}catch(BusinessException e){
			Assert.assertEquals("BE01000",e.getErrorNro());
		}
	}
	
	
	@Test(expected=BusinessException.class)
	public void testchangePassword10(){
		try{
			api.changePassword("user1","pepe","pepe","pepe");	
		}catch(BusinessException e){
			Assert.assertEquals("BE01004",e.getErrorNro());
		}
	}



	
	


	
	
	
	
	

	
	
	

}
