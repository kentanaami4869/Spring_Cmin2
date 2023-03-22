package jp.co.sss.sys.repository;











import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.sss.sys.entity.Employee;

/**
 * リポジトリークラス
 * @author Inoue Nami
 *
 */
//@Transactional
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmpIdAndPassword(String empId, String password);
//	@Modifying

	

//	Employee saveEmpName(String empName, String password,Date birthday, int gender);

	
//	@Query(name = "update Employee u SET emp_name=:empName, password=:password,birthday=:birthday,gender=:gender WHERE emp_id =:employee" )
	


	
	
//	@Query(name = "update Employee SET emp_name=:empName, password=:password,birthday=:birthday,gender=:gender WHERE emp_id =:employee" ,nativeQuery = true)
//	void setEmpName(@Param("emp_name") String empName,@Param("password") String password,@Param("birthday") Date birthday,@Param("gender") int gender);
//	Employee save( String empName,String password,Date strDate,int savegender);



//	 List<Employee>saveAll(String empName, String password,Date birthday, int gender);





































}
