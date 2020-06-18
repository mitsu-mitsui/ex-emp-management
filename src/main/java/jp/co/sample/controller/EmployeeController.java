package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
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
}
