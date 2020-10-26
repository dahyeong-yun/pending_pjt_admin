package org.cheatsheet.admin.domain.menu.repository;

import org.cheatsheet.admin.domain.menu.entity.MenuUsage;
import org.cheatsheet.admin.domain.menu.entity.SystemMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SystemMenuRepositoryTest {

    @Autowired
    SystemMenuRepository systemMenuRepository;

    @Test
    @Transactional
    void save() {
        SystemMenu systemMenu = SystemMenu.createMenu("메뉴이름", "메뉴주소", MenuUsage.ITEM);
        systemMenuRepository.save(systemMenu);
    }

    @Test
    @Transactional
    void findById() {
        SystemMenu systemMenu = SystemMenu.createMenu("메뉴이름", "메뉴주소", MenuUsage.ITEM);
        Long menuId = systemMenuRepository.save(systemMenu);

        SystemMenu findMenu = systemMenuRepository.findById(menuId);

        assertEquals(findMenu.getId(), systemMenu.getId());
    }
}