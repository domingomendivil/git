package git.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import git.domain.User;

public class UserDAO {
	
	private  EntityManager em;
	
	public UserDAO(){
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
		 em = emf.createEntityManager();
	}
	
	public void insert(User user){
          em.getTransaction().begin();
          em.persist(user);
          em.getTransaction().commit();
	}

	public User getById(String username) throws ObjectNotFoundException{
         User user = em.find(User.class, username);
         return user;
	}

}
