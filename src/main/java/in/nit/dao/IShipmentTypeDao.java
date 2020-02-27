package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	public Integer saveShipment(ShipmentType ob);
	public List<ShipmentType> getAllShipmentTypes();
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);
}