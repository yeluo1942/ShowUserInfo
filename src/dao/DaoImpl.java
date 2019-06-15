package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Admin;
import domain.User;
import util.JDBCUtil;

/**
 * Dao接口的实现类
 * @author yeluo1942
 *
 */
public class DaoImpl implements Dao{
	
	//定义template
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
	
	@Override
	public List<User> queryAll() {
		String sql = "select * from userinfo";
		
		List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
		
		return list;
	}

	@Override
	public int judgeAdmin(Admin admin) {
		String sql = "select * from admin where name=? and pwd=?";
		List<Map<String, Object>> list = template.queryForList(sql, admin.getName(), admin.getPwd());
		if(list != null) {
			return list.size();
		}else {
			return 0;
		}
	}

	@Override
	public int insertUser(User user) {
		String sql = "insert into userinfo values(null, ?, ?, ?, ?, ?, ?)";
		return template.update(sql,user.getName(), user.getGender(), 
													user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from userinfo where id = ?";
		return template.update(sql, id);
	}

	@Override
	public User queryUserById(int id) {
		String sql = "select * from userinfo where id=?";
		User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
		return user;
	}

	@Override
	public int updateUser(User user) {
		String sql = "update userinfo set name=?, gender=?, age=?, address=?, qq=?, email=? where id=?";
		return template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
		
	}

	//分页查询
	@Override
	public List<User> queryLimit(int begin, int rows, Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from userinfo where 1=1 ");
		Set<String> keys = map.keySet();
		List<Object> params = new ArrayList<Object>();
		for(String key : keys) {
			String temp = map.get(key)[0];
			if(temp != null && temp != "") {
				sb.append(" and " + key + " like ?");
				params.add("%" + temp + "%");
			}
		}
		sb.append(" limit ?,?");
		params.add(begin);
		params.add(rows);
		System.out.println(params);
		return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
	}

	@Override
	public int countRecord(Map<String, String[]> map) {
		//拼接sql字符串
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from userinfo where 1=1 ");
		Set<String> keys = map.keySet();
		List<Object> params = new ArrayList<Object>();
		for(String key : keys) {
			String temp = map.get(key)[0];
			if(temp != null && temp != "") {
				sb.append(" and " + key + " like ?");
				params.add("%" + temp + "%");
			}
		}
		System.out.println("计数sql：" + sb.toString());
		return template.queryForObject(sb.toString(), Integer.class, params.toArray());
	}
	
}






