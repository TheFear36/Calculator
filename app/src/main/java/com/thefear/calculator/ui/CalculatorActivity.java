package com.thefear.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.thefear.calculator.Presenter.CalculatorPreseter;
import com.thefear.calculator.R;
import com.thefear.calculator.logic.CalculatorImp;
import com.thefear.calculator.logic.Operation;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private CalculatorPreseter presener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        presener = new CalculatorPreseter(this, new CalculatorImp());

        txtResult = findViewById(R.id.text_view);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presener.onDigitPressed(digits.get(view.getId()));
            }
        };


        findViewById(R.id.key_0).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_1).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitsClickListener);


        Map<Integer, Operation> operation = new HashMap<>();
        operation.put(R.id.key_plus, Operation.ADD);
        operation.put(R.id.key_minus, Operation.SUB);
        operation.put(R.id.key_div, Operation.DIV);
        operation.put(R.id.key_sqrt, Operation.SQRT);
        operation.put(R.id.key_mult, Operation.MULT);
        operation.put(R.id.key_module, Operation.MODUL);
        operation.put(R.id.key_exponentiation, Operation.EXPON);

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presener.onOperationPressed(operation.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_div).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_sqrt).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_module).setOnClickListener(operationsClickListener);


        findViewById(R.id.key_summ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presener.onSummKeyPressed();
            }
        });

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presener.onDotPressed();
            }
        });

        findViewById(R.id.key_clean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presener.onCleanPressed();
            }
        });

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}