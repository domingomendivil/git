package git.api;

public class BusinessException extends RuntimeException{

	// BE01001 - The password does not comply with the password policy
	// BE01002 - The password and the repetition does not match
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8985722714002234557L;
	
	private String errorNro;
	

	
	public String getErrorNro(){
		return errorNro;
	}

}
