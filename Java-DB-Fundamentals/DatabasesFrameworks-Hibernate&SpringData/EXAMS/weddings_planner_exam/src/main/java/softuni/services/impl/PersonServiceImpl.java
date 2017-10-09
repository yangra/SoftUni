package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Person;
import softuni.repositories.PersonRepository;
import softuni.services.api.PersonService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        this.personRepository.saveAndFlush(person);
    }
}
