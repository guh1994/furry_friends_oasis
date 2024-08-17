package br.com.furry_friends_oasis.application.pet_owners;

import br.com.furry_friends_oasis.domain.pet_owners.PetOwner;
import br.com.furry_friends_oasis.domain.pet_owners.PetOwnerDetails;
import br.com.furry_friends_oasis.domain.pet_owners.RegisterPetOwnerData;
import br.com.furry_friends_oasis.persistence.OwnersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterPetOwnerTest {

    @InjectMocks
    private RegisterPetOwner service;

    @Mock
    private OwnersRepository repository;

    @Test
    void registerPetOwner() {
        Long id = 123L;
        String name = "Owner Name";
        String email = "owner.name@email.com";
        String phoneNumber = "+55 (11) 12345-6789";
        String photoOwnerUrl = "https://link-to-the-photo.jpg";
        RegisterPetOwnerData petOwnerDTO = new RegisterPetOwnerData(name, email, phoneNumber, photoOwnerUrl);
        PetOwner owner = new PetOwner(petOwnerDTO);

        PetOwner ownerWithId = new PetOwner(petOwnerDTO);
        ownerWithId.setId(id);

        PetOwnerDetails expectedDetails = new PetOwnerDetails(ownerWithId);

        when(repository.save(owner)).thenReturn(ownerWithId);

        PetOwnerDetails actualDetails = service.register(petOwnerDTO);
        assertEquals(expectedDetails, actualDetails);
    }

}
