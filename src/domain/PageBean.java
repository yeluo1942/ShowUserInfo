package domain;

import java.util.List;

/**
 * ��ҳ��
 * @author yeluo1942
 *
 */
public class PageBean {
	/**
	 * ��ҳ��
	 */
	private int totalPage;
	/**
	 * �ܼ�¼��
	 */
	private int totalRecord;
	/**
	 * ��ǰҳ��
	 */
	private int currentPage;
	/**
	 * ��ҳ�ļ�¼�б�
	 */
	private List<User> list;
	/**
	 * ÿҳ��ʾ�ļ�¼��
	 */
	private int rows;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}








