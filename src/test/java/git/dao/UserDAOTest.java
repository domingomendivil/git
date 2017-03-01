package git.dao;

import static org.junit.Assert.*;
import org.junit.Test;

import git.domain.User;

public class UserDAOTest {
	
	//INSERT
	
	//Si el usuario le falta alguno de los parámetros obligatorios, debe retornar una indicación con el error
	
	//si el usuario ya existe, debe retornarse un error indicando que el usuario ya existe
	
	
	//GET
	//Si el usuario no existe, retorna ObjectNotFoundException();
	//Si el usuario existe, retorna el usuario
	//Si el usuario no es válido, retorna IllegalArgumentException()
	
	
	@Test(expected=ObjectNotFoundException.class)
	public void testGetById1() throws ObjectNotFoundException{
		new UserDAO().getById("1111");
	}
	
	@Test
	public void testGetById2() throws ObjectNotFoundException{
		User user = new UserDAO().getById("domin1232");
		assertEquals("domin1232",user.getId());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetById3() throws ObjectNotFoundException{
		new UserDAO().getById(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetById4() throws ObjectNotFoundException{
		new UserDAO().getById("---%");
	}
	
	
	

	
	
}
