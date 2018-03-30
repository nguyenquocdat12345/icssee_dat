package demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bangtin")
public class News implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "tieude")
	private String tieude;
	
	@Column(name = "noidung")
	private String noidung;
	
	@Column(name = "nguoitao")
	private String nguoitao;
	
	@Column(name = "ngaytao")
	private String ngaytao;
	
	public News() {
		super();
	}

	

	public News(String tieude, String noidung, String nguoitao, String ngaytao) {
		super();
		this.tieude = tieude;
		this.noidung = noidung;
		this.nguoitao = nguoitao;
		this.ngaytao = ngaytao;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTieude() {
		return tieude;
	}



	public void setTieude(String tieude) {
		this.tieude = tieude;
	}



	public String getNoidung() {
		return noidung;
	}



	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}



	public String getNguoitao() {
		return nguoitao;
	}



	public void setNguoitao(String nguoitao) {
		this.nguoitao = nguoitao;
	}



	public String getNgaytao() {
		return ngaytao;
	}



	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}



	@Override
	public String toString() {
		return "News [id=" + id + ", tieude=" + tieude + ", noidung=" + noidung + ", nguoitao=" + nguoitao
				+ ", ngaytao=" + ngaytao + "]";
	}
	
	
	
}
