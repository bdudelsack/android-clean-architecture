package de.hs_flensburg.mobilecomputing.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    protected BankingService bankingService;

    protected Button addButton;
    protected Button withdrawButton;
    protected TextView amountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.buttonAdd);
        withdrawButton = (Button) findViewById(R.id.buttonWithdraw);
        amountText = (TextView) findViewById(R.id.textAmount);

        addButton.setOnClickListener(this);
        withdrawButton.setOnClickListener(this);

        bankingService = new BankingService();
    }

    protected void update() {
        amountText.setText(String.format("%.2f €",bankingService.getBalance()));
    }

    @Override
    public void onClick(View view) {
        if(view == addButton) {
            bankingService.modifyBalance(10.0f);
        } else if(view == withdrawButton) {
            bankingService.modifyBalance(-10.0f);
        }

        update();
    }
}
