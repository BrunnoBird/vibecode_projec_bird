package com.example.vibecodeprojecbird.app.features.birdlist

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vibecodeprojecbird.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirdListScreen(
    viewModel: BirdListViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        text = stringResource(R.string.bird_list_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    ) 
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Crossfade(
                targetState = uiState,
                label = "StateTransition"
            ) { state ->
                when {
                    state.isLoading -> {
                        BirdListLoading()
                    }
                    state.error != null -> {
                        BirdListError(
                            error = state.error,
                            onRetry = { viewModel.onIntent(BirdListIntent.LoadBirds) }
                        )
                    }
                    else -> {
                        BirdListContent(birds = state.birds)
                    }
                }
            }
        }
    }
}

@Composable
private fun BirdListLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp,
            modifier = Modifier.semantics {
                contentDescription = "Carregando"
            }
        )
    }
}

@Composable
private fun BirdListError(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.ifEmpty { stringResource(R.string.bird_list_error_generic) },
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text(stringResource(R.string.bird_list_retry))
        }
    }
}

@Composable
private fun BirdListContent(
    birds: List<Bird>,
    modifier: Modifier = Modifier
) {
    if (birds.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.bird_list_empty),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(birds, key = { it.id }) { bird ->
                BirdListItem(bird = bird)
            }
        }
    }
}

@Composable
private fun BirdListItem(
    bird: Bird,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder para imagem com gradiente/estilo
            Surface(
                modifier = Modifier.size(80.dp),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = bird.name.take(1),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.semantics {
                            contentDescription = bird.name
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = bird.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = bird.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
            }
        }
    }
}

// --- Previews ---

@Preview(showBackground = true, name = "Content State")
@Composable
fun BirdListScreenPreview() {
    val mockBirds = listOf(
        Bird("1", "Pardal", "Um pássaro pequeno e muito comum.", ""),
        Bird("2", "Bem-te-vi", "Famoso pelo seu canto.", "")
    )
    MaterialTheme {
        Surface {
            BirdListContent(birds = mockBirds)
        }
    }
}

@Preview(showBackground = true, name = "Loading State")
@Composable
fun BirdListLoadingPreview() {
    MaterialTheme {
        Surface {
            BirdListLoading()
        }
    }
}

@Preview(showBackground = true, name = "Empty State")
@Composable
fun BirdListEmptyPreview() {
    MaterialTheme {
        Surface {
            BirdListContent(birds = emptyList())
        }
    }
}

@Preview(showBackground = true, name = "Error State")
@Composable
fun BirdListErrorPreview() {
    MaterialTheme {
        Surface {
            BirdListError(error = "Erro de conexão", onRetry = {})
        }
    }
}

