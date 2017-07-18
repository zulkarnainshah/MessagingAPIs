/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

//This is the entity class which Hibernate will automatically translate into a table.

package messageapi.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id     // Required by Hibernate
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	String name;
	String emp_ID;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Empty constructor required by Hibernate
	public Employee() {}
	
	public Employee(String emp_ID, String name) {
		this.emp_ID = emp_ID;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}
		
}
