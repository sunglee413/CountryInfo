package com.slee.country.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.slee.country.data.Country
import com.slee.country.databinding.ActivityMainBinding
import com.slee.country.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun initViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    private val countryListAdapter = CountryListAdapter(this::onItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        initView()
        observeViewModel()

    }

    private fun initView() {
        with(viewBinding) {
            recyclerView.adapter = countryListAdapter
        }

        viewModel.loadData()
    }

    private fun observeViewModel() {
        with(viewModel) {
            countriesLiveData.observe(this@MainActivity, ::onCountriesList)
        }
    }

    private fun onCountriesList(data: List<Country>) {
        countryListAdapter.submitList(data)
    }


    private fun onItemClicked(country: Country) {

    }

}
