package de.hs_flensburg.mobilecomputing.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import de.hs_flensburg.mobilecomputing.mvp.R;

public class MainActivity extends Activity implements View.OnClickListener, IMainView{

    protected Button addButton;
    protected Button withdrawButton;
    protected TextView amountText;

    protected IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.buttonAdd);
        withdrawButton = (Button) findViewById(R.id.buttonWithdraw);
        amountText = (TextView) findViewById(R.id.textAmount);

        addButton.setOnClickListener(this);
        withdrawButton.setOnClickListener(this);

        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void showBalance(float balance) {
        amountText.setText(String.format("%.2f €",balance));
    }

    @Override
    public void onClick(View view) {
        if(view == addButton) {
            mainPresenter.addToBalance();
        } else if(view == withdrawButton) {
            mainPresenter.withdrawFromBalance();
        }
    }
}
