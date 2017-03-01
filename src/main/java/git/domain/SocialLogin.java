package git.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SOCIALLOGIN")
public class SocialLogin {
	private User user;
	private Integer id;
	private String email;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
