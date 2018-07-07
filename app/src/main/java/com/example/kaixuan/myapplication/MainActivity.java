package com.example.kaixuan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
            btn_6, btn_7, btn_8, btn_9, btn_equal,
            btn_point, btn_clean, btn_del, btn_plus,
            btn_minus, btn_multiply, btn_divide,
            btn_sin, btn_cos, btn_tan, btn_pi, btn_e,
            btn_fac, btn_power, btn_ln, btn_log;

    private TextView text;
    String result;
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.button19);
        btn_1 = (Button) findViewById(R.id.button15);
        btn_2 = (Button) findViewById(R.id.button16);
        btn_3 = (Button) findViewById(R.id.button17);
        btn_4 = (Button) findViewById(R.id.button11);
        btn_5 = (Button) findViewById(R.id.button12);
        btn_6 = (Button) findViewById(R.id.button13);
        btn_7 = (Button) findViewById(R.id.button6);
        btn_8 = (Button) findViewById(R.id.button7);
        btn_9 = (Button) findViewById(R.id.button8);
        btn_clean = (Button) findViewById(R.id.button3);
        btn_equal = (Button) findViewById(R.id.button21);
        btn_minus = (Button) findViewById(R.id.button10);
        btn_multiply = (Button) findViewById(R.id.button5);
        btn_plus = (Button) findViewById(R.id.button14);
        btn_point = (Button) findViewById(R.id.button20);
        btn_del = (Button) findViewById(R.id.button9);
        btn_divide = (Button) findViewById(R.id.button4);

        btn_sin = (Button) findViewById(R.id.button22);
        btn_cos = (Button) findViewById(R.id.button23);
        btn_tan = (Button) findViewById(R.id.button24);
        btn_pi = (Button) findViewById(R.id.button25);
        btn_e = (Button) findViewById(R.id.button26);
        btn_power = (Button) findViewById(R.id.button27);
        btn_fac = (Button) findViewById(R.id.button28);
        btn_ln = (Button) findViewById(R.id.button29);
        btn_log = (Button) findViewById(R.id.button30);

        text = (TextView) findViewById(R.id.textView2);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_clean.setOnClickListener(this);

        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_pi.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_power.setOnClickListener(this);
        btn_fac.setOnClickListener(this);
        btn_ln.setOnClickListener(this);
        btn_log.setOnClickListener(this);

        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = text.getText().toString();
        switch (v.getId()) {
            case R.id.button19://0
            case R.id.button15://1
            case R.id.button16://2
            case R.id.button17://3
            case R.id.button11://4
            case R.id.button12://5
            case R.id.button13://6
            case R.id.button6://7
            case R.id.button7://8
            case R.id.button8://9
            case R.id.button20://.
                if (clear_flag) {
                    clear_flag = false;
                    text.setText("");
                }
                str += ((Button) v).getText();
                text.setText(str);
                break;

            case R.id.button14://+
            case R.id.button10://-
            case R.id.button5://×
            case R.id.button4://÷
                if (clear_flag) {
                    clear_flag = false;
                    text.setText("");
                }
                str += " " + ((Button) v).getText() + " ";
                text.setText(str);
                break;

            case R.id.button3://AC
                clear_flag = false;
                text.setText("");
                break;

            case R.id.button9://DEL
                if (clear_flag) {
                    clear_flag = false;
                    text.setText("");
                }
                if (str != null && !str.equals("")) {
                    text.setText(str.substring(0, str.length() - 1));
                }
                break;

            case R.id.button27:// ^
                if (str.length() != 0) {
                    str += " " + "^" + " ";
                    text.setText(str);
                } else {
                    result = "0";
                    return;
                }
                break;

            case R.id.button22:  //sin
            case R.id.button23:  //cos
            case R.id.button24:  //tan
            case R.id.button30:  //log
            case R.id.button29:  //ln
            case R.id.button28:  //!


                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                str += " " + ((Button) v).getText() + " ";
                text.setText(str);
                break;

            case R.id.button26:  //e
            case R.id.button25:  //π
                if (clear_flag) {
                    clear_flag = false;
                    text.setText("");
                }
                str +=((Button) v).getText();
                text.setText(str);
                break;

            case R.id.button21://=
                getResult();
                break;

            default:
                break;
        }
    }

    private void getResult() {
        String exp = text.getText().toString();

        if (exp == null || exp.equals("")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }

        clear_flag = true;
        double result = 0;


        if (exp.contains("+") || exp.contains("-") || exp.contains("×") || exp.contains("÷")) {

            try {
                String s1 = exp.substring(0, exp.indexOf(" "));
                String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
                String s2 = exp.substring(exp.indexOf(" ") + 3);


                if (!s1.equals("") && !s2.equals("")) {
                    double d1 = Double.parseDouble(s1);
                    double d2 = Double.parseDouble(s2);

                    if (op.equals("+")) {
                        result = d1 + d2;
                    } else if (op.equals("-")) {
                        result = d1 - d2;
                    } else if (op.equals("×")) {
                        result = d1 * d2;
                    } else if (op.equals("÷")) {
                        if (d2 == 0) {
                            throw new ArithmeticException();
                        } else {
                            result = d1 / d2;
                        }
                    }

                    if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                        int r = (int) result;
                        String string = r + "";
                        text.setText(string);
                    } else {
                        String string = result + "";
                        text.setText(string);
                    }
                } else if (!s1.equals("") && s2.equals("")) {
                    text.setText(exp);
                } else if (s1.equals("") && !s2.equals("")) {
                    double d2 = Double.parseDouble(s2);
                    if (op.equals("+")) {
                        result = 0 + d2;
                    } else if (op.equals("-")) {
                        result = 0 - d2;
                    } else if (op.equals("×")) {
                        result = 0;
                    } else if (op.equals("÷")) {
                        result = 0;
                    }
                    String string = result + "";
                    text.setText(string);
                    if (!s2.contains(".")) {
                        int r = (int) result;
                        text.setText(r + " ");
                    } else {
                        text.setText(result + " ");
                    }
                } else {
                    text.setText("");
                }
            }catch(NumberFormatException e){
                text.setText("Number Format ERROR！");
            }
            catch (ArithmeticException e){
                text.setText("Div Number CAN Not 0");
            }
        }

        else if (exp.contains("sin") || exp.contains("cos") || exp.contains("tan")) {

            try{
                String string;
            String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ") + 4);
            String param2 = exp.substring(exp.indexOf(" ") + 5);
            Double arg2;

            final double pi = 3.1415926353;
            switch (param2){
            case"π":
                arg2 = 3.1415926353;
                break;
             default:
                 arg2 =Double.parseDouble(param2);
            }

            switch (op) {
                case "sin":
                    result = (int)(Math.sin(arg2/180*pi)*100);
                    string = result/100.0 + "";
                    text.setText(string);
                    break;
                case "cos":
                    result = (int)(Math.cos(arg2/180*pi)*100);
                    string = result/100.0 + "";
                    text.setText(string);
                    break;
                case "tan":
                    result = (int) (Math.tan(arg2/180*pi)*100);
                    string = result/100.0 + "";
                    text.setText(string);
                    break;
                default:
                    text.setText("错误");
            }
        }catch (NumberFormatException e){
                text.setText("Number Format ERROR!");
            }
        }

        else if (exp.contains("!")) {
        try{
            String    param2 = exp.substring(exp.indexOf(" ") + 3);
            int    arg2 = Integer.parseInt(param2);
            String string;
            long tmpResult = 1;
            for (int i = 1; i <=  arg2; i++)
                tmpResult = tmpResult * i;
            result = tmpResult;
            string = result + "";
            text.setText(string);
        }catch(NumberFormatException e){
            text.setText("Factorial No Include . ");
        }
        }

        else if (exp.contains("ln") || exp.contains("log")) {
            try {
                if (exp.equals("ln")) {
                    String param2 = exp.substring(exp.indexOf(" ") + 4);
                    Double arg2;

                    switch (param2) {
                        case "e":
                            arg2 = 2.7182818284;
                            break;
                        default:
                            arg2 = Double.parseDouble(param2);
                    }
                    String string;
                    result = Math.log(arg2);
                    string = result + "";
                    text.setText(string);

                } else {
                    String param2 = exp.substring(exp.indexOf(" ") + 4);
                    Double arg2 = Double.parseDouble(param2);
                    result = Math.log10(arg2);
                    String string = result + "";
                    text.setText(string);
                }
            }catch(NumberFormatException e){
                text.setText("error ");
            }

        }

        else if (exp.contains("^")) {
          String  param1 = exp.substring(0,exp.indexOf(" "));
          Double  arg1 = Double.parseDouble(param1);
          String  param2 = exp.substring(exp.indexOf(" ")+3);
          Double  arg2 = Double.parseDouble(param2);
            result = Math.pow(arg1,arg2);
            String string = result+"";
            text.setText(string);
        }

    }
}