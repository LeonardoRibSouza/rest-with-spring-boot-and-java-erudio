package br.com.erudio.mapper.custom;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO (Person person){
        PersonDTOV2 dto = new PersonDTOV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDTOToEntity (PersonDTOV2 personDTOV2){
        Person entity = new Person();

        entity.setFirstName(personDTOV2.getFirstName());
        entity.setLastName(personDTOV2.getLastName());
        entity.setAddress(personDTOV2.getAddress());
        entity.setGender(personDTOV2.getGender());

        return entity;
    }

}
