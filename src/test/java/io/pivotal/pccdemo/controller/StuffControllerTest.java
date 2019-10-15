package io.pivotal.pccdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.pccdemo.dao.StuffDao;
import io.pivotal.pccdemo.model.Stuff;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext
public class StuffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StuffDao stuffDao;

    @Test
    public void postStuffTest() throws Exception {
        Stuff stuff = new Stuff();
        stuff.setStuffId("1");
        stuff.setField("my stuff");

        ObjectMapper objectMapper = new ObjectMapper();

        String stuffJSON = objectMapper.writeValueAsString(stuff);

        mockMvc.perform(post("/stuff")
                .contentType(MediaType.APPLICATION_JSON)
                .content(stuffJSON))
                .andExpect(status().isOk())
                .andExpect(content().json(stuffJSON));

        mockMvc.perform(get("/stuff/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json(stuffJSON));


        Optional<Stuff> actual = stuffDao.findById("1");

        assertTrue(actual.isPresent());
        assertEquals(stuff.getField(), actual.get().getField());
    }

    @Test
    public void stuffNotFoundTest() throws Exception {
        mockMvc.perform(get("/stuff/{id}", "some id"))
                .andExpect(status().isNotFound());
    }
}
