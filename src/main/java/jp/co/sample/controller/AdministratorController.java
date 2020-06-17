package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報の処理を行うコントローラ．
 * 
 * @author yuiko.mitsui
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService adminService;

	@Autowired
	private HttpSession session;

	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		return new InsertAdministratorForm();
	}

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * ログイン画面へ遷移.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("")
	public String toLogin() {
		return "administrator/login";

	}

	/**
	 * 管理者追加画面へ遷移.
	 * 
	 * @return 管理者追加画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者を追加．
	 * 
	 * @param insertAdminForm フォーム
	 * @return ログイン画面
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm insertAdminForm) {
		Administrator admin = new Administrator();

		BeanUtils.copyProperties(insertAdminForm, admin); // form->domain詰め替え

		adminService.insert(admin);

		return "redirect: /";
	}

	/**
	 * ログイン処理をする．
	 * 
	 * @param loginForm ログイン情報form
	 * @return 従業員情報一覧ページ/loginできない：ログイン画面へリダイレクト
	 */
	@RequestMapping("/login")
	public String login(LoginForm loginForm, Model model) {
		Administrator admin = new Administrator();

		BeanUtils.copyProperties(loginForm, admin);
		admin = adminService.login(admin.getMailAddress(), admin.getPassword());

		if (admin == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		} else {
			session.setAttribute("administratorName", admin.getName());
			return "/employee/list";

		}
	}

}
