/**
 * @author Zulkarnain Shah
 * @date 18-Jul-2017
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
import messageapi.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired // This means to get the bean called employeeRepository which is auto-generated
				// by Spring, we will use it to handle the data
	private EmployeeRepository employeeRepository;

	/** Adds a new Employee to the employee table **/
	@RequestMapping(value = "/employee/post", method = RequestMethod.POST)
	public ResponseEntity<Employee> post(@RequestBody Employee employee) {
		if (employeeRepository.findOneByName(employee.getName()) == null) {
			employee.setEmpID(UUID.randomUUID().toString());
			employeeRepository.save(employee);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}

	}

	/** Returns all employees from the employee table **/
	@RequestMapping(value = "/employee/get", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}

	/** Returns Employee specified by the empID query parameter **/
	@RequestMapping(value = "/employee/getEmployee", method = RequestMethod.GET, produces = "application/json")
	public Employee getEmployeeDetail(@RequestParam(value = "empID") String empID) {
		Employee employee = employeeRepository.getEmployeeByEmpID(empID);
		return employee;
	}

	@RequestMapping(value = "/employee/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@RequestParam(value = "empID") String empID) {
		Employee employee = employeeRepository.findOneByEmpID(empID);
		if (employee != null) {
			employeeRepository.delete(employee);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
