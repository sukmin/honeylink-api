package kr.netty.honeylink.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import kr.netty.honeylink.api.moel.Link;

@Repository
public class JdbcLinkRepository implements LinkRepository {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcOperations jdbcOperations;
	
	@Override
	public void saveLink(Link link) {
	}

	private static final String SQL_FIND_ALL = 
			"SELECT seq, link_url,link_title,link_thum_url,read_count,reg_ymdt "
			+ "FROM link "
			+ "WHERE del_yn = 'n' "
			+ " ORDER BY seq DESC";
	@Override
	public List<Link> findAll() {
		return jdbcOperations.query(SQL_FIND_ALL, (rs,rowNum) ->{
			
			Link aLink = new Link();
			aLink.setSequence(rs.getLong("seq"));
			aLink.setUrl(rs.getString("link_url"));
			aLink.setTitle(rs.getString("link_title"));
			aLink.setThumbnailUrl(rs.getString("link_thum_url"));
			aLink.setReadCount(rs.getInt("read_count"));
			aLink.setRegistrationDate(rs.getDate("reg_ymdt"));
			return aLink;
		});
	}
	
	private static final String SQL_UPDATE_PLUS_COUNT = 
			"UPDATE link "
			+ "SET read_count = read_count + 1 "
			+ "WHERE seq = ?";
	@Override
	public int updatePlusCount(Long sequence) {
		return jdbcOperations.update(SQL_UPDATE_PLUS_COUNT, sequence);
	}

}
