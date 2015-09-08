package cn.com.allinpay.frame.util;

public class MException extends Exception {
	 
	private static final long serialVersionUID = 1L;
	public String causeMsg = null;
	public String causeCode ="9";

	public MException(String paramString) {
		super(paramString);
		this.causeMsg = paramString;
	}

	public MException(String paramString, String paramInt) {
		super(paramString);
		this.causeMsg = paramString;
		this.causeCode = paramInt;
	}

	public String getCauseMsg() {
		return this.causeMsg;
	}

	public String getCauseCode() {
		return this.causeCode;
	}
}