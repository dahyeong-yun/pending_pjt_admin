package org.cheatsheet.admin.domain.menu.repository;

import lombok.RequiredArgsConstructor;
import org.cheatsheet.admin.domain.menu.entity.SystemMenu;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class SystemMenuRepository {

    private final EntityManager em;

    public Long save(SystemMenu menu) {
        em.persist(menu);
        return menu.getId();
    }

    public SystemMenu findById(Long id) {
        SystemMenu systemMenu = em.find(SystemMenu.class, id);
        return systemMenu;
    }

}
