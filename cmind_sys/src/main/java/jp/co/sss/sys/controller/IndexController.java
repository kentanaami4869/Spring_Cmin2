package jp.co.sss.sys.controller;







import java.sql.Date;
import java.text.SimpleDateFormat;
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
@SessionAttributes(types = Employee.class) 
public class IndexController {




	@Autowired
	EmployeeRepository empRepository;
	LoginForm loginform;
	SimpleDateFormat sdf;






	/**
	 * ログイン画面を表示する
	 * @param loginForm
	 * @return login.html
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login( LoginForm loginForm,BindingResult br,Model model) {
		return "login";
	}
	@Autowired
	HttpSession session;
	


	// 処理


	/**
	 * 入力された値を元にログイン認証し、トップ画面に遷移する
	 *
	 * @param req
	 * @param res
	 * @param loginForm 
	 * @return top.html
	 */
	@RequestMapping(path = "/top", method = RequestMethod.POST)
	public String login(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,HttpSession session) {
		//ログインした人の情報
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");


		Employee employee = empRepository.findByEmpIdAndPassword(empId, password);




		//セッションデータ設定
		session.setAttribute("userInfo",employee);
		//ログインユーザー情報
		model.addAttribute("employee",employee);

		//ログインチェック
		if(employee == null) {
			//存在しない場合
			return "login";

		}else {

			//存在した場合
			//社員情報一覧
			List<Employee> empAll= empRepository.findAll();    
			model.addAttribute("empAll",empAll);




			return "top";

		}
	}

	@RequestMapping(path = "/top", method = RequestMethod.GET)
	public String top(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,HttpSession session) {
		List<Employee> empAll= empRepository.findAll();    
		model.addAttribute("empAll",empAll);

		return "top";

	}



	//ユーザー更新入力情報　th:object empPost
	@RequestMapping(path = "/mypage", method = RequestMethod.POST)
	public String empUser(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,HttpSession session) {
		session = req.getSession();
		
		String empName = req.getParameter("Userform.empName");
		String password = req.getParameter("Userform.password");
		int gender = Integer.parseInt(req.getParameter("Userform.gender"));
		Date birthday= Date.valueOf("Userform.birthday");
		
		
		Employee Userform= empRepository.save(empName,password,birthday,gender);
		model.addAttribute("UserForm",Userform);


		//ログインユーザー情報
		return "edit_fin";
	}


	//マイページリンク押下，既存情報の出力
	@RequestMapping(path = "/mypage", method = RequestMethod.GET)
	public String empLink(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,HttpSession session) {
		session = req.getSession();
		Object userInfo=   session.getAttribute("userInfo");
		model.addAttribute("userInfo",userInfo);
		
		
		
		
		



		return "mypage";


	}
}










