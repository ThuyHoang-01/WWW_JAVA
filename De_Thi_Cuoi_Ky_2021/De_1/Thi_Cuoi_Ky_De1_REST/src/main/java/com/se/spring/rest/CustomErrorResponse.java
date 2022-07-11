package com.se.spring.rest;

public class CustomErrorResponse { // Tạo một custom error response riêng
	// Thông tin bao gồm status, message và time
	private int status;
	private String message;
	private long timeStamp;

	public CustomErrorResponse() {
	}

	public CustomErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
