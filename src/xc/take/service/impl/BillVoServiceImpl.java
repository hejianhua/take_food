package xc.take.service.impl;

import java.util.List;

import xc.take.dao.IBillVoDao;
import xc.take.dao.impl.BillVoDaoImpl;
import xc.take.domain.BillVo;
import xc.take.domain.QueryParam;
import xc.take.service.IBillVoService;

public class BillVoServiceImpl implements IBillVoService {
	private IBillVoDao billVoDaoImpl=new BillVoDaoImpl();
	@Override
	public void saveBillVo(BillVo billVo) {
		billVoDaoImpl.save(billVo);
		
	}

	@Override
	public List<BillVo> findBillVo() {
		
		return billVoDaoImpl.findAll();
	}

	@Override
	public List<BillVo> findByUId(Long u_id) {
		
		return billVoDaoImpl.findByUId(u_id);
	}

	@Override
	public List<BillVo> findParam(QueryParam qpm) {
		
		return billVoDaoImpl.findByParam(qpm);
	}
	
	

}
