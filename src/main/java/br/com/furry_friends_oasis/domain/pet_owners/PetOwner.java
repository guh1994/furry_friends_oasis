package br.com.furry_friends_oasis.domain.pet_owners;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "owners")
@Entity(name = "Owner")
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String photoOwnerUrl;

    public PetOwner(RegisterPetOwnerData petOwnerDTO) {
        this.name = petOwnerDTO.name();
        this.email = petOwnerDTO.email();
        this.photoOwnerUrl = petOwnerDTO.photoOwnerUrl();
        this.phoneNumber = petOwnerDTO.photoOwnerUrl();
    }

}
