package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
									Document document,
									PdfWriter writer,
									HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		//download file name
		response.addHeader("Content-Disposition","attachment; filename=shipments.pdf");
		//create element
		Paragraph p=new Paragraph("welcome to the AbstractPdfView Application");
		//add element to the Document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//create table with colomn names 
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MOde");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("GRADE");
		t.addCell("NOTE");
		
		//add values to the table 
		for(ShipmentType st:list) {
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipMode());
			t.addCell(st.getShipCode());
			t.addCell(st.getEnbShip());
			t.addCell(st.getShipGrade());
			t.addCell(st.getShipDesc());
			
		}
		//add table to the Document
		document.add(t);
		//print Date and Time
		document.add(new Paragraph(new Date().toString()));
		
	}
	


}
