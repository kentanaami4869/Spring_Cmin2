package jp.co.sss.sys.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.repository.EmployeeRepository;

/**
 * コントローラークラス
 * @author Inoue Nami
 *
 */
@Controller
public class IndexController {
	
	
	@Autowired
	EmployeeRepository empRepository;
	LoginForm loginform;
	@Autowired
	HttpSession session;
	Employee employee;
	
	
	
	/**
	 * ログイン画面を表示する
	 * @param loginForm
	 * @return login.html
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login( LoginForm loginForm,BindingResult br,Model model) {
		return "login";
	}
	 
	/**
	 * 入力された値を元にログイン認証し、トップ画面に遷移する
	 *
	 * @param req
	 * @param res
	 * @param loginForn 
	 * @return top.html
	 */
	@RequestMapping(path = "/top", method = RequestMethod.POST)
	public String login(@Validated LoginForm loginForn, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model ) {
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");
		 
		
		Employee employee = empRepository.findByEmpIdAndPassword(empId, password);
		req.setAttribute("loginUser", loginForn);

	
		//ログインチェック
	    if(employee == null) {
	      //存在しない場合
	      String errMsg = "社員番号もしくはパスワードが違います．";
	      model.addAttribute("errMsg", errMsg);
	      
	      return "login";

	    }else {
	      //存在した場合
	    	List<Employee> emp= empRepository.findAll();
	    	model.addAttribute("employee",emp); 
	    	model.addAttribute("employee",employee); 
	    	 
	    	 
	    	return "top";
	    }
	}
	        
}

	 
	  

	
		    

	    
	
	  
		  
	
	  
	
