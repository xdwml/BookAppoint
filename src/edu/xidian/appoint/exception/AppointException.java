package edu.xidian.appoint.exception;
//预约异常
public class AppointException extends RuntimeException {
	public String meaasge;

	public AppointException(String message) {
		super(message);
		System.out.println("出现异常："+message);
		this.meaasge=message;
	}
	public AppointException(String message, Throwable cause) {
		super(message, cause);

	}

	public String getMeaasge() {
		return meaasge;
	}

	public void setMeaasge(String meaasge) {
		this.meaasge = meaasge;
	}
}
