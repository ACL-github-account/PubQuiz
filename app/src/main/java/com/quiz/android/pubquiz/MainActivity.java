package com.quiz.android.pubquiz;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.quiz.android.pubquiz.QuestionClass;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private TextView questionText;
    private boolean updateBool = true;
    public Locale defaultLocale  = Locale.getDefault();


    public int answersCorrect = 0;

    public int currentQuestion = 0;
    public final QuestionClass[] questionArray = {
            new QuestionClass(R.string.question_1, false),
            new QuestionClass(R.string.question_2, false),
            new QuestionClass(R.string.question_3, false),
            new QuestionClass(R.string.question_4, false),
            new QuestionClass(R.string.question_5, false),
            new QuestionClass(R.string.question_6, false),
            new QuestionClass(R.string.question_7, false),
            new QuestionClass(R.string.question_8, false),
            new QuestionClass(R.string.question_9, false),
            new QuestionClass(R.string.question_10, false),
            new QuestionClass(R.string.question_11, false),
            new QuestionClass(R.string.question_12, false),
            new QuestionClass(R.string.question_13, false),
            new QuestionClass(R.string.question_14, false),
            new QuestionClass(R.string.question_15, false),
            new QuestionClass(R.string.question_16, false),
            new QuestionClass(R.string.question_17, false),
            new QuestionClass(R.string.question_18, false),
            new QuestionClass(R.string.question_19, false),
            new QuestionClass(R.string.question_20, false),
            new QuestionClass(R.string.question_21, false),
            new QuestionClass(R.string.question_22, false),
            new QuestionClass(R.string.question_23, false),
            new QuestionClass(R.string.question_24, false),
            new QuestionClass(R.string.question_25, false),
            new QuestionClass(R.string.question_26, false),
            new QuestionClass(R.string.question_27, false),
            new QuestionClass(R.string.question_28, false),
            new QuestionClass(R.string.question_29, false),
            new QuestionClass(R.string.question_30, false)
    };

    public final int maxQuestions = questionArray.length - 1;

    public void ratingIntent(){
        updateBool = false;
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
        questionText.setText(R.string.thanks);

        Intent i = new Intent(MainActivity.this, rating.class);
        i.putExtra("QuestionsCorrect", answersCorrect);
        startActivity(i);
    }

    public void updateQuestionText(){
        if (updateBool == true) {
            questionText.setText(questionArray[currentQuestion].question);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        questionText = (TextView) findViewById(R.id.questionText);

        Toast.makeText(MainActivity.this, defaultLocale.getLanguage(), Toast.LENGTH_LONG).show();

        trueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(questionArray[currentQuestion].correctAnswer == true){
                    answersCorrect++;
                    Toast.makeText(MainActivity.this, getString(R.string.answer_true)+", "+answersCorrect+"/"+String.valueOf(maxQuestions+1)+" "+getString(R.string.right), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, getString(R.string.answer_false)+", " + answersCorrect + "/"+String.valueOf(maxQuestions+1)+" "+getString(R.string.right), Toast.LENGTH_SHORT).show();
                }
                if (currentQuestion != maxQuestions) {
                    currentQuestion++;
                } else {
                    ratingIntent();
                }
                updateQuestionText();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(questionArray[currentQuestion].correctAnswer == false){
                    answersCorrect++;
                    Toast.makeText(MainActivity.this, getString(R.string.answer_true)+", "+answersCorrect+"/"+String.valueOf(maxQuestions+1)+" "+getString(R.string.right), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, getString(R.string.answer_false)+", " + answersCorrect + "/"+String.valueOf(maxQuestions+1)+" "+getString(R.string.right), Toast.LENGTH_SHORT).show();
                }
                if (currentQuestion != maxQuestions) {
                    currentQuestion++;
                } else {
                    ratingIntent();
                }
                updateQuestionText();
            }
        });
    }
}