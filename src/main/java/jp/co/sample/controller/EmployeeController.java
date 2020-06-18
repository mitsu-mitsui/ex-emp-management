package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UpdateEmployeeForm setupUpdateEmployeeForm() {
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

		List<Employee> employeeList = empService.showList();

		model.addAttribute("employeeList", employeeList);

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

		Employee employee = empService.showDetail(intId);

		model.addAttribute("employee", employee);

		return "employee/detail";
	}

	/**
	 * 扶養人数の更新．
	 * 
	 * @param form 更新情報form
	 * @return 従業員情報一覧画面
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee = empService.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

		empService.update(employee);

		return "redirect:/employee/showList";
	}

}
