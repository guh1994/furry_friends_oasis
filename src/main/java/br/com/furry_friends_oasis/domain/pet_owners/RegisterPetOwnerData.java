package br.com.furry_friends_oasis.domain.pet_owners;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterPetOwnerData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phoneNumber,
        String photoOwnerUrl
) { }
