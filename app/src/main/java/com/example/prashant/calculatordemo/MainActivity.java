package com.example.prashant.calculatordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    TextView inputtexttv, tvReresulttv,msg;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, cancelbtn, addbtn,
            subbtn, dividebtn, percebtgebtn, dotbtn,
            eualbtn, doublezerobtn, multiplybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button) findViewById(R.id.zerobtn);
        btn1 = (Button) findViewById(R.id.onebtn);
        btn2 = (Button) findViewById(R.id.twobtn);
        btn3 = (Button) findViewById(R.id.threebtn);
        btn4 = (Button) findViewById(R.id.fourbtn);
        btn5 = (Button) findViewById(R.id.fivebtn);
        btn6 = (Button) findViewById(R.id.sixbtn);
        btn7 = (Button) findViewById(R.id.sevnbtn);
        btn8 = (Button) findViewById(R.id.eigbtn);
        btn9 = (Button) findViewById(R.id.ninebtn);
        cancelbtn = (Button) findViewById(R.id.cancelbtn);
        addbtn= (Button) findViewById(R.id.addbtn);
        subbtn = (Button) findViewById(R.id.subtractbtn);
        percebtgebtn = (Button) findViewById(R.id.percentgebtn);
        multiplybtn = (Button) findViewById(R.id.multiplybtn);
        eualbtn = (Button) findViewById(R.id.equalbtn);
        dotbtn = (Button) findViewById(R.id.dotbtn);
        doublezerobtn= (Button) findViewById(R.id.doublezerobtn);
        dividebtn= (Button) findViewById(R.id.dividebtn);
        inputtexttv= (TextView) findViewById(R.id.inputtexttv);
        tvReresulttv= (TextView) findViewById(R.id.tvReresulttv);
        msg= (TextView) findViewById(R.id.msg);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("0");
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("9");
            }
        });
        doublezerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("00");
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("+");
            }
        });
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("-");
            }
        });
        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("*");
            }
        });
        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("/");
            }
        });
        percebtgebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod("%");
            }
        });

        dotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberInputMethod(".");
            }
        });
        eualbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = inputtexttv.getText().toString();

                Expression e = new Expression(expression);
                String result = String.valueOf(e.calculate());

                tvReresulttv.setText(result);
                msg.setText("Thank You");
            }
        });

    }

    private void clearScreen() {
        inputtexttv.setText("");
        tvReresulttv.setText("0");
    }

    private void numberInputMethod(String value) {
        String input=inputtexttv.getText().toString();
        input=input+value;
        inputtexttv.setText(input);
    }
}
