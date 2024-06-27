package com.cibertec.controller;

import java.io.ByteArrayInputStream; // Importa ByteArrayInputStream
import java.sql.Connection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.models.service.IReporteService;


@Controller
@RequestMapping("/views/reporte")
public class ReporteController {
	
	@Autowired
	private IReporteService reporteService;
	
	@GetMapping({"/"})
	public String reporte(Model model) {
		model.addAttribute("titulo", "Reporte - Listado de Productos");
		return "/views/reporte/reporte";
	}
	
	@GetMapping("/report")
	public ResponseEntity<InputStreamResource> verReporte(@RequestParam Map<String, Object> parameters) {
		
		try {
			byte[] data = reporteService.generaReporte("Productos_jasper_02", parameters);
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(data));
			
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=report.pdf")
					.contentType(MediaType.APPLICATION_PDF)
					.contentLength(data.length)
					.body(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(500).build();
	}
	
	
	@GetMapping("/reportPreview")
	public String previewReporte(@RequestParam Map<String, Object> parameters, Model model) {
		try {
			String htmlReport = reporteService.generaReportetHtml("Productos_jasper_02", parameters);
			model.addAttribute("titulo", "Previsualizacion de Reporte");
            model.addAttribute("reporte", htmlReport);
            
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "/views/reporte/reportePreview";
	}
}
