public class FirstActivity extends AppCompatActivity {
    Button switchToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        switchToSecondActivity = findViewById(R.id.activity_first_button);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesWithData() {
        Intent switchActivityIntent = new Intent(this, SecondActivity.class);
        switchActivityIntent.putExtra("message", "From: " + FirstActivity.class.getSimpleName());
        startActivity(switchActivityIntent);
    }

}