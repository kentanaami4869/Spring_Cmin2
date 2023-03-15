package jp.co.sss.sys.repository;









import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sss.sys.entity.Employee;

/**
 * リポジトリークラス
 * @author Inoue Nami
 *
 */
@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmpIdAndPassword(String empId, String password);
	
//	@Query(name = "UPDATE employee SET emp_name='empName', password='password', birthday=savebirthday,gender=savegender WHERE emp_id ='employee")
	Employee saveEmployee(String empName,String password,Date birthday,int gender);
//    List<Employee> saveAll(@Param("emp_Name") String empName,@Param("password") String password,@Param("birthday") Date birthday,@Param("gender") int gender);


	

	

	
	

	

	

	 

	

	

	

	


	
	
	

	

	

	

	
	

}
