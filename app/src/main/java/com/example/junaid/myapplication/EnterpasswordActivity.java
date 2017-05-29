package com.example.junaid.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EnterpasswordActivity extends AppCompatActivity {
    EditText editText;
    ImageButton imageButton;
    String Password;
    String Password2;
    Button buttonNext,buttonEqual,button0,button1,button2,button3,button4,button5,button6,button7,button8,
            button9,buttonSubt,buttonPlus,buttonClear,buttonDivide,buttonMultiply;
    float mValueOne , mValueTwo ;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpassword);

        //load password
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        Password = settings.getString("password","");

        SharedPreferences settings2 = getSharedPreferences("PREFS",0);
        Password2 = settings2.getString("Password","112233");


        editText = (EditText) findViewById(R.id.editText);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonSubt = (Button) findViewById(R.id.buttonSubt);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonClear = (Button) findViewById(R.id.buttonClear);


      buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if(text.equals(Password2)){
                    //enter the app
                    Intent intent = new Intent(getApplicationContext(),CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(EnterpasswordActivity.this,"wrong password",Toast.LENGTH_SHORT).show();
                }
            }
        });


       imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if(text.equals(Password)){
                    //enter the app
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(EnterpasswordActivity.this,"wrong password",Toast.LENGTH_SHORT).show();
                }

            }
        });


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"1");
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"2");
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"3");
                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"4");
                    }
                });

                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"5");
                    }
                });

                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"6");
                    }
                });

                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"7");
                    }
                });

                button8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"8");
                    }
                });

                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"9");
                    }
                });

                button0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(editText.getText()+"0");
                    }
                });

                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (editText == null){
                            editText.setText("");
                        }else {
                            mValueOne = Float.parseFloat(editText.getText() + "");
                            mAddition = true;
                            editText.setText(null);
                        }
                    }
                });

                buttonSubt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mValueOne = Float.parseFloat(editText.getText() + "");
                        mSubtract = true ;
                        editText.setText(null);
                    }
                });

                buttonMultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mValueOne = Float.parseFloat(editText.getText() + "");
                        mMultiplication = true ;
                        editText.setText(null);
                    }
                });

                buttonDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mValueOne = Float.parseFloat(editText.getText()+"");
                        mDivision = true ;
                        editText.setText(null);
                    }
                });

                buttonEqual.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mValueTwo = Float.parseFloat(editText.getText() + "");

                        if (mAddition == true){

                            editText.setText(mValueOne + mValueTwo +"");
                            mAddition=false;
                        }


                        if (mSubtract == true){
                            editText.setText(mValueOne - mValueTwo+"");
                            mSubtract=false;
                        }

                        if (mMultiplication == true){
                            editText.setText(mValueOne * mValueTwo+"");
                            mMultiplication=false;
                        }

                        if (mDivision == true){
                            editText.setText(mValueOne / mValueTwo+"");
                            mDivision=false;
                        }
                    }
                });

                buttonClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText("");
                    }
                });

    }
}
