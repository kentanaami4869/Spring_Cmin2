package jp.co.sss.sys.repository;









import java.sql.Date;
import java.util.List;

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
	List<Employee> saveAll(String empName,String password,Date birthday,int gender);
//	@Query(name = "employee")
//    List<Employee> saveAll(@Param("emp_Name") String empName,@Param("password") String password,@Param("birthday") Date birthday,@Param("gender") int gender);


	

	

	
	

	

	

	 

	

	

	

	


	
	
	

	

	

	

	
	

}
