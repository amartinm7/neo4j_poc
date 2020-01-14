package com.amm.neo4jpoc.infrastructure.framework.repository

import com.amm.neo4jpoc.application.getmovies.GetMovieServiceResponse
import com.amm.neo4jpoc.domain.Movie
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CrudMovieRepository: CrudRepository<JpaMovie, Long>


class MovieRepository (
    private val crudMovieRepository: CrudMovieRepository
) {

    fun save(movie: Movie): Movie =
        crudMovieRepository.save(movie.toJPA()).toDomain()

    fun findAll(): List<Movie> =
        crudMovieRepository.findAll().toDomain()

}

private fun JpaMovie.toDomain(): Movie =
    Movie(
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

private fun Movie.toJPA(): JpaMovie =
    JpaMovie(
        id = this.id,
        title = this.title,
        author = this.author,
        year = this.year
    )

fun Iterable<JpaMovie>.toDomain(): List<Movie> =
    this.map { it.toDomain() }


fun JpaMovie.toGetMovieServiceResponse () =
    GetMovieServiceResponse (
        this.id,
        this.title,
        this.author,
        this.year
    )

@NodeEntity
data class JpaMovie(
    @Id val id: Long,
    val title: String,
    val author: String,
    val year: String
)