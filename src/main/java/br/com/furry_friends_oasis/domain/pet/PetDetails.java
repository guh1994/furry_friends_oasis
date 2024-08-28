package br.com.furry_friends_oasis.domain.pet;

public record PetDetails(
        Long id,
        String name,
        String breed_pet,
        String category_pet,
        String link
) {

    public PetDetails(Pet pet) {
        this(pet.getId(), pet.getName(), pet.getBreed_pet(),
                pet.getCategory_pet(), pet.getLink_picture());
    }
}
