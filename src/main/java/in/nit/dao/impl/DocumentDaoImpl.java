package in.nit.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao{
	@Autowired
	 private HibernateTemplate hibernateTemplate;

	
	public Integer saveDocument(Document ob) {
		
		return (Integer) hibernateTemplate.save(ob);
	}

}
