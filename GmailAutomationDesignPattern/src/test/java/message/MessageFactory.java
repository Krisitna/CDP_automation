package message;

public class MessageFactory {
	private Message message;
	
	public Message getMessage(String toEmail){
		message = new Message(toEmail);
		return message;
		
	}
	
	public Message getMessage(String toEmail, String toSubject){
		message = new Message(toEmail, toSubject);
		return message;
		
	}
	
	public Message getMessage(String toEmail, String toSubject, String toContent){
		message = new Message( toEmail, toSubject, toContent);
		return message;
		
	}
	
}
