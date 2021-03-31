package com.quiz.android.pubquiz;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class rating extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);


        int answersCorrect = getIntent().getExtras().getInt("QuestionsCorrect");
        LinearLayout starLayout = findViewById(R.id.starLayout);
        ImageView[] starsArray = {
                findViewById(R.id.star1),
                findViewById(R.id.star2),
                findViewById(R.id.star3),
                findViewById(R.id.star4),
                findViewById(R.id.star5)
        };
        int stars = 0;


        TextView aCorrectText = (TextView) findViewById(R.id.correctAnswersRatingText);
        TextView starText = (TextView) findViewById(R.id.starRating);

        String wellDoneString[] = getString(R.string.score_string).split("-");

        aCorrectText.setText(wellDoneString[0] + String.valueOf(answersCorrect) + wellDoneString[1]);
        if (answersCorrect < 10){
            stars = 1;
        } else if (answersCorrect < 20){
            stars = 2;
        } else if (answersCorrect < 30){
            stars = 3;
        } else if (answersCorrect == 30){
            stars = 5;
        }
        starText.setText(String.valueOf(stars)+" "+getString(R.string.stars));
        for (int x = 0; x<stars; x++){
            starsArray[x].setVisibility(1);
        }
    }
}