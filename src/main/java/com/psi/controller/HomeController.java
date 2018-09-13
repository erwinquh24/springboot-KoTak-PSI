package com.psi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psi.models.Artikel;
import com.psi.services.ArtikelService;

@Controller
public class HomeController {
	@Autowired
	private ArtikelService artikelService;
		
	
	@RequestMapping("/kotak")
	public String ArtikelList(Model model){
		model.addAttribute("artikel", artikelService.listArtikel());
		return "index";
	}
	
//	=====================SAVE OR UPDATE ARTIKEL==================================
	@RequestMapping(value ="/kotak/tambah_informasi", method = RequestMethod.GET)
	public String TambahInformasi(Model model){
		model.addAttribute("artikel", new Artikel());
		return "tambah_informasi";
	}
	
	@RequestMapping(value ="/kotak/tambah_informasi", method = RequestMethod.POST)
	public String SimpanInformasi (Model model, Artikel artikel){
		model.addAttribute("artikel", artikelService.saveOrUpdate(artikel));
		return "redirect:/kotak";
	}
	
	
//	=============================================================================
	

	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String daftar(Model model,Principal p){    	    	

    	return "register";
    }

	@RequestMapping(value = {"/artikel"}, method = RequestMethod.GET)
    public String artikel(Model model,Principal p, Artikel artikel){    	    	
		
    	return "artikel";
    }
	
	/*@RequestMapping(value ="/artikel_id", method = RequestMethod.POST)
	public String SimpanInformasi(Model model, Artikel artikel){
		model.addAttribute("artikel", artikelService.saveOrUpdate(artikel));
		return "redirect:/kotak";
	}
	*/

}
