package xc.take.domain;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryParam {

	//这个是字符串模板
	private String templet="AND %s %s ?";
	
	//基础语句
	private String baseSql;

	//一个用来封装，查询参数的list
	private  List<Param> paramList= new ArrayList<Param>();
	
	
	public void setBaseSql(String baseSql) {
		this.baseSql = baseSql;
	}
	
	public void addParam(Param param) {
		
		 this.paramList.add(param);
		
	}


	//创建出一条sql语句
	public String  generateSql(){
		StringBuffer sb= new StringBuffer(this.baseSql);
		
		for (Param param : paramList) {
			sb.append(String.format(templet, param.getField(),param.getOperator()));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//把 PreparedStatement ？的值设置好
	public  void filePreparedStatement(PreparedStatement pst) throws SQLException{
		int count=1;
		for (Param param : paramList) {
			System.out.println(param.getValue());
			pst.setObject(count, param.getValue());
			count++;
		}
		
	}
	
	
}
