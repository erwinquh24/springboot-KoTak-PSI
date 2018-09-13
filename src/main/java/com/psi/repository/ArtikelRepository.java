package com.psi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psi.models.Artikel;

@Repository
public interface ArtikelRepository extends CrudRepository<Artikel, Integer>
{
	
}
