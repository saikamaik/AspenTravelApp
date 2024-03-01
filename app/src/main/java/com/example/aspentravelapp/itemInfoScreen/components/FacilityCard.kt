package com.example.aspentravelapp.itemInfoScreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.ui.theme.AspenTravelAppTheme
import com.example.aspentravelapp.ui.theme.LightTeal
import com.example.aspentravelapp.ui.theme.Typography
import java.util.Locale

@SuppressLint("DiscouragedApi")
@Composable
fun FacilityCard(
    facilityName: String,
    facilityAmount: Int?
) {

    val context = LocalContext.current
    val drawableID = context.resources.getIdentifier(
        "facility_" + facilityName.lowercase(Locale.ROOT) + "_icon",
        "drawable",
        context.packageName
    )
    Card(
        modifier = Modifier
            .padding(bottom = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightTeal
        )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp)
                .size(45.dp, 50.dp)
        ) {

            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {

                Icon(
                    painter = painterResource(id = drawableID),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    tint = Color.Unspecified
                )

                if (facilityName == "Dinner") {
                    Text(
                        text = facilityName,
                        color = Color.LightGray,
                        style = Typography.titleSmall,
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                } else {
                    Text(
                        text = "$facilityAmount $facilityName",
                        color = Color.LightGray,
                        style = Typography.titleSmall,
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    AspenTravelAppTheme {
        FacilityCard(facilityName = "Tub", facilityAmount = 1)
    }

}