package com.upse.rutas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.upse.rutas.constantes.Declaraciones;


@Controller
public class MapaController {
	
	Declaraciones decView = new Declaraciones();
	

	
	
	@GetMapping("/cargarMapa")
	public String ejemploMAV(){
				
		
		
			
		return decView.MAP_VIEW;
	}

}
