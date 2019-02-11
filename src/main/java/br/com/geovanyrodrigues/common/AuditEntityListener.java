package br.com.geovanyrodrigues.common;

import br.com.geovanyrodrigues.entity.User;
import br.com.geovanyrodrigues.util.BeanUtil;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class AuditEntityListener {

    @PrePersist
    public void prePersist(EntityAbstract entity) {
        User user = this.getUser();

        entity.setDateCreate(new Date());
        entity.setUserCreate(user);
    }

    @PreUpdate
    public void preUpdate(EntityAbstract entity) {
        User user = this.getUser();

        entity.setUserChange(user);
        entity.setDateChange(new Date());
    }

    private User getUser() {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        return entityManager.find(User.class, 1);
    }
}