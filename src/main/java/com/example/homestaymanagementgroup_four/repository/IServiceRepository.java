package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Long> {
}
