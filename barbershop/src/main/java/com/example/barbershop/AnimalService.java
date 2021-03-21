package com.example.barbershop;

import com.example.barbershop.entities.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final EntityManager entityManager;

    @Transactional
    public <T extends Animal> T saveNewAnimal(T animal) {
        return entityManager.merge(animal);
    }

    public <T extends Animal> T getAnimalById(int id, Class<T> animalClazz) {
        return entityManager.find(animalClazz, id);
    }

    public List<? extends Animal> getAllAnimals() {
        return entityManager.createQuery("FROM Animal", Animal.class)
            .getResultList();
    }

}
