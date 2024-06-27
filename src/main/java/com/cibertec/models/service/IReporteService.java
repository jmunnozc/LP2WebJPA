package com.cibertec.models.service;

import java.util.Map;

public interface IReporteService {
	
	public byte[] generaReporte(String reportName, Map<String, Object> parameters) throws Exception;

	public String generaReportetHtml(String reportName, Map<String, Object> parameters) throws Exception;

}
