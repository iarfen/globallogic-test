package com.globalLogicTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    @Column
    public Long number;

    @Column
    public Long citycode;

    @Column
    public Long countrycode;
}
