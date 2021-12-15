package com.feiyatsu.cryptocurrency.domain.use_case

import com.feiyatsu.cryptocurrency.common.Resource
import com.feiyatsu.cryptocurrency.data.remote.dto.toCoinDetail
import com.feiyatsu.cryptocurrency.domain.model.CoinDetail
import com.feiyatsu.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    // We return Flow here because we want to emit multiple values over period of time
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("couldn't reach server. Check your internet connection"))
        }
    }
}