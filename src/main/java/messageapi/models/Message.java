/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

package messageapi.models;

public class Message {
	String title;
	String body;
	String dateSent;
	Employee sentBy;
	
	public Message(String title,String body,String dateSent,Employee sentBy) {
		this.title = title;
		this.body = body;
		this.dateSent = dateSent;
		this.sentBy = sentBy;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDateSent() {
		return dateSent;
	}
	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}
	public Employee getSentBy() {
		return sentBy;
	}
	public void setSentBy(Employee sentBy) {
		this.sentBy = sentBy;
	}
	
	
}
