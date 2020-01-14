package com.amm.neo4jpoc.application.savemovies

import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class SaveMovieServiceShould {

    @MockK
    private lateinit var movieRepository: MovieRepository

    @InjectMockKs
    private lateinit var saveMovieService: SaveMovieService

    @Test
    fun `save entity`(){
        // TODO
    }
}