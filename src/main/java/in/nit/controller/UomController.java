package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service1;
	
	@RequestMapping(value="/save",method=RequestMethod.POST) //post
	public String saveUom(@ModelAttribute Uom uom,Model model) {
		Integer id=service1.saveUom(uom);
		String message="save the '"+id+"' Uom";
		
		model.addAttribute("savemessage",message);
		return "RegisterUom";
	}
	
	
	@RequestMapping("/all")
	public String getAllUom(@ModelAttribute Uom uom,Model model){
		List<Uom> list=service1.getAllUom();
		model.addAttribute("list",list);
		return "saveUom";	
	}
	
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uId")Integer id,Model model) {
		service1.deleteUom(id);
		String message="Uom type  '"+id+"'is deleted";
		model.addAttribute("deletemessage",message);
		List<Uom> list=service1.getAllUom();
		model.addAttribute("list",list);
		
		return "saveUom";
	}
	
	@RequestMapping("/register")
	public String viewUom() {
		
		return "RegisterUom";
	}

}
