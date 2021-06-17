package com.slee.country.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slee.country.data.Country
import com.slee.country.repository.CountryDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val countryDataRepository: CountryDataRepository) :
    ViewModel() {

    private val workingThread = Schedulers.from(Executors.newCachedThreadPool())
    private val compositeDisposable = CompositeDisposable()

    private val _countriesLiveData = MutableLiveData<List<Country>>()

    val countriesLiveData: LiveData<List<Country>> = _countriesLiveData

    fun loadData() {
        compositeDisposable.add(
            countryDataRepository.getAllCountries()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(workingThread)
                .subscribe({
                    _countriesLiveData.value = it
                },
                    {
                        Log.e(TAG, it.message?: "Error")
                        _countriesLiveData.value = emptyList()
                    })
        )
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }

}
