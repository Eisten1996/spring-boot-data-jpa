package com.bolasaideas.springboot.app.view.pdf;

import com.bolasaideas.springboot.app.models.entities.Factura;
import com.bolasaideas.springboot.app.models.entities.ItemFactura;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
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

        PdfPTable table3 = new PdfPTable(4);
        table3.setSpacingAfter(20);
        table3.addCell("Producto");
        table3.addCell("Precio");
        table3.addCell("Cantidad");
        table3.addCell("Total");

        for (ItemFactura item : factura.getItems()) {
            table3.addCell(item.getProducto().getNombre());
            table3.addCell(item.getProducto().getPrecio().toString());
            table3.addCell(item.getCantidad().toString());
            table3.addCell(item.calcularImporte().toString());
        }

        PdfPCell cell = new PdfPCell(new Phrase("Total: "));
        cell.setColspan(3);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        table3.addCell(cell);
        table3.addCell(factura.getTotal().toString());

        document.add(table);
        document.add(table2);
        document.add(table3);
    }
}
