package xc.take.service;

import java.util.List;

import xc.take.domain.BillVo;

public interface IBillVoService {

	//保存账单
	
	void saveBillVo(BillVo billVo);
	
	//查询所有账单
	List<BillVo> findBillVo();
	
	//按用户id查询
	List<BillVo> findByUId(Long u_id);
}
