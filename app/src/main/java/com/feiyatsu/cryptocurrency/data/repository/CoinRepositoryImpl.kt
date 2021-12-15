package com.feiyatsu.cryptocurrency.data.repository

import com.feiyatsu.cryptocurrency.data.remote.CoinPaprikaApi
import com.feiyatsu.cryptocurrency.data.remote.dto.CoinDetailDto
import com.feiyatsu.cryptocurrency.data.remote.dto.CoinDto
import com.feiyatsu.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) :CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}