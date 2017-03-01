package git.security;

public interface IdentityAccessManager {
	
	public boolean validate(String user,String password);
	
	public boolean validateSocial(String socialLogin,String token);
	
	public void changePassword(String user,String currentPassword,String newPassword,String repeatPassword) throws IdentityAccessManagerException;

}
