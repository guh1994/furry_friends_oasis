package br.com.furry_friends_oasis.domain.pet;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "pets")
@Entity(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet")
    private Long id;
    private String name;
    private String breed_pet;
    private String category_pet;
    private String link_picture;

    public Pet(RegisterPetData registerPetData){
        this.name = registerPetData.name();
        this.breed_pet = registerPetData.breed_pet();
        this.category_pet = registerPetData.category_pet();
        this.link_picture = registerPetData.link_picture();
    }
}
