package com.slee.country.repository

import com.slee.country.api.CountriesApi
import com.slee.country.data.Country
import io.reactivex.Single
import javax.inject.Inject

class CountryDataRepository @Inject constructor(private val countriesApi: CountriesApi) {

    fun getAllCountries(): Single<List<Country>> =
        countriesApi.getAllCountries().map {
           it.body() ?: emptyList()
        }

}
