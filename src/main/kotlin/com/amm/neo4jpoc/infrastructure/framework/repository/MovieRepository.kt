package com.amm.neo4jpoc.infrastructure.framework.repository

import com.amm.neo4jpoc.domain.Movie
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository: Neo4jRepository<Movie, Long> {

}
