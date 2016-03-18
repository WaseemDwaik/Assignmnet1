package com.projects.waseem.assignmnet1comp438;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private int randomNumber;
    private Button guess;
    private Button randomize;
    private int answerInt;
    private EditText answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guess=(Button) findViewById(R.id.button);
        randomize=(Button) findViewById(R.id.button2);
        answer=(EditText) findViewById(R.id.editText);
        guess.setClickable(false);
    }
    private void generateRandomNumber(){//Generate a random number (0-1000)
        Random rand=new Random();
        randomNumber= rand.nextInt(1000);
    }
    private void genToast(){//Generate Toast according to entry
        if(Math.abs(answerInt-randomNumber)<=5){//answer is 5 above or under number
            Toast.makeText(getApplicationContext(), "Really Close", Toast.LENGTH_SHORT).show();
        }else{
            if(answerInt>randomNumber)//answer is bigger than the number
                Toast.makeText(getApplicationContext(), "Greater", Toast.LENGTH_SHORT).show();
            else if(answerInt<randomNumber)//answer is lesser than the number
                Toast.makeText(getApplicationContext(), "Smaller", Toast.LENGTH_SHORT).show();
        }
    }
    public void guessNum(View view) {
        try{//Take entry and parse into integer
            answerInt=Integer.parseInt(answer.getText().toString());
        }catch (Exception ex){//In case of an invalid entry
            Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_SHORT).show();
        }
        if(answerInt==randomNumber){//feedback for correct answer
            Toast.makeText(getApplicationContext(), "You Guessed it Correctly!", Toast.LENGTH_SHORT).show();
            guess.setClickable(false);
            randomize.setClickable(true);//allow user to re-randomize
        }else{
            genToast();//generate appropriate toast to answer
        }
    }
    public void genNum(View view) {
        generateRandomNumber();//Generate the number
        guess.setClickable(true);//Allow user to guess
        randomize.setClickable(false);//User is not allowed to re-randomize until guessed
        answer.setText("");
        Toast.makeText(getApplicationContext(), "Number Generated!", Toast.LENGTH_SHORT).show();//feedback toast
    }
}
