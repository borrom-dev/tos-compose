import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import xyz.edsync.common.util.extension.textSizeResource
import xyz.edsync.common.util.ui.DefaultText
import xyz.edsync.common.util.ui.DotsIndicator
import xyz.edsync.quiz_game.R
import xyz.edsync.quiz_game.R.drawable
import xyz.edsync.quiz_game.feature.ui.BackgroundColor
import xyz.edsync.quiz_game.feature.ui.DetailTextColor
import xyz.edsync.quiz_game.feature.ui.PrimaryTextColor
import xyz.edsync.common.R as CR

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun StartQuizContent() {
    val dp24 = dimensionResource(id = CR.dimen.dp_24)
    val dp46 = dimensionResource(id = CR.dimen.dp_46)
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = BackgroundColor)
        ) {
            Image(
                modifier = Modifier.padding(top = dp46),
                painter = painterResource(id = drawable.ic_start_questions),
                contentDescription = "Start Logo"
            )
            HorizontalPager(pageCount = 3) {
                Card(
                    modifier = Modifier.padding(horizontal = dp24),
                    shape = RoundedCornerShape(dimensionResource(id = CR.dimen.dp_40))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = dp24)
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        DefaultText(
                            modifier = Modifier.padding(horizontal = dp24),
                            text = stringResource(id = R.string.text_title_start),
                            fontSize = textSizeResource(id = CR.dimen.sp_24),
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = PrimaryTextColor
                            )
                        )
                        DefaultText(
                            modifier = Modifier.padding(
                                top = dimensionResource(id = CR.dimen.dp_8),
                                start = dp46,
                                end = dp46
                            ),
                            text = stringResource(id = R.string.text_desc_start),
                            style = TextStyle(
                                color = DetailTextColor,
                                textAlign = TextAlign.Center
                            )
                        )

                        DotsIndicator(totalDots = 3, selectedIndex = it)
                    }
                }
            }
        }
    }
}