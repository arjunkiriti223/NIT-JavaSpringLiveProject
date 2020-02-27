package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipment(ShipmentType ob);
	public List<ShipmentType> getAllShipmentTypes();
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);


}
