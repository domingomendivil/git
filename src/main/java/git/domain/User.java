package git.domain;

import java.util.List;

public class User {
	

	private String password;
	private String email;
	
	private String id;
	
	private List<SocialLogin> socialLogin;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return id.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (other.id != null){
			if (id.equals(other.id)){
				return true;
			}
		}
		return false;
	}
	
	
	

}
