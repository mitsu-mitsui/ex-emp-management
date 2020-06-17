package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報の操作をするサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository adminRepository;

	/**
	 * 管理者情報を挿入する．
	 * 
	 * @param admin 管理者
	 */
	public void insert(Administrator admin) {
		
		adminRepository.insert(admin);
		System.out.println("insert--------------");

	}
}
