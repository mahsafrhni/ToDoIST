import android.os.Bundle;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

public class AddTask extends AppCompatActivity {
    EditText title, date_and_time, priority, other;
    private final static int numberOfTasks = 1000;
    Set<Tasks> tasks = new HashSet<Tasks>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = findViewById(R.id.title);
        date_and_time = findViewById(R.id.date);
        priority = findViewById(R.id.priority);
        other = findViewById(R.id.other);
        String Title = title.getText().toString();
        String Date_And_Time = date_and_time.getText().toString();
        String Priority = priority.getText().toString();
        String Other = other.getText().toString();
        Tasks task = new Tasks(Title, Date_And_Time, Priority, Other);
        tasks.add(task);
    }
}
