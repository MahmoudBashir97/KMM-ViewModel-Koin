package screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getNavigatorScreenModel
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class DetailsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
       // val viewModel = rememberScreenModel { DetailsViewModel() } // this way you initialized it only for this screen
       // val viewModel = navigator.rememberNavigatorScreenModel { DetailsViewModel() } // this is shared along with navigator screen same as a shared viewModel .

        //this with koin Di
        val viewModel = getScreenModel<DetailsViewModel>()
       // val viewModel = navigator.getNavigatorScreenModel<DetailsViewModel>()


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = { Text("Details Screen") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navigator.pop()
                            }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "arrowBack"
                            )
                        }
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Details Screen (${viewModel.number.value})")
            }
        }
    }
}