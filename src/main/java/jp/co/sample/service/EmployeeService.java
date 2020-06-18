package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;

	/**
	 * 従業員情報一覧を取得．
	 * 
	 * @return 全従業員情報/従業員なし：null
	 */
	public List<Employee> showList() {
		return empRepository.findAll();

	}

}