package screen.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import screen.data.NetworkApi

class DetailsViewModel(val api:NetworkApi): ScreenModel{

    init {
        println("DetailsViewModel : Initializing...")
        changeOnNumber()
    }

    private val _number = mutableStateOf(0)
    val number  :State<Int> = _number

    private fun changeOnNumber(){
        screenModelScope.launch {
            delay(2000L)
            println("fetchingData : ${api.fetchData()}")
            _number.value = 10
        }
    }

    override fun onDispose() {
        super.onDispose()
        println("DetailsViewModel : Disposing...")
    }
}