package com.psi.services;

import java.util.List;

import com.psi.models.Artikel;


public interface ArtikelService {
	List<Artikel> listArtikel();
	Artikel saveOrUpdate(Artikel artikel);
}
