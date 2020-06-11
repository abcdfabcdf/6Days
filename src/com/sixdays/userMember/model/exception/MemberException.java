package com.sixdays.userMember.model.exception;

public class MemberException extends Exception{

	/*
	 * 작성자 : 박주완
	 * 작성일 : 220-02-06
	 * 내용 : 예외처리용.
	 */

	private static final long serialVersionUID = -2867428449839520454L;

	public MemberException() {
		super();
	}

	public MemberException(String msg) {
		super(msg);
	}
}
