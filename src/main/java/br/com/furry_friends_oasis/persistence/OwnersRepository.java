package br.com.furry_friends_oasis.persistence;


import br.com.furry_friends_oasis.domain.pet_owners.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<PetOwner, Long> {
}
