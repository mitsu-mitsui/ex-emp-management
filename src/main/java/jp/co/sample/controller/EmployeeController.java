package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラ．
 * 
 * @author yuiko.mitsui
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧画面へ遷移．
	 * 
	 * @param model requestスコープ
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {

		List<Employee> emplist = empService.showList();

		model.addAttribute("employeeList", emplist);

		return "employee/list";
	}

	/**
	 * 従業員の詳細ページに遷移．
	 * 
	 * @param id    従業員ID
	 * @param model requestスコープ
	 * @return 従業員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {

		int intId = Integer.parseInt(id);

		Employee emp = empService.showDetail(intId);

		model.addAttribute("employee", emp);

		return "employee/detail";
	}
	
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(form, emp);

		emp =  empService.showDetail(emp.getId());
		
		BeanUtils.copyProperties(form, emp);
		empService.update(emp);
		
		return "redirect:/employee/showList";
	}

}
