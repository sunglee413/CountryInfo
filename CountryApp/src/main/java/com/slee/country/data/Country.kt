package com.slee.country.data

data class Country(
    val name: String,
    val nativeName: String,
    val alpha2Code: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val populations: Long,
    val languages: List<Language>,
    val flag: String?
)

/*
name	"Afghanistan"
topLevelDomain	[…]
alpha2Code	"AF"
alpha3Code	"AFG"
callingCodes	[…]
capital	"Kabul"
altSpellings	[…]
region	"Asia"
subregion	"Southern Asia"
population	27657145
latlng	[…]
demonym	"Afghan"
area	652230
gini	27.8
timezones	[…]
borders	[…]
nativeName	"افغانستان"
numericCode	"004"
currencies	[…]
languages	[…]
translations	{…}
flag	"https://restcountries.eu/data/afg.svg"
regionalBlocs	[…]
cioc	"AFG"
 */