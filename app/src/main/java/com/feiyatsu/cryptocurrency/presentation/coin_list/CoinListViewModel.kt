package com.feiyatsu.cryptocurrency.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.feiyatsu.cryptocurrency.domain.use_case.GetCoinsUseCase
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    // The main reason we still have VM is to maintain the state

}