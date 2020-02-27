package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.UomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {
	
	@Autowired
	private UomDao dao;

	@Override
	@Transactional
	public Integer saveUom(Uom ob) {
		return dao.saveUom(ob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUom() {
		List<Uom> list=dao.getAllUom();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		
		return list;
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
		
	}

}
