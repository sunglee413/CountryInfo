package com.slee.country.api

import com.slee.country.data.Country
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class CountriesApi @Inject constructor(private val countriesService: CountriesService) {

    fun getAllCountries(): Single<Response<List<Country>>> = countriesService.getAll()

}
