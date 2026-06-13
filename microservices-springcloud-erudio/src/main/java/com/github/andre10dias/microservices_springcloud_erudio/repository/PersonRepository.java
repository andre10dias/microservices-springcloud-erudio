package com.github.andre10dias.microservices_springcloud_erudio.repository;

import com.github.andre10dias.microservices_springcloud_erudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
