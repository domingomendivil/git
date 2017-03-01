package git.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import git.domain.User;

public class UserDAO {
	
	private  EntityManager em;
	
	public UserDAO(){
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		 em = emf.createEntityManager();
	}
	
	public void insert(User user){
          em.getTransaction().begin();
          em.persist(user);
          em.getTransaction().commit();
	}

	public User getById(String username) throws ObjectNotFoundException{
		if (!validUser(username))
			throw new IllegalArgumentException();
         User user = em.find(User.class, username);
         if (user==null)
        	 throw new ObjectNotFoundException();
         return user;
	}

	private boolean validUser(String username) {
		if (username==null)
			return false;
		else{
			 String pattern = "([a-zA-Z0-9]){4,}";
			 Pattern r = Pattern.compile(pattern);
			 Matcher m = r.matcher(username);
			 return m.matches();
		}
	}

}
