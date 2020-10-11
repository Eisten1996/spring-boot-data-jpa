package com.bolasaideas.springboot.app.view.pdf;

import com.bolasaideas.springboot.app.models.entities.Factura;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Dipper
 * @project spring-boot-data-jpa
 * @created 11/10/2020 - 16:12
 */
@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document,
                                    PdfWriter pdfWriter, HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {

        Factura factura = (Factura) map.get("factura");

        PdfPTable table = new PdfPTable(1);
        table.setSpacingAfter(20);
        table.addCell("Datos del cliente");
        table.addCell(factura.getCliente().getNombre().concat(" ").concat(factura.getCliente().getApellido()));
        table.addCell(factura.getCliente().getEmail());

        PdfPTable table2 = new PdfPTable(1);
        table2.setSpacingAfter(20);
        table2.addCell("Datos de la factura");
        table2.addCell("Folio: " + factura.getId());
        table2.addCell("Descripcion: " + factura.getDescripcion());
        table2.addCell("Fecha: " + factura.getCreateAt());

        document.add(table);
        document.add(table2);
    }
}
