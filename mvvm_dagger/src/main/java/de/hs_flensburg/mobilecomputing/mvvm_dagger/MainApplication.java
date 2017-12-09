package de.hs_flensburg.mobilecomputing.mvvm_dagger;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import de.hs_flensburg.mobilecomputing.mvvm_dagger.di.DaggerMainComponent;

public class MainApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerMainComponent.create();
    }
}
