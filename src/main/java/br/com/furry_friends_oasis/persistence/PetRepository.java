package br.com.furry_friends_oasis.persistence;

import br.com.furry_friends_oasis.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
