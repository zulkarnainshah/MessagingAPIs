/**
 * @author Zulkarnain Shah
 * @date 17-Jul-2017
 */

package messageapi.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messageapi.models.Employee;
import messageapi.models.ServerResponse;
import messageapi.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired // This means to get the bean called employeeRepository which is auto-generated
				// by Spring, we will use it to handle the data
	private EmployeeRepository employeeRepository;

	/** POST a new Employee **/
	@RequestMapping(value = "/employee/post", method = RequestMethod.POST)
	public ResponseEntity<?> post(@RequestBody Employee employee) {
		if (employeeRepository.findOneByEmail(employee.getEmail()) == null) {
			employee.setEmpID(UUID.randomUUID().toString());
			employeeRepository.save(employee);
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(ServerResponse.conflict("A user with that email already exists"));
		}
	}

	/** Returns all employees from the employee table **/
	@RequestMapping(value = "/employee/get", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}

	/** Returns Employee specified by the empID request parameter **/
	@RequestMapping(value = "/employee/getEmployee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getEmployeeDetail(@RequestParam(value = "empID") String empID) {
		Employee employee = employeeRepository.findOneByEmpID(empID);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ServerResponse.notFound(null));
		}

	}

	@RequestMapping(value = "/employee/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@RequestParam(value = "empID") String empID) {
		Employee employee = employeeRepository.findOneByEmpID(empID);
		if (employee != null) {
			employeeRepository.delete(employee);
			return ResponseEntity.ok(ServerResponse.success(null));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ServerResponse.notFound(null));
		}
	}
}
