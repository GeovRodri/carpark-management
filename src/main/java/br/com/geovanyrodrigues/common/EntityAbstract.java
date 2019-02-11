package br.com.geovanyrodrigues.common;

import br.com.geovanyrodrigues.entity.User;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({ AuditEntityListener.class })
public abstract class EntityAbstract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void setUserCreate(User userCad);
	
	public abstract void setDateCreate(Date dateCreate);
	
	public abstract void setUserChange(User userChange);

	public abstract void setDateChange(Date dateChange);
}
