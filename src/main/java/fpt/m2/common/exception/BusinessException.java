package fpt.m2.common.exception;

public class BusinessException extends RuntimeException{
	private String code = "0";
	
	public BusinessException(String code) {
		this.code = code;
	}
	
	public BusinessException() {
	
	}
	
	public String getCode () {
		return this.code;
	}
}
