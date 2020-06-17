package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
				rs.getString("gender"), rs.getDate("hire_date"), rs.getString("mailAddress"), rs.getString("zip_code"),
				rs.getString("address"), rs.getString("telephone"), rs.getInt("salary"),
				rs.getString("characteristics"), rs.getInt("dependents_count"));

		return emp;
	};

	/**
	 * 全件検索．
	 * 
	 * @return list 全従業員のemployee型リスト
	 */
	public List<Employee> findAll() {

		return null;///
	}

	/**
	 * paramによる1件検索．
	 * 
	 * @param id
	 * @return id一致のemployee
	 */
	public Employee load(Integer id) {

		return null;///
	}

	/**
	 * idによる従業員データ更新．
	 * 
	 * @param emp
	 */
	public void update(Employee emp) {

	}
}
