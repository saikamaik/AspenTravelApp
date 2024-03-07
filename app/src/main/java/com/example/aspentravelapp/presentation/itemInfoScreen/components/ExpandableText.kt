package com.example.aspentravelapp.presentation.itemInfoScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.presentation.itemInfoScreen.ItemInfoViewModel
import com.example.aspentravelapp.presentation.itemInfoScreen.uievent.ItemInfoUiEvent
import com.example.aspentravelapp.presentation.itemInfoScreen.uistate.ItemInfoUiState
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.GreenGray
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun ExpandableText(
    viewModel: ItemInfoViewModel,
    uiState: ItemInfoUiState,
    location: Location
) {

    Column (
        modifier = Modifier
            .padding(bottom = if (uiState.isExpanded) 4.dp else 0.dp)
    ) {

        Text(
            text = stringResource(id = location.description),
            maxLines = if (uiState.isExpanded) Int.MAX_VALUE else 4,
            overflow = TextOverflow.Ellipsis,
            style = Typography.bodyMedium,
            color = GreenGray,
            fontWeight = FontWeight.SemiBold
        )
        if (!uiState.isExpanded) {
            Row(
                modifier = Modifier
                    .padding(top = 9.dp)
                    .clickable(

                    ) {
                        viewModel.postUiEvent(ItemInfoUiEvent.OnClick)
                    }
            ) {
                Text(
                    text = stringResource(id = R.string.read_more),
                    color = Teal,
                    style = Typography.bodyMedium,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "",
                    tint = Teal,
                    modifier = Modifier
                        .padding(start = 11.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        } else {
            Row(
                modifier = Modifier
                    .padding(top = 9.dp)
                    .clickable {
                        viewModel.postUiEvent(ItemInfoUiEvent.OnClick)
                    }
            ) {
                Text(
                    text = "Hide",
                    color = Teal,
                    style = Typography.bodyMedium,
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = "",
                    tint = Teal,
                    modifier = Modifier
                        .padding(start = 11.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }

}