package com.revature.beans;

public class CreateAccountResponse {
	private boolean success = true;
	
	public CreateAccountResponse() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
