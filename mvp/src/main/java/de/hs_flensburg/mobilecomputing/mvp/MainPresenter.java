package de.hs_flensburg.mobilecomputing.mvp;

public class MainPresenter implements IMainPresenter {
    protected IMainView view;
    protected BankingService bankingService;

    public MainPresenter(IMainView view) {
        this.view = view;

        bankingService = new BankingService();
    }

    @Override
    public void addToBalance() {
        bankingService.modifyBalance(10.0f);
        view.showBalance(bankingService.getBalance());
    }

    @Override
    public void withdrawFromBalance() {
        bankingService.modifyBalance(-10.0f);
        view.showBalance(bankingService.getBalance());
    }
}
