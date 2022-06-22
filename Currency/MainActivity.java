public class MainActivity extends AppCompatActivity {

    public void convertToEuro(View view) {
        EditText editText = (EditText) findViewById(R.id.edtText);

        int dollars = Integer.parseInt(editText.getText().toString());
        int euro = 2000;

        double result = dollars * euro;

        Toast.makeText(MainActivity.this, Double.toString(result), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}