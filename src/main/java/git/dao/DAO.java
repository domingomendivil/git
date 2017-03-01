package git.dao;

import java.util.List;

public interface DAO {

	void update(Object user) throws ObjectNotFoundException;
	
	public List<Object> getByFilter(DAOFilter filter) throws ObjectNotFoundException;
	
	public Object getById(Object id) throws ObjectNotFoundException;
	

}
