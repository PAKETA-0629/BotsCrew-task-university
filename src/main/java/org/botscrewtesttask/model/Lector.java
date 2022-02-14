package org.botscrewtesttask.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "lector")
public class Lector {

    @Id
    private Long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "degree")
    private Degree degree;
}
