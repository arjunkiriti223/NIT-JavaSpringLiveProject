package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	/**this shows the Document.jsp view page on the browser 
	 * by giving the url in /show
	 * 
	 * @return
	 */
	
	@RequestMapping("/show")
	public String showUpLoadPage() {
		return "Document";
		
	}
	/**
	 * this method is save the given data with 
	 * respective fileId
	 * in the view page by by clicking the upload button
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String doUpload(@RequestParam Integer fileId,
							@RequestParam CommonsMultipartFile fileob,
							Model model) {
		if(fileob!=null) {
			Document doc=new Document();
			doc.setFileId(fileId);
			doc.setFileData(fileob.getBytes());
			doc.setFileName(fileob.getOriginalFilename());
			service.saveDocument(doc);
			String message=fileId+"Uploaded";
			model.addAttribute("message", message);
			
		}
		
		
		return "Document";
		
	}
	

}
