package tiil.edu.baithiflashcard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFlashCard, btnQuiz, btnReview, btnStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFlashCard = findViewById(R.id.btnFlashCard);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnReview = findViewById(R.id.btnReview);
        btnStatistics = findViewById(R.id.btnStatistics);

        btnFlashCard.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
            startActivity(intent);
        });

        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });

        btnReview.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
            startActivity(intent);
        });

        btnStatistics.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StatisticsActivity.class);
            startActivity(intent);
        });
    }
}