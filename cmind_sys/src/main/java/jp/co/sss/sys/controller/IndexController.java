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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	public String login(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,SessionStatus sessionStatus,HttpSession session) {
		//ログインした人の情報
		String empId = req.getParameter("empId");
		String password = req.getParameter("password");

		Employee employee = empRepository.findByEmpIdAndPassword(empId, password);

		//ログインユーザー情報
		model.addAttribute("employee",employee);
		//セッションデータ設定
		session.setAttribute("employee",employee);
		//セッションデータ　破棄設定
		session.invalidate();

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
	public String top(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,SessionStatus sessionStatus,HttpSession session) {


		session = req.getSession();
		session.getAttribute("employee");


		session.invalidate();
		//存在した場合
		List<Employee> empAll= empRepository.findAll();    
		model.addAttribute("empAll",empAll);



		//ログインユーザー情報

		return "top";

	}




	@RequestMapping(path = "/mypage", method = RequestMethod.POST)
	public String empEdit(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,SessionStatus sessionStatus,HttpSession session) {
		session = req.getSession();

		session.getAttribute("employee");
		//更新データ情報
		
		session.invalidate();
		//更新情報を引数に更新するメソッド












		return "mypage";

	}






	@RequestMapping(path = "/mypage", method = RequestMethod.GET)
	public String empUpdate(@Validated LoginForm loginForm, HttpServletRequest req, HttpServletResponse res,BindingResult br,Model model,HttpSession session,SessionStatus sessionStatus) {
		session.getAttribute("employee");



		session.invalidate();
		return "mypage";

	}




}











