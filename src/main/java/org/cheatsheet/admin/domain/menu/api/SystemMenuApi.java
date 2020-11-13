package org.cheatsheet.admin.domain.menu.api;

import lombok.*;
import org.cheatsheet.admin.domain.menu.entity.MenuUsage;
import org.cheatsheet.admin.domain.menu.entity.SystemMenu;
import org.cheatsheet.admin.domain.menu.repository.SystemMenuRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class SystemMenuApi {

    private final SystemMenuRepository systemMenuRepository;


    @GetMapping("menu")
    public Result<List<SystemMenu>> menuList() {
        return new Result("success", "성공", systemMenuRepository.findAll());
    }


    @PostMapping("menu")
    public Result saveMenu(@RequestBody MenuRequest menuRequest) {
        SystemMenu systemMenu = MenuRequest.mappingRequestToMenu(menuRequest);
        Long createMenuId = systemMenuRepository.save(systemMenu);
        return new Result("success", "성공", createMenuId);
    }


    @Getter
    @Setter
    static  class MenuRequest {
        private String name;
        private String menuUrl;
        private MenuUsage menuUsage;

        public static SystemMenu mappingRequestToMenu(MenuRequest menuRequest) {
            SystemMenu systemMenu = SystemMenu.createMenu(
                    menuRequest.getName(),
                    menuRequest.getMenuUrl(),
                    menuRequest.getMenuUsage()
            );
            return systemMenu;
        }
    }


    @Data
    @AllArgsConstructor
    class Result<T> {
        private String resultCode;
        private String resultName;
        private T data;
    }


    @Getter
    @Setter
    class MenuResponse {
        private Long id;
        private String name;
        private String menuUrl;
        private MenuUsage menuUsage;
        private LocalDateTime createdTime;
        private LocalDateTime lastModifiedTime;
    }
}
