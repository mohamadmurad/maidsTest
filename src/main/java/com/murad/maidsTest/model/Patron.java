package com.murad.maidsTest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "Address is required")
    private String address;

    @OneToMany(mappedBy = "patron")
    private Set<BookBorrow> borrowing;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Set<BookBorrow> getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Set<BookBorrow> borrowing) {
        this.borrowing = borrowing;
    }
}
