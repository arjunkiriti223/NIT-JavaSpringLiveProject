package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface UomDao {
	public Integer saveUom(Uom ob);
	public List<Uom> getAllUom();
	public void deleteUom(Integer id);

}
