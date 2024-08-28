package br.com.furry_friends_oasis.http.rest.controllers;

import br.com.furry_friends_oasis.application.pet.RegisterPet;
import br.com.furry_friends_oasis.domain.pet.RegisterPetData;
import br.com.furry_friends_oasis.domain.pet.PetDetails;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final RegisterPet registerService;

    public PetController(RegisterPet registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<PetDetails> register(@RequestBody @Valid RegisterPetData registerPetData,
                                               UriComponentsBuilder uriBuilder){

        var pet = registerService.register(registerPetData);
        var uri = uriBuilder.path("/pet/{id}").buildAndExpand(pet.id()).toUri();
        return ResponseEntity.created(uri).body(pet);
    }


}
