package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
   // private Integer id; no id, because the identifier of this line in DB is in Client id
   // (one-to-one mapping).
   @Column("address_index")
    private Integer address_index;

    @Column("city")
    private String city;

 @Column("street")
    private String street;

 @Column("streetNo")
    private Integer streetNo;

 @Column("flatNo")
    private Integer flatNo;
}
