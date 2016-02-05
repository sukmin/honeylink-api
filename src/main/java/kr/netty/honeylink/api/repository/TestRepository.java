package kr.netty.honeylink.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcOperations jdbcOperations;
	
	public String findOne(){
		return jdbcOperations.queryForObject("SELECT message FROM test", String.class);
	}
	
}
