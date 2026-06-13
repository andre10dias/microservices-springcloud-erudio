package com.github.andre10dias.microservices_springcloud_erudio.services;

import com.github.andre10dias.microservices_springcloud_erudio.exception.ResourceNotFoundException;
import com.github.andre10dias.microservices_springcloud_erudio.model.Person;
import com.github.andre10dias.microservices_springcloud_erudio.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        logger.info("Finding all people.");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person.");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found."));
    }

    public Person create(Person person) {
        logger.info("Creating one person.");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person.");
        Person entity = this.findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person.");
        Person entity = this.findById(id);
        personRepository.delete(entity);
    }
}
