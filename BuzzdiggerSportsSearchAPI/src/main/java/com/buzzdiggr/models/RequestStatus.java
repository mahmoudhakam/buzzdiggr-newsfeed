package com.buzzdiggr.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestStatus
{
	private boolean success;
	private String code;
	private String message;
	private String serviceTime;

	public static RequestStatus of(boolean success, String code, String message, String serviceTime)
	{
		RequestStatus status = new RequestStatus();
		status.setCode(code);
		status.setMessage(message);
		status.setServiceTime(serviceTime);
		status.setSuccess(success);
		return status;
	}
}
