package com.feiyatsu.cryptocurrency.presentation.coin_detail

import com.feiyatsu.cryptocurrency.domain.model.Coin
import com.feiyatsu.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
