package xc.take.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xc.take.dao.IBillVoDao;
import xc.take.domain.BillVo;
import xc.take.util.JDBCUtil;

public class BillVoDaoImpl implements IBillVoDao{

	@Override
	public void save(BillVo billVo) {
		String sql ="insert into Bill (f_id , u_id , m_id , number,status ,totalMoney,createTimestamp) values (?,?,?,?,?,?,?)";
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, billVo.getF_id());
			pre.setLong(2, billVo.getU_id());
			pre.setLong(3, billVo.getM_id());
			pre.setString(4, billVo.getNumber());
			pre.setShort(5, billVo.getStatus());
			pre.setBigDecimal(6, billVo.getTotalMoney());
			pre.setLong(7, billVo.getCreateTimestamp());
			int index = pre.executeUpdate();
			
			if(index>0){
				System.out.println("添加成功");
			}
			JDBCUtil.closeConnection(connection, pre, null);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyBillVo(BillVo billVo) {
		String sql ="update  Bill  set f_id=? , u_id=?, m_id=?, number=?,status=?,totalMoney=?,createTimestamp=? ";
		
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, billVo.getF_id());
			pre.setLong(2, billVo.getU_id());
			pre.setLong(3, billVo.getM_id());
			pre.setString(4, billVo.getNumber());
			pre.setShort(5, billVo.getStatus());
			pre.setBigDecimal(6, billVo.getTotalMoney());
			pre.setLong(7, billVo.getCreateTimestamp());
			int index = pre.executeUpdate();
			
			if(index>0){
				System.out.println("修改成功");
			}
			JDBCUtil.closeConnection(connection, pre, null);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<BillVo> findAll() {
		String sql="select * from Bill";
		Connection connection = JDBCUtil.getConnection();
		List<BillVo> list=new ArrayList<BillVo>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				BillVo billVo = new BillVo();
				Long f_id = rs.getLong("f_id");
				Long u_id = rs.getLong("u_id");
				Long m_id = rs.getLong("m_id");
				Short status = rs.getShort("status");
				BigDecimal totalMoney = rs.getBigDecimal("totalMoney");
				Long createTimestamp = rs.getLong("createTimestamp");
				String number = rs.getString("number");
				Long b_id = rs.getLong("b_id");
				
				billVo.setF_id(f_id);
				billVo.setId(b_id);
				billVo.setCreateTimestamp(createTimestamp);
				billVo.setM_id(m_id);
				billVo.setNumber(number);
				billVo.setTotalMoney(totalMoney);
				billVo.setU_id(u_id);
				billVo.setStatus(status);
				
				list.add(billVo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<BillVo> findByUId(Long u_id) {
		String sql="select * from Bill where u_id=?";
		Connection connection = JDBCUtil.getConnection();
		List<BillVo> list=new ArrayList<BillVo>();
		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setLong(1, u_id);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				BillVo billVo = new BillVo();
				Long f_id = rs.getLong("f_id");
				Long u_id1 = rs.getLong("u_id");
				Long m_id = rs.getLong("m_id");
				Short status = rs.getShort("status");
				BigDecimal totalMoney = rs.getBigDecimal("totalMoney");
				Long createTimestamp = rs.getLong("createTimestamp");
				String number = rs.getString("number");
				Long b_id = rs.getLong("b_id");
				
				billVo.setF_id(f_id);
				billVo.setId(b_id);
				billVo.setCreateTimestamp(createTimestamp);
				billVo.setM_id(m_id);
				billVo.setNumber(number);
				billVo.setTotalMoney(totalMoney);
				billVo.setU_id(u_id1);
				billVo.setStatus(status);
				
				list.add(billVo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	
	
}
