package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.UomDao;
import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements UomDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	@Transactional
	public Integer saveUom(Uom ob) {
		
		return (Integer)hibernateTemplate.save(ob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUom() {
		return	hibernateTemplate.loadAll(Uom.class);
		
		 
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
		
		hibernateTemplate.delete(new Uom(id));
		
	}

}
