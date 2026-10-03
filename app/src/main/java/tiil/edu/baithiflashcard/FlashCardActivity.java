package tiil.edu.baithiflashcard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FlashCardActivity extends AppCompatActivity {

    TextView txtWord, txtMeaning;
    Button btnNext, btnHome;

    String[] words = {
            "Apple",
            "Book",
            "Computer",
            "School",
            "Teacher"
    };

    String[] meanings = {
            "Quả táo",
            "Quyển sách",
            "Máy tính",
            "Trường học",
            "Giáo viên"
    };

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        txtWord = findViewById(R.id.txtWord);
        txtMeaning = findViewById(R.id.txtMeaning);

        btnNext = findViewById(R.id.btnNext);
        btnHome = findViewById(R.id.btnHome);

        txtWord.setText(words[index]);
        txtMeaning.setText(meanings[index]);

        btnNext.setOnClickListener(v -> {

            index++;

            if (index >= words.length) {
                index = 0;
            }

            txtWord.setText(words[index]);
            txtMeaning.setText(meanings[index]);
        });

        btnHome.setOnClickListener(v -> finish());
    }
}