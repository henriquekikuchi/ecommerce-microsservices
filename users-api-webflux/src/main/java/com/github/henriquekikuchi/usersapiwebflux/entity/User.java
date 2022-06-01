package com.github.henriquekikuchi.usersapiwebflux.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="tbl_users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private Long id;


    private UUID userCode;
    private String fullName;
    private String email;
    private String password;
    private RoleEnum role;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
