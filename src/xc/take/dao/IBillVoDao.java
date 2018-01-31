package xc.take.dao;

import java.util.List;

import xc.take.domain.BillVo;

public interface IBillVoDao {
		
	void save(BillVo billVo);
	
	void  modifyBillVo(BillVo billVo);
	
	//查询所有
	List<BillVo> findAll();
	
	//按u_id查询
	
	List<BillVo> findByUId(Long u_id);
}
