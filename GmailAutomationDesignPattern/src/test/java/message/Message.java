package message;

public class Message {
	private String content;
	private String subject;
	private String toEmail;

	public Message(String toEmail) {
		this.setToEmail(toEmail);
		setContent("CONTENT");
		setSubject("EMAIL_SUBJECT");
	}

	public Message(String toEmail, String toSubject) {
		this.setToEmail(toSubject);
		this.setSubject(subject);
		content = "CONTENT";
	}

	public Message(String toEmail, String toSubject, String toContent) {
		this.setToEmail(toEmail);
		this.setSubject(toSubject);
		this.setContent(toContent);
	}

	public Message() {
		
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

}
