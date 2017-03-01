package git.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	private String password;
	private String email;
	
	@Id
	private String userName;
	
	private List<SocialLogin> socialLogin;
	
	
	public String getId() {
		return userName;
	}
	public void setId(String id) {
		this.userName = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<SocialLogin> getSocialLogin() {
		return socialLogin;
	}
	public void setSocialLogin(List<SocialLogin> socialLogin) {
		this.socialLogin = socialLogin;
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
