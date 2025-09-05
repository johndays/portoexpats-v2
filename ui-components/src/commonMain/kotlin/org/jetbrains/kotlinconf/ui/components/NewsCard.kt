package org.jetbrains.kotlinconf.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.kotlinconf.ui.theme.PortoExpatsTheme

@Composable
fun NewsCard(
    title: String,
    date: String,
    photoUrl: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = PortoExpatsTheme.colors.tileBackground)
            .clickable(onClick = onClick)
    ) {
        if (photoUrl != null) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 140.dp)
                    .background(PortoExpatsTheme.colors.purpleText),
            )
        }
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
            Text(
                text = date,
                style = PortoExpatsTheme.typography.text2,
                color = PortoExpatsTheme.colors.secondaryText,
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = title,
                style = PortoExpatsTheme.typography.h3,
                color = PortoExpatsTheme.colors.primaryText,
            )
        }
    }
}
