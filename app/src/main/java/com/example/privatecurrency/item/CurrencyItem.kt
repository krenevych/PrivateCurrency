package com.example.privatecurrency.item


import com.google.gson.annotations.SerializedName

data class CurrencyItem(
    @SerializedName("base_ccy")
    val baseCcy: String?,
    @SerializedName("buy")
    val buy: String?,
    @SerializedName("ccy")
    val ccy: String?,  // Валюта у яку відбувається конвертування з базової (гривня) валюти
    @SerializedName("sale")
    val sale: String?
)