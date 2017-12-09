package de.hs_flensburg.mobilecomputing.mvvm_dagger.di;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import de.hs_flensburg.mobilecomputing.mvvm_dagger.BankingService;
import de.hs_flensburg.mobilecomputing.mvvm_dagger.MainActivity;
import de.hs_flensburg.mobilecomputing.mvvm_dagger.MainViewModel;

@Module
public abstract class MainModule {
    @Provides
    static BankingService provideBankingService() {
        return new BankingService();
    }

    @Provides
    static MainViewModel provideMainViewModel(BankingService bankingService) {
        return new MainViewModel(bankingService);
    }

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();
}
