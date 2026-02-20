package com.jayhalani.quotifycompose.ui.screens.quote_of_the_day

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.createBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import com.jayhalani.quotifycompose.ui.theme.Bold24
import com.jayhalani.quotifycompose.ui.theme.QuotifyComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun QuoteOfDayScreen(
    viewModel: QuoteOfDayViewModel = viewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val quote = viewModel.getQuoteOfTheDay()

    var brush by remember { mutableStateOf(viewModel.getRandomBackgroundBrush()) }
    val parentComposition = rememberCompositionContext()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = AppStrings.TITLE_QUOTE_OF_THE_DAY,
            style = MaterialTheme.typography.Bold24,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Preview of the card
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(2f / 3f)
                .clip(MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            val scale = maxWidth.value / 1000f

            QuoteImageCard(
                quote = quote.text,
                author = quote.author,
                brush = brush,
                scale = scale
            )
        }

        Spacer(Modifier.height(16.dp))

        // Gradient Selector
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(viewModel.backgroundBrushes) { bgBrush ->
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(bgBrush)
                        .clickable { brush = bgBrush }
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        val permissionLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // We'll capture inside the button click which triggers this anyway if needed
            } else {
                Toast.makeText(context, "Storage permission is required to save", Toast.LENGTH_SHORT).show()
            }
        }

        Button(
            onClick = {
                val activity = context as? Activity ?: return@Button

                fun generateAndSaveImage() {
                    scope.launch {
                        val bitmap = captureComposable(
                            activity,
                            parentComposition
                        ) {
                            QuoteImageCard(
                                quote = quote.text,
                                author = quote.author,
                                brush = brush,
                                scale = 1f
                            )
                        }

                        withContext(Dispatchers.IO) {
                            saveBitmap(context, bitmap)
                        }

                        Toast.makeText(context, "Quote saved to Gallery", Toast.LENGTH_SHORT).show()
                    }
                }

                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    val isGranted = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED

                    if (isGranted) {
                        generateAndSaveImage()
                    } else {
                        permissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }
                } else {
                    generateAndSaveImage()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save to Gallery")
        }
    }
}

@Composable
fun QuoteImageCard(
    quote: String,
    author: String,
    brush: Brush,
    scale: Float = 1f
) {
    val quoteFontSize = when {
        quote.length < 50 -> 72.sp
        quote.length < 100 -> 56.sp
        quote.length < 200 -> 48.sp
        else -> 40.sp
    } * scale

    val quoteLineHeight = when {
        quote.length < 50 -> 88.sp
        quote.length < 100 -> 72.sp
        quote.length < 200 -> 64.sp
        else -> 56.sp
    } * scale

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
            .padding((48 * scale).dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "\"$quote\"",
                fontSize = quoteFontSize,
                lineHeight = quoteLineHeight,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(0.9f)
            )

            Spacer(Modifier.height((48 * scale).dp))

            Text(
                text = "- $author",
                fontSize = (40 * scale).sp,
                lineHeight = (48 * scale).sp,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.fillMaxWidth(0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}

suspend fun captureComposable(
    activity: Activity,
    parentComposition: CompositionContext,
    content: @Composable () -> Unit
): Bitmap = withContext(Dispatchers.Main) {

    val composeView = ComposeView(activity).apply {
        setParentCompositionContext(parentComposition)
        setContent {
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.ui.platform.LocalDensity provides androidx.compose.ui.unit.Density(1f)
            ) {
                QuotifyComposeTheme {
                    content()
                }
            }
        }
    }

    val width = 1000
    val height = 1500

    activity.addContentView(
        composeView,
        ViewGroup.LayoutParams(width, height)
    )

    composeView.measure(
        View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
        View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
    )

    composeView.layout(0, 0, width, height)

    delay(16)

    val bitmap = createBitmap(width, height)
    val canvas = Canvas(bitmap)
    composeView.draw(canvas)

    (composeView.parent as ViewGroup).removeView(composeView)

    bitmap
}

fun saveBitmap(context: Context, bitmap: Bitmap) {
    val filename = "quote_${System.currentTimeMillis()}.png"

    val resolver = context.contentResolver

    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + "/Quotify"
            )
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }
    }

    val uri = resolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        contentValues
    )

    uri?.let {
        resolver.openOutputStream(it)?.use { stream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            contentValues.clear()
            contentValues.put(MediaStore.Images.Media.IS_PENDING, 0)
            resolver.update(it, contentValues, null, null)
        }
    }
}
