package br.com.furry_friends_oasis.application.pet_owners;

import br.com.furry_friends_oasis.domain.pet_owners.PetOwner;
import br.com.furry_friends_oasis.domain.pet_owners.PetOwnerDetails;
import br.com.furry_friends_oasis.domain.pet_owners.RegisterPetOwnerData;
import br.com.furry_friends_oasis.persistence.OwnersRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterPetOwner {

    private final OwnersRepository repository;

    public RegisterPetOwner(OwnersRepository repository) {
        this.repository = repository;
    }

    public PetOwnerDetails register(RegisterPetOwnerData petOwnerDTO) {
        PetOwner petOwner = new PetOwner(petOwnerDTO);
        return new PetOwnerDetails(repository.save(petOwner));
    }
}
