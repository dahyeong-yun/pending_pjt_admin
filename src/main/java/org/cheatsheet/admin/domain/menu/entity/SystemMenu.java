package org.cheatsheet.admin.domain.menu.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class SystemMenu {

    @Id @GeneratedValue
    private Long id;
    private String menuName;
    private LocalDateTime createdTime;;
    private LocalDateTime modifiedTime;

}
