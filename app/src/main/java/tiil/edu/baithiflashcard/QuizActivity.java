package tiil.edu.baithiflashcard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView txtQuestion, txtResult;
    RadioButton rb1, rb2, rb3;
    RadioGroup radioGroup;
    Button btnNext, btnHome;

    String[] questions = {
            "Apple nghĩa là gì?",
            "Book nghĩa là gì?",
            "Teacher nghĩa là gì?"
    };

    String[][] options = {
            {"Quả táo", "Con mèo", "Cái bàn"},
            {"Xe đạp", "Quyển sách", "Con chó"},
            {"Giáo viên", "Cái ghế", "Ngôi nhà"}
    };

    int[] answers = {0, 1, 0};

    int currentQuestion = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtResult = findViewById(R.id.txtResult);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        radioGroup = findViewById(R.id.radioGroup);

        btnNext = findViewById(R.id.btnNext);
        btnHome = findViewById(R.id.btnHome);

        loadQuestion();

        btnNext.setOnClickListener(v -> {

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {

                int selected = radioGroup.indexOfChild(
                        findViewById(selectedId));

                if (selected == answers[currentQuestion]) {
                    score++;
                }

                currentQuestion++;

                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {

                    txtQuestion.setText("Hoàn thành bài trắc nghiệm!");
                    txtResult.setText("Điểm của bạn: "
                            + score + "/" + questions.length);

                    radioGroup.setVisibility(View.GONE);
                    btnNext.setVisibility(View.GONE);
                    btnHome.setVisibility(View.VISIBLE);
                }
            }
        });

        btnHome.setOnClickListener(v -> finish());
    }

    private void loadQuestion() {

        txtQuestion.setText(questions[currentQuestion]);

        rb1.setText(options[currentQuestion][0]);
        rb2.setText(options[currentQuestion][1]);
        rb3.setText(options[currentQuestion][2]);

        radioGroup.clearCheck();
    }
}