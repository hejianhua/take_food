package xc.take.domain;

import java.math.BigDecimal;

public class Param {
	
	//数据库的字段
	private  String  field;
	
	// 一些判断符 < > = like 等等
	
	private  String operator;
	
	
	//查询条件的值
	private Object value;

	public Param(String field , Object value ,String operator){
		this.field=field;
		this.operator=operator;
		this.value=value;
	}
	
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
