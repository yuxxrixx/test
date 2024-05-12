import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class CommunityActivity : AppCompatActivity() {

    private lateinit var postTitleEditText: EditText
    private lateinit var postContentEditText: EditText
    private lateinit var postButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postTitleEditText = findViewById(R.id.postTitleEditText)
        postContentEditText = findViewById(R.id.postContentEditText)
        postButton = findViewById(R.id.postButton)

        postButton.setOnClickListener {
            val title = postTitleEditText.text.toString().trim()
            val content = postContentEditText.text.toString().trim()
            if (title.isNotEmpty() && content.isNotEmpty()) {

                postTitleEditText.text.clear()
                postContentEditText.text.clear()
            }
        }
    }
}