package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	//implement the overriding methods by Hibernate object
	@Override
	@Transactional
	public Integer saveShipment(ShipmentType ob) {

		Integer id=(Integer) hibernateTemplate.save(ob);
		return id;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> list=hibernateTemplate.loadAll(ShipmentType.class);

		return list;
	}
	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		hibernateTemplate.delete(new ShipmentType(id));

	}
	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(Integer id) {
		return hibernateTemplate.get(ShipmentType.class, id);
	 
	}
	@Override
	@Transactional
	public void updateShipmentType(ShipmentType ob) {
		hibernateTemplate.update(ob);
		
	}



}
