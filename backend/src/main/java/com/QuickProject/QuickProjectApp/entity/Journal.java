package com.QuickProject.QuickProjectApp.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для работы с сущностью "journal"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journal")
@Data
public class Journal {

    @Id
    @Column(name = "id")//TODO LugovoyAV возможно можно удалить анотацию где совпадает с именем в таблице
    @NotNull
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;

    @ManyToOne
    @JoinColumn(name = "project_role_id")
    @NotNull
    private ProjectRole projectRole;

    @Column(name = "addind_at")
    @NotNull
    private LocalDateTime addind_at;

    @Column(name = "finished_at")
    private LocalDateTime finished_at;

}
