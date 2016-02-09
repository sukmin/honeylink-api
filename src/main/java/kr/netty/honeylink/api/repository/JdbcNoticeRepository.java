package kr.netty.honeylink.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import kr.netty.honeylink.api.moel.Notice;

@Repository
public class JdbcNoticeRepository implements NoticeRepository {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcOperations jdbcOperations;
	
	private static final String SQL_FIND_LAST_ONE = 
			"SELECT seq, notice_type, notice_content, notice_url, last_version_name "
			+ "FROM notice "
			+ "ORDER BY seq DESC "
			+ "LIMIT 1";
	
	@Override
	public Notice findLastOne() {
		return jdbcOperations.queryForObject(SQL_FIND_LAST_ONE, (rs,rowNum) ->{
			Notice aNotice = new Notice();
			aNotice.setSequence(rs.getLong("seq"));
			aNotice.setType(rs.getString("notice_type"));
			aNotice.setContent(rs.getString("notice_content"));
			aNotice.setUrl(rs.getString("notice_url"));
			aNotice.setLastVersionName(rs.getString("last_version_name"));
			return aNotice;
		});
	}

}
