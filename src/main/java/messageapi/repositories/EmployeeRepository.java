/**
 * @author Zulkarnain Shah
 * @date 18-Jul-2017
 */

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
// Required for Hibernate and JPA to work

package messageapi.repositories;

import org.springframework.data.repository.CrudRepository;

import messageapi.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
}
