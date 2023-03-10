package jp.co.sss.sys.repository;









import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.sys.entity.Employee;

/**
 * リポジトリークラス
 * @author Inoue Nami
 *
 */
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmpIdAndPassword(String empId, String password);
	//@Modifying
	//@Query("UPDATE employee SET emp_name='empName', password='password', birthday=birthday,gender=gender WHERE emp_id = 'SI001''SI002''SI003'")
	//List<Employee> saveAll(String empName, String password, Date birthday, int gender);

	

	
	

	

	

	 

	

	

	

	


	
	
	

	

	

	

	
	

}
