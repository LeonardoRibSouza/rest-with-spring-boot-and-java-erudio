package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter= new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("FindAll one Person!");
        List<Person>  persons = new ArrayList<Person>();

        for(int i =0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leonardo");
        person.setLastName("Ribeiro");
        person.setAddress("Vitoria da Conquista -BA");
        person.setGender("Male");

        return person;
    }

    private Person mockPerson(int i){


        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname"+i);
        person.setLastName("Lastname"+i);
        person.setAddress("Some address"+i);
        person.setGender("Male");

        return person;
    }

    public Person create(@RequestBody Person person){
        logger.info("Create one Person!");
        return person;
    }

    public Person update(Person person){
        logger.info("Update one Person!");
        return person;
    }

    public void delete(String id){
        logger.info("Delete one Person!");
    }

}
