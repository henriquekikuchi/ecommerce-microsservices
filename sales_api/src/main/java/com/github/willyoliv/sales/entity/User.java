package com.github.willyoliv.sales.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userCode;
    private String fullName;
    private String role;
    private String email;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Sale sale;
}
