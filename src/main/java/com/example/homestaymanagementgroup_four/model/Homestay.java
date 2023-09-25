package com.example.homestaymanagementgroup_four.model;

import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "homestay")
public class Homestay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;
    @NotNull
    private String image;

    @NotNull
    private String locationDetail;

    @NotNull
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name ="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "service_homestay", joinColumns = @JoinColumn(name = "homestay_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    List<Service> services;
    @Transient
    private MultipartFile multipartFile;

    public Homestay() {
    }

    public Homestay(Long id, String name, String description, String image, String locationDetail, Boolean isActive, Address address, Category category, List<Service> services, MultipartFile multipartFile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.locationDetail = locationDetail;
        this.isActive = isActive;
        this.address = address;
        this.category = category;
        this.services = services;
        this.multipartFile = multipartFile;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
