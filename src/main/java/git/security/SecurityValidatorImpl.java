package git.security;

public class SecurityValidatorImpl implements IdentityAccessManager{

	@Override
	public boolean validate(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateSocial(String socialLogin, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePassword(String user, String currentPassword, String newPassword, String repeatPassword) {
		// TODO Auto-generated method stub
		
	}

}
