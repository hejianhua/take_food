package xc.take.domain;

public class Resource {
	
	private Long id;
	//每个URL都是一个资源，如果要为资源分配权限，那么这个资源存在于数据库里面。
	private String url;

	//用于描述该权限是用来干嘛的。
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
