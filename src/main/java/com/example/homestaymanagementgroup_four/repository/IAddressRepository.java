package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
