package org.botscrewtesttask.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
}
