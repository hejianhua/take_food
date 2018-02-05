package xc.take.service;

import java.util.List;

import xc.take.domain.BillVo;
import xc.take.domain.QueryParam;

public interface IBillVoService {

	//保存账单
	
	void saveBillVo(BillVo billVo);
	
	//查询所有账单
	List<BillVo> findBillVo();
	
	//按用户id查询
	List<BillVo> findByUId(Long u_id);
	
	List<BillVo> findParam(QueryParam qpm);
}
