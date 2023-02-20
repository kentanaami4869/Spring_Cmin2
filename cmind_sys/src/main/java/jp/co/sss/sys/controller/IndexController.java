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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.sss.sys.entity.Employee;
import jp.co.sss.sys.form.LoginForm;
import jp.co.sss.sys.repository.EmployeeRepository;

/**
 * コントローラークラス
 * @author Inoue Nami
 *
 */
@Controller
@SessionAttributes(types = Model.class)
public class IndexController {



	@Autowired
	EmployeeRepository empRepository;
	LoginForm loginform;
	@Autowired
	HttpSession session;




	/**
	 * ログイン画面を表示する
	 * @param loginForm
	 * @return login.html
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login( LoginForm loginForm,BindingResult br,Model model) {
		return "login";
	}

	@GetMapping(value = "/top")
	String sample(Model model,HttpServletRequest req, HttpServletResponse res){
		

		
		
		
			
			List<Employee> empAll= empRepository.findAll();    
			model.addAttribute("empAll",empAll);

		

		



		return "top";
	}


	// 処理


	/**
	 * 入力された値を元にログイン認証し、トップ画面に遷移する
	 *
	 * @param req
	 * @param res
	 * @param loginForm 
	 * @return top.html
	 */
	@RequestMapping(path = {"/top","/mypage"}, method = RequestMethod.POST)
	public String login(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model ,HttpSession session) {
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");

		//ログインした人の情報
		Employee employee = empRepository.findByEmpIdAndPassword(empId, password);
		req.setAttribute("loginUser",employee);

		//ログインチェック
		if(employee == null) {
			//存在しない場合
			return "login";

		}else {
			//存在した場合
			List<Employee> empAll= empRepository.findAll();    
			model.addAttribute("empAll",empAll);


		} 	
		//ログインユーザー情報
		model.addAttribute("employee",employee);
		return "top";

	}

}




	
















