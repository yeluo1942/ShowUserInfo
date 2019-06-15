package domain;

/**
 * 管理员类，用于登录
 * @author yeluo1942
 *
 */
public class Admin {
	private Integer id;
	private String name;
	private String pwd;
	
	public Admin() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
