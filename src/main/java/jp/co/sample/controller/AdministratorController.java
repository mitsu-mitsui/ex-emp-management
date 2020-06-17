package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報の処理．
 * 
 * @author yuiko.mitsui
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService adminService;

	@ModelAttribute
	public InsertAdministratorForm setUpAdministratorForm() {
		return new InsertAdministratorForm();
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
	 * @param insertAdminForm
	 * @return 追加後の画面
	 */
	@RequestMapping("/insert")
	public String insert( InsertAdministratorForm insertAdminForm ) {
		Administrator admin = new Administrator();
		
		admin.setName(insertAdminForm.getName());
		admin.setMailAddress(insertAdminForm.getMailAddress());
		admin.setPassword(insertAdminForm.getPassword());
		
		adminService.insert(admin);
		
		return "redirect: /";
	}

}
