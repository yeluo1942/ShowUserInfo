package service;

import java.util.List;
import java.util.Map;

import domain.Admin;
import domain.PageBean;
import domain.User;

/**
 * service层的接口，整合Dao层的基本数据操作
 * @author yeluo1942
 *
 */
public interface Service {
	public List<User> queryAll();
	public boolean judgeAdmin(Admin admin);
	public boolean insertUser(User user);
	public boolean deleteById(String id);
	public User queryUserById(String id);
	public boolean updateUser(User user);
	public void delSelected(String [] uids);
	public PageBean queryLimit(String currentPage, String rows, Map<String, String[]> map);
}
