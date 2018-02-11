package xc.take.domain;

public class RoleVo {
	private Long id;
	
	private String name;
	
	//这个用来存储一系列的权限数值Json
	
	private String Pjson;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPjson() {
		return Pjson;
	}

	public void setPjson(String pjson) {
		Pjson = pjson;
	}

	

}
