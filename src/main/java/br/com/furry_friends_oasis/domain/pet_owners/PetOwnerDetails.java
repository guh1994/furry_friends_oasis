package br.com.furry_friends_oasis.domain.pet_owners;

public record PetOwnerDetails(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String phoneOwnerUrl
) {

    public PetOwnerDetails(PetOwner petOwner) {
        this(petOwner.getId(), petOwner.getName(), petOwner.getEmail(),
                petOwner.getPhoneNumber(), petOwner.getPhotoOwnerUrl());
    }

}
