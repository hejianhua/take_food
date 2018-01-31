package xc.take.domain;

import java.math.BigDecimal;

public class BillVo {
	private Long id;
	
	//食物id
	private Long f_id;
	
	//早餐，中餐，还是晚餐、
	private Long m_id;

	//用户id
	private Long  u_id;
	
	//食物的数量
	private String  number;


	//总金额
	private BigDecimal totalMoney;

	//创建时间
	private Long   createTimestamp;
	
	//是否已结算, 0未结算， 1已结算
	private Short  status;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getF_id() {
		return f_id;
	}

	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}

	public Long getM_id() {
		return m_id;
	}

	public void setM_id(Long m_id) {
		this.m_id = m_id;
	}

	public Long getU_id() {
		return u_id;
	}

	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	
	
	
	
	
	
}
