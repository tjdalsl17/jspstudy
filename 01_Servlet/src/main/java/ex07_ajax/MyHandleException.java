package ex07_ajax;

public class MyHandleException extends Exception {

	
	private static final long serialVersionUID = 134063727195348483L;
	private int errorCode;
	
	public MyHandleException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	

}
