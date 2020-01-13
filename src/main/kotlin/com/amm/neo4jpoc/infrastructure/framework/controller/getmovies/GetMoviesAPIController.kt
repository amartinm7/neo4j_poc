package com.amm.neo4jpoc.infrastructure.framework.controller.getmovies

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity

interface GetMoviesAPIController {
    @ApiOperation(value = "gets all the movies")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "returning all movies successfully")
        ]
    )
    fun getMovies(): ResponseEntity<GetMoviesHttpResponse>
}
