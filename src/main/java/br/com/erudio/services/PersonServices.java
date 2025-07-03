package br.com.erudio.services;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.exeception.ResourceNotFoundException;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import static br.com.erudio.mapper.ObjectMapper.parseObject;
import static br.com.erudio.mapper.ObjectMapper.parseListObjects;

@Service
public class PersonServices {

    private final AtomicLong counter= new AtomicLong();

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper convert;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonDTOV1> findAll(){
        logger.info("FindAll one Person!");
        List<PersonDTOV1>  persons = new ArrayList<PersonDTOV1>();

        return parseListObjects(repository.findAll(), PersonDTOV1.class);

    }

    public PersonDTOV1 findById(Long id){
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found with id "));

         return parseObject(entity, PersonDTOV1.class);
    }

    public PersonDTOV1 create(@RequestBody PersonDTOV1 person){
        logger.info("Create one PersonV1!");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTOV1.class);

    }

    public PersonDTOV1 update(PersonDTOV1 person){
        logger.info("Update one Person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found with id "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTOV1.class);

    }

    public void delete(Long id){
        logger.info("Delete one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found with id "));
        repository.delete(entity);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Create one PersonV2!");

        var entity = convert.convertDTOToEntity(person);
        return convert.convertEntityToDTO(repository.save(entity));
    }
}
