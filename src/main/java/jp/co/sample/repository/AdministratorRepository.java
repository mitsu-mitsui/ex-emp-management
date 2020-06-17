package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * row_mapperの初期化
	 */
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator admin = new Administrator(rs.getInt("id"), rs.getString("name"), rs.getString("mailAddress"),
				rs.getString("password"));

		return admin;
	};

	/**
	 * 管理者情報を挿入する.
	 * 
	 * @param admin Administrator:管理者
	 */
	public void insert(Administrator admin) {

		SqlParameterSource param = new BeanPropertySqlParameterSource(admin);

		String sql = "INSERT  INTO administrators(name,mail_address,password)"
				+ " VALUES(:name , :mailAddress , :password);";

		template.update(sql, param);

		System.out.println(admin.getName() + "さんをinsertしました--------------");

	}

	/**
	 * paramから管理者情報を取得する.
	 * 
	 * @param mailAddress
	 * @param password
	 * @return Administrator型の管理者
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {

		return null;//
	}

}
