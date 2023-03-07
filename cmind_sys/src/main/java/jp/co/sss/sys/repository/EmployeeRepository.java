package jp.co.sss.sys.repository;









import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

	
	@Query("UPDATE employee FROM empName,password,birthday,gender WHERE Userform = employee ")
	Employee save(String empName, String password,Date birthday, int gender);

	

	

	 

	

	

	

	


	
	
	

	

	

	

	
	

}
