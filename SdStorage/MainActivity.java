package com.example.sdstoragereadwrite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView writeText, readText;
    Button writeBn, readBn;
    String filepath="";
    String filename="";
    String fileContent="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeText = findViewById(R.id.writeText);
        readText = findViewById(R.id.readText);
        writeBn = findViewById(R.id.writeButton);
        readBn = findViewById(R.id.readButton);
        filename="text.txt";
        filepath="myFile";
        if (!isExternalStorageAvailableRW()) {
            writeBn.setEnabled(false);
        }
    }

    private boolean isExternalStorageAvailableRW() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


    public void writeTextfn(View view) {

        fileContent=writeText.getText().toString().trim();
        if(!fileContent.equals(" ")) {
            File myextfile = new File(getExternalFilesDir(filepath), filename);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(myextfile, true);
                fos.write(fileContent.getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            writeText.setText("");
            Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();

        }
    }




    public void readTextfn(View view) {
        FileReader fr=null;
        File myextfile=new File(getExternalFilesDir(filepath),filename);
        StringBuilder stringBuilder=new StringBuilder();
        try{
            fr=new FileReader(myextfile);
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
            while(line!=null)
            {
                stringBuilder.append(line).append('\n');
                line= br.readLine();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();

        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            String fileContents="FileContents\n"+stringBuilder.toString();
            readText.setText(fileContents);
        }

    }
}