package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
