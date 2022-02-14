package org.botscrewtesttask.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "degree")
public class Degree {

    @Id
    private Long id;
    @Column(name = "degree_name")
    private String name;
}
