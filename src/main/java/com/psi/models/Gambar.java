package com.psi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gambar")
public class Gambar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gambar_id;

	@Column(nullable = true)
	private String gambar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artikel_id")
	private Artikel artikel;

	public Gambar() {

	}

	public Gambar(int gambar_id, String gambar) {
		super();
		this.gambar_id = gambar_id;
		this.gambar = gambar;
	}

	public int getGambar_id() {
		return gambar_id;
	}

	public void setGambar_id(int gambar_id) {
		this.gambar_id = gambar_id;
	}

	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}

}
