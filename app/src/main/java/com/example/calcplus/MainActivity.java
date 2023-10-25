package com.example.calcplus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display;
    String currentInput = "";
    double num1 = 0;
    double num2 = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonSum = findViewById(R.id.buttonadd);
        Button buttonMinus = findViewById(R.id.buttonminus);
        Button buttonMultiply = findViewById(R.id.buttonmultiply);
        Button buttonDivide = findViewById(R.id.buttondivide);
        Button buttonDecimal = findViewById(R.id.buttondecimal);
        Button buttonEqual = findViewById(R.id.buttonequal);
        Button buttonClear = findViewById(R.id.buttonclear);

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("9");
            }
        });

        buttonSum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay("x"); // You can use "×" for multiplication
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay("/");
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateDisplay(".");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!currentInput.isEmpty() && !operator.isEmpty()) {
                    num2 = Double.parseDouble(currentInput);
                    double result = performOperation(num1, num2, operator);
                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    operator = "";
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(""); // Clear the display
                currentInput = "";
                num1 = 0;
                num2 = 0;
                operator = "";
            }
        });
    }

    private double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    // Handle division by zero error
                    return Double.POSITIVE_INFINITY;
                }
            default:
                return num2;
        }
    }

    private void updateDisplay(String text) {
        if (text.matches("[0-9.]")) {
            currentInput += text;
        } else if (text.matches("[+\\-x/]")) {
            if (!operator.isEmpty() && !currentInput.isEmpty()) {
                num1 = Double.parseDouble(currentInput);
                currentInput = "";
            }
            operator = text;
        }
        display.setText(currentInput);
    }

}
