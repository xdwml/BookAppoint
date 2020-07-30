package edu.xidian.appoint.exception;
//预约异常
public class AppointException extends RuntimeException {
	public String message;

	public AppointException(String message) {
		super(message);
		System.out.println("出现异常："+message);
		this.message=message;
	}
	public AppointException(String message, Throwable cause) {
		super(message, cause);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
