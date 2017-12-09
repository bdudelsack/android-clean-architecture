package de.hs_flensburg.mobilecomputing.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainViewModel extends BaseObservable {
    @Bindable
    protected String balance;

    protected BankingService bankingService;

    public MainViewModel() {
        bankingService = new BankingService();
    }

    public String getBalance() {
        return String.format("%.2f €",bankingService.getBalance());
    }

    public void addToBalance() {
        bankingService.modifyBalance(10.0f);
        notifyPropertyChanged(BR.balance);
    }

    public void withdrawFromBalance() {
        bankingService.modifyBalance(-10.0f);
        notifyPropertyChanged(BR.balance);
    }
}
