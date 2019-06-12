package com.chl.gbo.cental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String author;
    private String publicationdate;
    private String publication;
    private double price;
    private String image;
    private String remark;
}
