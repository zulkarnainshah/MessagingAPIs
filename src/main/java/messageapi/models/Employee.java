/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

//This is the entity class which Hibernate will automatically translate into a table.

package messageapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id // Required by Hibernate
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	String name;
	@Column(unique = true)
	String empID;
	String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Empty constructor required by Hibernate
	public Employee() {
	}

	public Employee(String empID, String name, String email) {
		this.empID = empID;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
