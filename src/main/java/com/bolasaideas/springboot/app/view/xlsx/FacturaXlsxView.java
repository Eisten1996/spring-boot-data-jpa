package com.bolasaideas.springboot.app.view.xlsx;

import com.bolasaideas.springboot.app.models.entities.Factura;
import com.bolasaideas.springboot.app.models.entities.ItemFactura;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Dipper
 * @project spring-boot-data-jpa
 * @created 12/10/2020 - 11:22
 */
@Component("factura/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        Factura factura = (Factura) map.get("factura");
        Sheet sheet = workbook.createSheet("Factura Spring");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Datos del cliente");

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue(factura.getCliente().getEmail());

        sheet.createRow(5).createCell(0).setCellValue("Datos de la factura");
        sheet.createRow(5).createCell(0).setCellValue("Folio: " + factura.getId());
        sheet.createRow(6).createCell(0).setCellValue("Descripcion: " + factura.getDescripcion());
        sheet.createRow(7).createCell(0).setCellValue("Fecha: " + factura.getCreateAt());

        Row header = sheet.createRow(9);
        header.createCell(0).setCellValue("Producto");
        header.createCell(1).setCellValue("Precio");
        header.createCell(2).setCellValue("Cantidad");
        header.createCell(3).setCellValue("Total");

        int rownum = 10;
        for (ItemFactura itemFactura : factura.getItems()) {
            Row fila = sheet.createRow(rownum++);
            fila.createCell(0).setCellValue(itemFactura.getProducto().getNombre());
            fila.createCell(1).setCellValue(itemFactura.getProducto().getPrecio());
            fila.createCell(2).setCellValue(itemFactura.getCantidad());
            fila.createCell(3).setCellValue(itemFactura.calcularImporte());
        }
        Row filaTotal = sheet.createRow(rownum);
        filaTotal.createCell(2).setCellValue("Gran total: ");
        filaTotal.createCell(3).setCellValue(factura.getTotal());
    }
}
