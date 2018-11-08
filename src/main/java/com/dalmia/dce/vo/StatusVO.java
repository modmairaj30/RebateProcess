package com.dalmia.dce.vo;

import java.io.Serializable;

public class StatusVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private String message;
	private String code;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}