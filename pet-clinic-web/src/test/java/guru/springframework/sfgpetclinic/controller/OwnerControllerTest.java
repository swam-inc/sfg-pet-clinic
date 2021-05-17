package guru.springframework.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.map.OwnerServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerServiceMap ownerServiceMap;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner1 = Owner.builder().id(1L).build();
        Owner owner2 = Owner.builder().id(2L).build();
        owners.add(owner1);
        owners.add(owner2);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void getIndex() throws Exception {
        when(ownerServiceMap.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders.get("/owner"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/index"))
         .andExpect(model().attribute("owners", hasSize(2)));

    }

    @Test
    void getErrorPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find")).andExpect(view().name("generic_not_found_page"));
    }

    @Test
    void theErrorTagPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/oups"))
                .andExpect(view().name("generic_not_found_page"))
         .andExpect(status().isOk());
        verifyZeroInteractions(ownerServiceMap);
    }
}