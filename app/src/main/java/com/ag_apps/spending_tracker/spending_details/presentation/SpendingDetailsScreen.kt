package com.ag_apps.spending_tracker.spending_details.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ag_apps.spending_tracker.core.peresentaion.ui.theme.SpendingTrackerTheme
import com.ag_apps.spending_tracker.core.peresentaion.ui.theme.montserrat
import com.ag_apps.spending_tracker.core.peresentaion.util.Background
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.ag_apps.spending_tracker.spending_details.di.spendingDetailsModule

//

@Composable

fun SpendingDetailsScreenCore(
    viewModel: SpendingDetailsViewModel = koinViewModel(),
    onSaveSpending: () -> Unit,
) {

    val context = LocalContext.current
    LaunchedEffect(true) {
        viewModel.event.collect { event ->
            when (event) {
                SpendingDetailsEvent.SaveFailed -> {
                    Toast.makeText(
                        context,
                        "Error, make sure to enter valid spending info.",
                        Toast.LENGTH_LONG
                    ).show()
                }

                SpendingDetailsEvent.SaveSuccess -> onSaveSpending()
            }
        }
    }

    SpendingDetailsScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SpendingDetailsScreen(
    state: SpendingDetailsState,
    onAction: (SpendingDetailsAction) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp), // Consistent padding for top bar
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Add Spending",
                        fontFamily = montserrat,
                        fontSize = 25.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(RoundedCornerShape(13.dp))
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary.copy(0.6f),
                                shape = RoundedCornerShape(13.dp)
                            )
                            .background(
                                MaterialTheme.colorScheme.primaryContainer.copy(0.3f)
                            )
                            .clickable {
                                onAction(SpendingDetailsAction.SaveSpending)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Save spending",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Background()

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp) // Consistent padding for content
        ) {
            Spacer(modifier = Modifier.height(24.dp)) // Reduced for visual alignment

            // Input fields
            SpendingInputField(
                label = "Name",
                value = state.name,
                onValueChange = { onAction(SpendingDetailsAction.UpdateName(it)) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SpendingInputField(
                label = "Price",
                value = if (state.price == 0.0) "" else state.price.toString(),
                onValueChange = {
                    onAction(
                        SpendingDetailsAction.UpdatePrice(
                            it.toDoubleOrNull() ?: 0.0
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SpendingInputField(
                label = "Quantity",
                value = if (state.quantity == 0.0)"" else state.quantity.toString(),
                onValueChange = {
                    onAction(
                        SpendingDetailsAction.UpdateQuantity(
                            it.toDoubleOrNull() ?: 0.0
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Checkbox section
            var isChecked:Boolean by rememberSaveable { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth() // Checkbox alignment consistency
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it

                            onAction(SpendingDetailsAction.UpdateIsPlastic(it))

                    }

                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = if (isChecked) {

                        "Is plastic"

                    } else
                        "Not plastic"
                )
            }
        }
    }
}

@Composable
fun SpendingInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label, fontWeight = FontWeight.Medium)
        },
        textStyle = TextStyle(
            fontFamily = montserrat,
            fontSize = 17.sp
        ),
        maxLines = 1,
        keyboardOptions = keyboardOptions,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun SpendingDetailsScreenPreview() {
    SpendingTrackerTheme {
        SpendingDetailsScreen(
            state = SpendingDetailsState(),
            onAction = {}
        )
    }
}