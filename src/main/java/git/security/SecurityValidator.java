package git.security;

public interface SecurityValidator {
	
	public boolean validate(String user,String password);
	
	public boolean validateSocial(String socialLogin,String token);

}
