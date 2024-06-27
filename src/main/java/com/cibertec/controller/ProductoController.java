package com.cibertec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.models.entity.Producto;
import com.cibertec.models.service.IProductoService;

@Controller
@RequestMapping("/views/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/")
	public String listarProductos(Model model) {
		List<Producto> listadoProductos = productoService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Productos");
		model.addAttribute("productos", listadoProductos);
		
		return "/views/productos/listar";
	}

	
	@GetMapping("/create")
	public String crear(Model model) {
		Producto producto = new Producto();
		
		model.addAttribute("titulo", "Formulario: Nuevo Producto");
		model.addAttribute("producto", producto);
		
		return "/views/productos/frmCrear";
	}
	
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute("producto") Producto producto, RedirectAttributes attribute, 
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Producto");
			model.addAttribute("producto", producto);
			attribute.addFlashAttribute("error","Existieron errores en el formulario...!!!");
			
			return "/views/productos/frmCrear";
		}
		
		productoService.guardar(producto);
		System.out.println("Producto guardado con éxito...!!!");
		attribute.addFlashAttribute("success","Producto guardado con éxito...!!!");
		
		return "redirect:/views/productos/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer idProducto, Model model, RedirectAttributes attribute) {
		Producto producto = null;
		
		if (idProducto > 0) {
			producto = productoService.buscarPorId(idProducto);
			
			if (producto == null) {
				System.out.println("Error: El ID del Producto a EDITAR no existe...!!!");
				attribute.addFlashAttribute("error", "Atención: El ID del Producto a EDITAR no existe...!!!");
				return "redirect:/views/productos/";
			}
		} else {
			System.out.println("Error: Error con el ID del Producto a EDITAR...!!!");
			attribute.addFlashAttribute("error", "Atención: Error con el ID del Producto a EDITAR...!!!");
			return "redirect:/views/productos/";
		}
		
		model.addAttribute("titulo", "Formulario: Editar Producto");
		model.addAttribute("producto", producto);
		
		return "/views/productos/frmCrear";
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idProducto, RedirectAttributes attribute) {
		Producto producto = null;
		
		if (idProducto > 0) {
			producto = productoService.buscarPorId(idProducto);
			
			if (producto == null) {
				System.out.println("Error: El ID del Producto a ELIMINAR no existe...!!!");
				attribute.addFlashAttribute("error", "Atención: El ID del Producto a ELIMINAR no existe...!!!");
				return "redirect:/views/productos/";
			}
		} else {
			System.out.println("Error: Error con el ID del Producto a ELIMINAR...!!!");
			attribute.addFlashAttribute("error", "Atención: Error con el ID del Producto a ELIMINAR...!!!");
			return "redirect:/views/productos/";
		}
		
		productoService.eliminar(idProducto);
		System.out.println("Registro eliminado con éxito...!!!");
		attribute.addFlashAttribute("warning", "Registro eliminado con éxito...!!!");
		
		return "redirect:/views/productos/";
	}
	
	
	@GetMapping("/powerbi")
	public String powerBI(Model model) {
		model.addAttribute("titulo", "Indicadores de calidad en Power BI");
		model.addAttribute("powerbiUrl","https://app.powerbi.com/view?r=eyJrIjoiNTllY2MzMjEtY2IxOS00NWQyLThiNjYtMWM5MWIxYTc1YmQxIiwidCI6IjU4NDEzMmU5LWQyM2EtNDlkZi05ZjZjLWYyOTU0ODI5NWIyZCIsImMiOjR9&pageName=ReportSectione2e14adaa1e2ff7e4b04");
		//model.addAttribute("powerbiUrl","https://app.powerbi.com/reportEmbed?reportId=bf9a3a6b-a609-400c-b415-fdcb65f2ffa1&appId=15781ce8-bfec-4428-90c2-8e6d9c4ddd90&autoAuth=true&ctid=7504e318-8e1e-4d55-bffd-875b4dee8260");
		//model.addAttribute("powerbiUrl","https://lookerstudio.google.com/embed/reporting/dba814de-7734-40f1-8169-6be9b5faebcc/page/9CQXC");
		System.out.println("Mostrando tablero...");
		return "/views/indicadores/tablero";
	}
}
