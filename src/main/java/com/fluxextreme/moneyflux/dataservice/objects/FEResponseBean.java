package com.fluxextreme.moneyflux.dataservice.objects;

public class FEResponseBean {

	boolean login;
	boolean authorizationPresent;
	String message;
	Object data;

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isAuthorizationPresent() {
		return authorizationPresent;
	}

	public void setAuthorizationPresent(boolean authorizationPresent) {
		this.authorizationPresent = authorizationPresent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
