package com.amm.neo4jpoc.infrastructure.framework.controller.getmovies

import com.amm.neo4jpoc.infrastructure.framework.SpringBootIntegration
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
class GetMoviesControllerShould : SpringBootIntegration() {

    @Autowired
    private val mvc: MockMvc? = null

    @BeforeEach
    fun setUp() {
        RestAssuredMockMvc.mockMvc(mvc)
    }

    @Test
    fun `get all movies`() {
        RestAssuredMockMvc.given()
            .`when`()["/v1/movies/"]
            .then()
            .assertThat(MockMvcResultMatchers.status().isOk)
            //.body("status", Matchers.equalTo("UP"))
    }
}


