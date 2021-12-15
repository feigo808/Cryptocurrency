package com.feiyatsu.cryptocurrency.domain.repository

import com.feiyatsu.cryptocurrency.data.remote.dto.CoinDetailDto
import com.feiyatsu.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}