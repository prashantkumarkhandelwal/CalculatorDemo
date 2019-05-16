package com.example.prashant.calculatordemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvReresulttv, msg;
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
        addbtn = (Button) findViewById(R.id.addbtn);
        subbtn = (Button) findViewById(R.id.subtractbtn);
        percebtgebtn = (Button) findViewById(R.id.percentgebtn);
        multiplybtn = (Button) findViewById(R.id.multiplybtn);
        eualbtn = (Button) findViewById(R.id.equalbtn);
        dotbtn = (Button) findViewById(R.id.dotbtn);
        doublezerobtn = (Button) findViewById(R.id.doublezerobtn);
        dividebtn = (Button) findViewById(R.id.dividebtn);

        tvReresulttv = (TextView) findViewById(R.id.tvReresulttv);
        msg = (TextView) findViewById(R.id.msg);
        clearScreen();
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
                if (tvReresulttv == null)
                    tvReresulttv.setText("");
                else
                    tvReresulttv.setText(tvReresulttv.getText() + " + ");
            }
        });
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvReresulttv == null)
                    tvReresulttv.setText("");
                else
                    tvReresulttv.setText(tvReresulttv.getText() + " - ");
            }
        });
        ;
        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvReresulttv == null)
                    tvReresulttv.setText("");
                else
                    tvReresulttv.setText(tvReresulttv.getText() + " * ");
            }
        });
        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvReresulttv == null)
                    tvReresulttv.setText("");
                else
                    tvReresulttv.setText(tvReresulttv.getText() + " / ");
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
                if (tvReresulttv == null)
                    tvReresulttv.setText(".");
                else
                    tvReresulttv.setText(tvReresulttv.getText() + ".");
            }
        });
        eualbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equalBtnMethod();

            }
        });

    }

    private void equalBtnMethod() {
        String exp = tvReresulttv.getText().toString();
        int i = 0;
        i = exp.indexOf('%');
        String exp1 = exp;
        if (i != -1) {
            float n1 = Float.parseFloat(exp1.substring(0, i - 1));
            float n2 = Float.parseFloat(exp1.substring(i + 2, exp1.length()));
            float res = (n1 / 100) * n2;
            tvReresulttv.setText(res + "");
        } else {
            Calculation calculation = new Calculation();
            if (calculation.calculate(exp) != -1)
                tvReresulttv.setText(calculation.calculate(exp) + "");
            else tvReresulttv.setText("invalid");
            msg.setText("Ans.");
        }

    }

     void clearScreen() {
        tvReresulttv.setText(" ");
        msg.setText(" ");
    }

     void numberInputMethod(String s) {
        tvReresulttv.setText(tvReresulttv.getText() + s);
    }
}


