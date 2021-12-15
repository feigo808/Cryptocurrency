package com.feiyatsu.cryptocurrency.domain.use_case

import com.feiyatsu.cryptocurrency.common.Resource
import com.feiyatsu.cryptocurrency.data.remote.dto.toCoin
import com.feiyatsu.cryptocurrency.domain.model.Coin
import com.feiyatsu.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    // We return Flow here because we want to emit multiple values over period of time
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server. Check your internet connection"))
        }
    }
}