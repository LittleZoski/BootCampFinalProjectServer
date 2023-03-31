package dogbook.service;

import dogbook.model.breedResponse.BreedEntry;
import dogbook.model.breedResponse.BreedInfo;
import dogbook.model.Dog;
import dogbook.model.DogOwner;

import java.util.List;
import java.util.Optional;

public interface DogService {

    List<Dog> getAllDogsByUserId(Integer id);
    Optional<Dog> getDogById(Integer id);
    Dog createDog(Dog dog, DogOwner dogOwner);
    Dog updateDog(Dog dog);
    void deleteDog(Integer id);
    public List<BreedEntry> getBreedListResponse();
    public BreedInfo getBreedById(Integer id);



}
