package com.example.homestaymanagementgroup_four.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "services")
    @JsonBackReference
    List<Homestay> homestays;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Homestay> getHomestays() {
        return homestays;
    }

    public void setHomestays(List<Homestay> homestays) {
        this.homestays = homestays;
    }
}
