/**
 * @author Zulkarnain Shah
 * @date 18-Jul-2017
 */

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
// Required for Hibernate and JPA to work

package messageapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import messageapi.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	@Query(nativeQuery=true,value="select * from employee where emp_id = :emp_ID")
	public Employee getEmployeeByEmpID(@Param("emp_ID")String emp_ID);
}
