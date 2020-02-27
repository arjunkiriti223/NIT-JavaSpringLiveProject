package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeRestController {
	@Autowired
	private IShipmentTypeService service;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id=service.saveShipment(shipmentType);
		String message="Shipmentn Type id :'"+id+"' is saved";
		model.addAttribute("message",message);
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		
		return "shipmentTypeData";
		
	}
	@RequestMapping("/delete")
	public String deleteSshipmentType(@RequestParam("sid")Integer id,Model model
			) {
		service.deleteShipmentType(id);
		String message="ShipmentType '"+id+"' is deleted";
		model.addAttribute("message", message);
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		
		return "shipmentTypeData";
		
	}
	
	@RequestMapping("/show")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
/**
 * 5 by clicking link edit then we get the ShipmeentType
 *  edit page and on click the bottton 
 *  update the save the data ib databasa
 */
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}
	/**
	 * by clicking on update button on ShipmentTypeEdit page 
	 * update the data in DB by using primary key(id)
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String EditShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		   service.updateShipmentType(shipmentType);
		   String message="UPDATED";
		   model.addAttribute("message", message);
		   List<ShipmentType> list=service.getAllShipmentTypes();
		   model.addAttribute("list",list);
		   
		
		return "shipmentTypeData";
		
	}
	/*
	 * on click view link in ShipmentTypeData pAGE
	 *  show the one row data in one table
	 *   format on shipmentTypeView page
	 * 
	 */
	@RequestMapping("/view")
	public String viewShipmnentType(@RequestParam("sid")Integer  id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob",st);
		return "ShipmentTypeView";
		}
	
	/**
	 * by clicking on hyperlink downloads the all
	 *  ShipmentType data into the shipments.pdf file
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		List<ShipmentType> list=service.getAllShipmentTypes();
		
		//send data to the pdf file
		m.addObject("list",list);
		
		
		return m;
		
	}
	/**
	 * by clicking hyperLink we can
	 * download All shipmentType data in excel format
	 * file name Shipment types
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		List<ShipmentType> list=service.getAllShipmentTypes();
		m.addObject("list",list);
		return m;
		
	}
}
