package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * employeesテーブルを操作するリポジトリ．
 * 
 * @author yuiko.mitsui
 *
 */
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
	 * @return 全従業員が格納されたemployee型リスト
	 */
	public List<Employee> findAll() {

		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count"
				+ " FROM employees" + " ORDER BY hire_date DESC;";

		List<Employee> emplist = template.query(sql, EMPLOYEE_ROW_MAPPER);

		return emplist;
	}

	/**
	 * 主キー検索．
	 * 
	 * @param id ID
	 * @return 従業員情報
	 */
	public Employee load(Integer id) {

		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics,dependents_count"
				+ " FROM employees" + " WHERE id =:id;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		try {
			Employee emp = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
			return emp;
		} catch (Exception e) {// hitしない
			return null;
		}
	}

	/**
	 * id一致従業員のデータ更新．
	 * 
	 * @param emp 従業員情報
	 */
	public void update(Employee emp) {

		SqlParameterSource param = new BeanPropertySqlParameterSource(emp);

		String sql = "UPDATE employees"
				+ " SET name=:name , image=:image , gender=:gender , hire_date =:hireDate , mail_address =:mailAddress , zip_code=:zipCode , address=:address , telephone =:telephone , salary=:salary , characteristics=:characteristics , dependents_count=:dependentsCount"
				+ " WHERE id=:id" + ";";

		template.update(sql, param);
		System.out.println("update-------------");

	}
}
