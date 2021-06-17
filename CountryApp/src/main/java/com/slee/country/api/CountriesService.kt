package com.slee.country.api

import com.slee.country.data.Country
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface CountriesService {

    @GET("all/")
    fun getAll(): Single<Response<List<Country>>>

    companion object {
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }
}

