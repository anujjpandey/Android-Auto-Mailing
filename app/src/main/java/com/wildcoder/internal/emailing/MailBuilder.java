package com.wildcoder.internal.emailing;

public class MailBuilder {
	private String senderId;
	private String receiverId;
	private String password;
	private String subject = "Subject";
	private String body = "Mail body";

	/**
	 * @param subject
	 *            the subject to set
	 */
	public MailBuilder setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public MailBuilder setBody(String body) {
		this.body = body;
		return this;
	}

	/**
	 * @param senderId
	 *            the senderId to set
	 */
	public MailBuilder setSenderId(String senderId) {
		this.senderId = senderId;
		return this;
	}

	/**
	 * @param receiverId
	 *            the receiverId to set
	 */
	public MailBuilder setReceiverId(String receiverId) {
		this.receiverId = receiverId;
		return this;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public MailBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * @return the receiverId
	 */
	public String getReceiverId() {
		return receiverId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

}
