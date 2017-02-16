package git.dao;

import java.util.List;

public interface DAO {

	void update(Object user);
	
	public List<Object> getByFilter(DAOFilter filter);
	
	

}
