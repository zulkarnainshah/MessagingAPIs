/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

package messageapi.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messageapi.models.Employee;
import messageapi.models.Message;

@RestController
public class MessageController {

	@RequestMapping(value = "/message/post", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Message postMessage(@RequestBody Message message) {
		return message;
	}

	@RequestMapping(value = "/message/messages", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Message>> messages() {
		ArrayList<Message> messageList = new ArrayList<>();
		// TODO: Query database for messages for the user_ID sent in header or maybe
		// requestBody itself, add to messageList and return
		// Adding dummy messages for the time being
		messageList.add(new Message("Whats up?", "Hello guys, i was wondering what you were doing.", "27/01/2017",
				new Employee(UUID.randomUUID().toString(), "Zulkarnain Shah", null)));
		messageList.add(new Message("Did you email the client?", "Send me a copy too if you have done so", "12/07/2017",
				new Employee(UUID.randomUUID().toString(), "Aadil Majeed", null)));
		messageList.add(new Message("Release date", "We are very positive about releasing Core on 19th July 2017.",
				"15/07/2017", new Employee(UUID.randomUUID().toString(), "Uzair Mohammad", null)));
		return messageList.size() > 0 ? ResponseEntity.ok(messageList)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
