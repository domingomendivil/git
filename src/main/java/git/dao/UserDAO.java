package git.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import git.domain.User;

public class UserDAO {
	
	public void insert(User user){
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jcg-JPA");
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          em.persist(user);
          em.getTransaction().commit();
	}

	public User getById(String username) throws ObjectNotFoundException{
		// TODO Auto-generated method stub
		return null;
		
	}

}
