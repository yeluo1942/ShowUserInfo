package dao;

import java.util.List;
import java.util.Map;

import domain.Admin;
import domain.User;

/**
 * 负责定义对数据库的基本操作
 * @author yeluo1942
 *
 */
public interface Dao {
	public List<User> queryAll();
	public int judgeAdmin(Admin admin);
	public int insertUser(User user);
	public int deleteById(int id);
	public User queryUserById(int id);
	public int updateUser(User user);
	public List<User> queryLimit(int begin, int rows, Map<String, String[]> map);
	public int countRecord(Map<String, String[]> map);
}
