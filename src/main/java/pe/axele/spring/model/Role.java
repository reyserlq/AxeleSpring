package pe.axele.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rol")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	
	@Column(name="permisoRol",length=20, nullable=false)
	private String authorityRol;

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getAuthorityRol() {
		return authorityRol;
	}

	public void setAuthorityRol(String authorityRol) {
		this.authorityRol = authorityRol;
	}
}
