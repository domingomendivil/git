package git.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import git.dao.DAO;
import git.dao.ObjectNotFoundException;
import git.domain.User;

public class SecurityValidatorImpl implements IdentityAccessManager{
	
	private DAO dao;
	private Hasher hasher;

	@Override
	public boolean validate(String username, String password) {
		try {
			User aUser = (User)dao.getById(username);
			String hashedPassword = hasher.hash(username, password);
			if (hashedPassword.equals(aUser.getPassword())){
				return true;
			}else{
				return false;
			}
		} catch (ObjectNotFoundException e) {
			return false;
		}
	}

	@Override
	public boolean validateSocial(String socialLogin, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePassword(String username, String currentPassword, String newPassword, String repeatPassword) throws IdentityAccessManagerException{
		if((username==null)|| (currentPassword==null)||(newPassword==null)||(repeatPassword==null))
			throw new IllegalArgumentException();
		try {
			User user = (User)dao.getById(username);
			String hashedPassword= hasher.hash(username, currentPassword);
			if (validPassword(newPassword)){
				if (user.getPassword().equals(hashedPassword)){
					if (!newPassword.equals(repeatPassword)){
						throw new IdentityAccessManagerException("CHE0004");
					}else{
						String newHashPassword = hasher.hash(username, newPassword);
						user.setPassword(newHashPassword);
						dao.update(user);
					}
				}else{
					throw new IdentityAccessManagerException("CHE0003");
				}
			}else{
				throw new IdentityAccessManagerException("CHE0002");
			}
		} catch (ObjectNotFoundException e) {
			throw new IdentityAccessManagerException("CHE0001");
		}
		
		
	}

	private boolean validPassword(String newPassword) {
		 String pattern = "([a-zA-Z0-9]){8,}";
		 Pattern r = Pattern.compile(pattern);
		 Matcher m = r.matcher(newPassword);
		 return m.matches();
	}

}
