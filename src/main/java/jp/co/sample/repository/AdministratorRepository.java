package jp.co.sample.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorRepository {

	/*
	 * private static final RowMapper<AdministratorRepository>
	 * ADMINISTRATOR_ROW_MAPPER = (rs, i) -> { AdministratorRepository admin = new
	 * AdministratorRepository(rs.getInt("id"), rs.getString("name"),
	 * rs.getString("mailAddress"), rs.getString(" password"));
	 * 
	 * };
	 */
}
