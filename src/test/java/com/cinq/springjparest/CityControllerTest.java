package com.cinq.springjparest;

import com.cinq.springjparest.dao.CityRepository;
import com.cinq.springjparest.model.City;
import com.cinq.springjparest.service.CityService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CityRepository cityRepository;

    @MockBean
    CityService cityService;

    @org.junit.Test
    public void contextLoads() throws Exception {
        testFindAll();
    }

    private void testFindAll() throws Exception {

        when(cityService.findAll()).thenReturn(
                Collections.emptyList()
        );

        when(cityRepository.findAll()).thenReturn(
                Collections.emptyList()
        );

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/rest/cities")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        assertEquals(mvcResult.getResponse().getStatus(), 200);
        assertEquals(mvcResult.getResponse().getHeader("content-type"), "application/json");
    }
}
