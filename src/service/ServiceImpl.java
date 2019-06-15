package service;

import java.util.List;
import java.util.Map;

import dao.Dao;
import dao.DaoImpl;
import domain.Admin;
import domain.PageBean;
import domain.User;

/**
 * ʵ��service�ӿ�
 * @author yeluo1942
 *
 */
public class ServiceImpl implements Service {
	
	@Override
	public List<User> queryAll() {
		Dao dao = new DaoImpl();
		return dao.queryAll();
	}

	@Override
	public boolean judgeAdmin(Admin admin) {
		Dao dao = new DaoImpl();
		if(dao.judgeAdmin(admin) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean insertUser(User user) {
		Dao dao = new DaoImpl();
		int num = dao.insertUser(user);
		if(num == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteById(String id) {
		Dao dao = new DaoImpl();
		if(dao.deleteById(Integer.parseInt(id)) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User queryUserById(String id) {
		Dao dao = new DaoImpl();
		return dao.queryUserById(Integer.parseInt(id));
	}

	@Override
	public boolean updateUser(User user) {
		Dao dao = new DaoImpl();
		if(dao.updateUser(user) == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void delSelected(String[] uids) {
		Dao dao = new DaoImpl();
		for(String id : uids) {
			dao.deleteById(Integer.parseInt(id));
		}
	}

	@Override
	public PageBean queryLimit(String currentPage, String rows, Map<String, String[]> map) {
		PageBean pb = new PageBean();
		Dao dao = new DaoImpl();
		int cp;
		int row;
		if(currentPage == null || "".equals(currentPage)) {
			cp = 1;
		}else {
			cp = Integer.parseInt(currentPage);	
		}
		
		if(rows == null || "".equals(rows)) {
			row = 5;
		}else {
			row = Integer.parseInt(rows);
		}
		
		int begin = (cp - 1)*row;
		
		//��ȡ��ѯ���ܼ�¼��
		int totalRecord = dao.countRecord(map);
		pb.setTotalRecord(totalRecord);
		
		//��ѯ��ҳ���
		List<User> list = dao.queryLimit(begin, row, map);
		pb.setList(list);
		
		//���õ�ǰҳ
		pb.setCurrentPage(cp);
		//����ÿҳ��ʾ����Ŀ
		pb.setRows(row);
		//������ҳ��
		int totalPage = (int)Math.ceil((double)totalRecord / (double)row);
		System.out.println("totalPage:" + totalPage);
		pb.setTotalPage(totalPage);
		return pb;
		
	}
}
