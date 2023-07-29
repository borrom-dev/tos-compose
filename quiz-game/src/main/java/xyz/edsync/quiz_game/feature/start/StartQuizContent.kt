
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edsync.quiz_game.R
import xyz.edsync.quiz_game.feature.ui.BackgroundColor
import xyz.edsync.quiz_game.feature.ui.DetailTextColor
import xyz.edsync.quiz_game.feature.ui.PrimaryTextColor
import xyz.edsync.common.util.ui.DefaultText

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun StartQuizContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BackgroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_start_questions),
                contentDescription = "Start Logo"
            )
            HorizontalPager(pageCount = 3) {
                Card {
                    Column {
                        DefaultText(
                            modifier = Modifier.padding(24.dp),
                            text = "Interest QUIZ Awaits You",
                            fontSize = 24.sp,
                            style = androidx.compose.ui.text.TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = PrimaryTextColor
                            )
                        )

                        DefaultText(
                            text = "play quizzes with your friends and get various prizes",
                            style = androidx.compose.ui.text.TextStyle(
                                color = DetailTextColor,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}