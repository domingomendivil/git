package git.security;

public class IdentityAccessManagerException extends Exception{
	
	private String errorNro;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4103643662709178473L;
	

	public IdentityAccessManagerException(String errorNro){
		this.errorNro=errorNro;
	}
	
	
	
	public String getErrorNro(){
		return errorNro;
	}
	

}
