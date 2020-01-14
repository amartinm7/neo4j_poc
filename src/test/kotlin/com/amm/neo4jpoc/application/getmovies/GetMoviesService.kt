package com.amm.neo4jpoc.application.getmovies

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.amm.neo4jpoc.domain.Movie
import com.amm.neo4jpoc.infrastructure.framework.repository.JpaMovie
import com.amm.neo4jpoc.infrastructure.framework.repository.MovieRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetMoviesServiceShould {

    @MockK
    private lateinit var movieRepository: MovieRepository

    @InjectMockKs
    private lateinit var getMoviesService: GetMoviesService

    @Test
    fun `get all movies from repository`(){
        val expected = GetMoviesServiceResponse(
            movies = listOf (
                GetMovieServiceResponse (
                    id = 1,
                    title = "American Beauty",
                    author = "Sam Mendes",
                    year = "1999"
                ),
                GetMovieServiceResponse (
                    id = 2,
                    title = "1917",
                    author = "Sam Mendes",
                    year = "2019"
                )
            )
        )

        every {
            movieRepository.findAll()
        } returns arrayListOf (
            Movie (
                id = 1,
                title = "American Beauty",
                author = "Sam Mendes",
                year = "1999"),
            Movie (
                id = 2,
                title = "1917",
                author = "Sam Mendes",
                year = "2019")
        )

        assertThat(getMoviesService.execute()).isEqualTo(expected = expected)
    }

    private fun getExpectedMovies() = GetMoviesServiceResponse(
        movies = listOf (
            GetMovieServiceResponse (
                id = 1,
                title = "American Beauty",
                author = "Sam Mendes",
                year = "1999"),
            GetMovieServiceResponse (
                id = 2,
                title = "1917",
                author = "Sam Mendes",
                year = "2019")
        )
    )

}