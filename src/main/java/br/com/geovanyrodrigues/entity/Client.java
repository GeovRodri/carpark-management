package br.com.geovanyrodrigues.entity;

import br.com.geovanyrodrigues.common.EntityAbstract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client extends EntityAbstract {

	@Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", length = 14)
    private String cpf;
    
    @Column(name = "phone")
    private String phone;

    @Column(name = "dt_create", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreate;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_create", nullable = false, updatable = false)
    private User userCreate;
    
    @Column(name = "dt_change")
    @Temporal(TemporalType.DATE)
    private Date dateChange;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_change")
    private User userChange;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	@Override
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public User getUserCreate() {
		return userCreate;
	}

	@Override
	public void setUserCreate(User userCreate) {
		this.userCreate = userCreate;
	}

	public Date getDateChange() {
		return dateChange;
	}

	@Override
	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public User getUserChange() {
		return userChange;
	}

	@Override
	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}
}