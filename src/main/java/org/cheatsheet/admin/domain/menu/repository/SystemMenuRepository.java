package org.cheatsheet.admin.domain.menu.repository;

import lombok.RequiredArgsConstructor;
import org.cheatsheet.admin.domain.menu.entity.SystemMenu;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SystemMenuRepository {

    private final EntityManager em;

    @Transactional
    public Long save(SystemMenu menu) {
        em.persist(menu);
        return menu.getId();
    }

    public SystemMenu findById(Long id) {
        SystemMenu systemMenu = em.find(SystemMenu.class, id);
        return systemMenu;
    }

    public List<SystemMenu> findAll() {
        return em.createQuery("SELECT sm FROM SystemMenu sm", SystemMenu.class)
                .getResultList();
    }
}
