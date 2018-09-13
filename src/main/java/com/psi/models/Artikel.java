package com.psi.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artikel")
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int artikel_id;

	@Column(nullable = false)
	private String konten;

	private int suka;
	private String status;
	private Date created_at;

    @Column(nullable = false)
    private String judul;

    private String lokasi;
    private String keyword;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToOne(mappedBy = "artikel", cascade = CascadeType.ALL)
    private JenisSukuBatak jenisSukuBatak;

    @OneToMany(mappedBy = "artikel", cascade = CascadeType.ALL)
    private Set<Referensi> referensis;

    @OneToMany(mappedBy = "artikel", cascade = CascadeType.ALL)
    private Set<Log> logs;

    @OneToMany(mappedBy = "artikel", cascade = CascadeType.ALL)
    private Set<Gambar> gambars;
    
	public Artikel() {
		
	}

	public Artikel(int artikel_id, String konten, int suka, String status, Date created_at, String judul, String lokasi,
			String keyword) {
		super();
		this.artikel_id = artikel_id;
		this.konten = konten;
		this.suka = suka;
		this.status = status;
		this.created_at = created_at;
		this.judul = judul;
		this.lokasi = lokasi;
		this.keyword = keyword;
	}

	public int getArtikel_id() {
		return artikel_id;
	}

	public void setArtikel_id(int artikel_id) {
		this.artikel_id = artikel_id;
	}

	public String getKonten() {
		return konten;
	}

	public void setKonten(String konten) {
		this.konten = konten;
	}

	public int getSuka() {
		return suka;
	}

	public void setSuka(int suka) {
		this.suka = suka;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

}
