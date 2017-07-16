/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

package messageapi.controllers;
import messageapi.models.TestClass;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/greeting")
	public ResponseEntity<TestClass> greeting(@RequestParam(value="name",defaultValue="user")String name) {
		return new ResponseEntity<TestClass>(new TestClass(1,name),HttpStatus.OK);
	}
	
	@RequestMapping("/multiParamGreeting")
	public TestClass multiParamGreeting(@RequestParam Map<String,String>requestParams) {
		String stringID = requestParams.get("id");
		String name = requestParams.get("name");
		if(stringID != null && name!=null) {
			Long id = new Long(requestParams.get("id"));
			TestClass greeting = new TestClass(id,name);
			return greeting;
		}
		else {
			return null;
		}
	}
	@RequestMapping("/simpleMessage")
	public String getHelloMessage() {
		return "this is a test message";
	}
	
	@RequestMapping("/postMessage")
	public void postMessage(@RequestBody String payload) {
		System.out.println("FROM CLIENT : "+ payload);
	}
}
