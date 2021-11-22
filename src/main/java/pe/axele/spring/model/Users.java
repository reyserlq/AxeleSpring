package pe.axele.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombreUsuario",length=30, unique=true, nullable=false)
	private String username;
	
	@Column(name="contraUsuario",length=90,nullable=false)
	private String password;
	
	@Column(name="correoUsuario",length=30, nullable=false)	
	private String emailUsers;
	
	@Column(name="telefonoUsuario",length=20, nullable=false)	
	private String cellphoneUsers;
	
	private Boolean enabled;
	
	@OneToMany(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailUsers() {
		return emailUsers;
	}

	public void setEmailUsers(String emailUsers) {
		this.emailUsers = emailUsers;
	}

	public String getCellphoneUsers() {
		return cellphoneUsers;
	}

	public void setCellphoneUsers(String cellphoneUsers) {
		this.cellphoneUsers = cellphoneUsers;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
