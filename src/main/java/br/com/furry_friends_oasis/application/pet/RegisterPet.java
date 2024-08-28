package br.com.furry_friends_oasis.application.pet;

import br.com.furry_friends_oasis.domain.pet.Pet;
import br.com.furry_friends_oasis.domain.pet.RegisterPetData;
import br.com.furry_friends_oasis.domain.pet.PetDetails;
import br.com.furry_friends_oasis.persistence.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterPet {

    private PetRepository repository;

    public RegisterPet(PetRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PetDetails register(RegisterPetData petDTO){
        Pet pet = new Pet(petDTO);

        return new PetDetails(repository.save(pet));
    }
}
