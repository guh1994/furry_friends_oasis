package br.com.furry_friends_oasis.domain.pet;

import jakarta.validation.constraints.NotBlank;

public record RegisterPetData(
        @NotBlank
        String name,
        @NotBlank
        String breed_pet,
        @NotBlank
        String category_pet,
        @NotBlank
        String link_picture) {}
