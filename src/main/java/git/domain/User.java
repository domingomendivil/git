package git.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	private String password;
	
	@Id
	private String userName;
	
	
	
	public String getId() {
		return userName;
	}
	public void setId(String id) {
		this.userName = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public int hashCode() {
		return userName.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (other.userName != null){
			if (userName.equals(other.userName)){
				return true;
			}
		}
		return false;
	}
	
	
	

}
