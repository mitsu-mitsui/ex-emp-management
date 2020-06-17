package jp.co.sample.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
				rs.getString("gender"), rs.getDate("hire_date"), rs.getString("mailAddress"), rs.getString("zip_code"),
				rs.getString("address"), rs.getString("telephone"), rs.getInt("salary"),
				rs.getString("characteristics"), rs.getInt("dependents_count"));

		return emp;
	};

}
