package jp.co.sss.sys.repository;









import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sss.sys.entity.Employee;

/**
 * リポジトリークラス
 * @author Inoue Nami
 *
 */
@Transactional
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmpIdAndPassword(String empId, String password);
//	@Modifying

	

//	Employee saveEmpName(String empName, String password,Date birthday, int gender);

	

	


	
	
//	@Query(name = "UPDATE Employee u SET u.emp_name=:empName, u.password=:password,u.birthday=:birthday,u.gender=:gender WHERE u.emp_id =:employee")
//	void setEmpName(@Param("empName") String empName,@Param("password") String password,@Param("birthday") Date birthday,@Param("gender") int gender);
	


//	 List<Employee>saveAll(String empName, String password,Date birthday, int gender);





































}
