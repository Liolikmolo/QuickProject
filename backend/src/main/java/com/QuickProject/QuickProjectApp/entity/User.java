package com.QuickProject.QuickProjectApp.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.RegExp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Класс для работы с сущностью "user"
*/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @NotNull
    private UUID id = UUID.randomUUID();

    @Column(name = "nickname")
    @Size(max = 100)
    private String nickname;

    @Column(name = "email")
    @NotNull
    @Size(max = 100)
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Column(name = "telegram")
    @Pattern(regexp = "^@([A-Za-z0-9_]{5,32})$", message = "Invalid Telegram account format")
    private String telegram;

    @Column(name = "phone")
    @Size(min = 11, max = 15)
    private String phone;

    @Column(name = "password")
    @NotNull
    @Size(min=5,max = 30)
    private String password;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime created_at;

    @Column(name = "tz")
    @NotNull
    @Size(min = 1, max = 3)
    private String tz;

    @Column(name = "enable")
    @NotNull
    private Boolean enable;

    @Column(name = "project_role")
    private String project_role;

    @Column(name = "portfolio_link")
    private String portfolio_link;

    @Column(name = "photo")
    private byte[] photo;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Journal> journal = new ArrayList<>();

    @OneToOne(mappedBy = "creator")
    private Project project;

}
