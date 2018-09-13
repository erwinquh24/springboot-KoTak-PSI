package com.psi.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psi.models.Artikel;
import com.psi.repository.ArtikelRepository;
import com.psi.services.ArtikelService;

@Service
public class ArtikelDao implements ArtikelService{
	private EntityManagerFactory emf;
	
	@Autowired
	private ArtikelRepository artikelRepository;
	
	@Autowired  //Injection by Setter Method
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Artikel> listArtikel() {
//		EntityManager em = emf.createEntityManager();
		return (List<Artikel>) artikelRepository.findAll();
	}

	@Override
	public Artikel saveOrUpdate(Artikel artikel) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Artikel saved = em.merge(artikel);  //cek on DB, if null automatically update on DB
		em.getTransaction().commit();
		return saved;
	}
	
	
	
	

}
