package br.com.furry_friends_oasis.http.rest.controllers;

import br.com.furry_friends_oasis.application.pet_owners.RegisterPetOwner;
import br.com.furry_friends_oasis.domain.pet_owners.PetOwner;
import br.com.furry_friends_oasis.domain.pet_owners.PetOwnerDetails;
import br.com.furry_friends_oasis.domain.pet_owners.RegisterPetOwnerData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PetOwnerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<RegisterPetOwnerData> registerPetOwnerDataJson;

    @Autowired
    private JacksonTester<PetOwnerDetails> petOwnerDetailsJson;

    @MockBean
    private RegisterPetOwner registerService;

    @Test
    void testRegister_shouldReturnBadRequestWithEmptyBody() throws Exception {
        var response = mvc.perform(post("/owners"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void testRegister_shouldReturnCreatedWithValidBody() throws Exception {
        var registerData = new RegisterPetOwnerData(
                "Owner name",
                "owner@email.com",
                "+55 (11) 12345-6789",
                "http://link-to-my-photo"
        );

        var petOwner = new PetOwner(registerData);
        petOwner.setId(123L);

        var petOwnerDetails = new PetOwnerDetails(petOwner);

        when(registerService.register(any())).thenReturn(petOwnerDetails);

        var response = mvc.perform(post("/owners")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerPetOwnerDataJson.write(registerData).getJson()))
                .andReturn().getResponse();

        String expectedJson = petOwnerDetailsJson.write(petOwnerDetails).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(expectedJson);
    }

}