package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table("user")
public class User {
    @Id
   private Integer id;
    @Column("email")
   private String email;
    @Column("first_name")
   private String firstName;
    @Column("last_name")
   private String lastName;
    @Column("role")
   private Role role;
    @Column("status")
   private Status status;
    @Column("password")
   private String password;
}
