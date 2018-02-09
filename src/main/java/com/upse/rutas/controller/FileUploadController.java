package com.upse.rutas.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.upse.rutas.services.StorageService;
import com.upse.rutas.storage.StorageFileNotFoundException;



@Controller
@RequestMapping("/upload")
public class FileUploadController {

    //direccion donde se guardara el archivo GPX
    private static String UPLOADED_FOLDER = "D:/Curso_spring_boot/Archivos/";

    //metodo post que hace la subida del archivo GPX  
   @PostMapping("/archivo")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
    	try {
        	
        	if (file.isEmpty()) {
                
                 model.addAttribute("message","Please select a file to upload");
                 
             }else{

            
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            model.addAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
             }
        } catch (IOException e) {
            e.printStackTrace();
        }

      return "index";
    }
   
    

}
