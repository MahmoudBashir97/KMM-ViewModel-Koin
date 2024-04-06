package screen.di

import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.data.NetworkApi
import screen.details.DetailsViewModel

val myModule = module{
    factory { DetailsViewModel(NetworkApi()) }
}


fun initKoin(){
    startKoin{
        modules(myModule)
    }
}