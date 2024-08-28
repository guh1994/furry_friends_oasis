package br.com.furry_friends_oasis.http.rest.controllers;

import br.com.furry_friends_oasis.application.pet_owners.RegisterPetOwner;
import br.com.furry_friends_oasis.domain.pet_owners.PetOwnerDetails;
import br.com.furry_friends_oasis.domain.pet_owners.RegisterPetOwnerData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/owners")
public class PetOwnerController {

    private final RegisterPetOwner registerService;

    public PetOwnerController(RegisterPetOwner registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<PetOwnerDetails> register(@RequestBody @Valid RegisterPetOwnerData registerData,
                                                    UriComponentsBuilder uriBuilder) {
        var petOwner = registerService.register(registerData);

        var uri = uriBuilder.path("/owners/{id}").buildAndExpand(petOwner.id()).toUri();
        return ResponseEntity.created(uri).body(petOwner);
    }

}
