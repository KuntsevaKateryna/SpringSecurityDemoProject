package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Table("client")
public class Client {

    @Id
    private Integer id;
    @Column("name")
    private String name;
    @Column("age")
    private Integer age;

  //  @Column("address") вказувати не можна, бо шукатиме просте поле address, а в нас link на інший клас
  // about one-to-one mapping
    private Address address;

    //  @Column("hobbies") вказувати не можна, бо шукатиме просте поле hobbies, а в нас link на інший клас
    // about one-to-many mapping
    private Set<Hobby> hobbies;


}
