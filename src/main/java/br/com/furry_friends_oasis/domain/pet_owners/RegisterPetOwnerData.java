package br.com.furry_friends_oasis.domain.pet_owners;

public record RegisterPetOwnerData(
        String name,
        String email,
        String phoneNumber,
        String photoOwnerUrl
) { }
