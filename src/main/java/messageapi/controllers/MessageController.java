/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

package messageapi.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messageapi.models.Message;

@RestController
public class MessageController {
	
	@RequestMapping(value = "/message/post", method = RequestMethod.POST,produces = "application/json", consumes="application/json")
	public Message postMessage(@RequestBody Message message) {
		return message;
	}
	
	@RequestMapping(value = "/message/messages",method = RequestMethod.GET)
	public ArrayList<Message> messages() {
		ArrayList<Message>messageList = new ArrayList<>();
		//TODO: Query database for messages, add to messageList and return 
		return messageList.size() > 0 ? messageList : null;
	}
}
