package com.iamoem.owmclient.di;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.iamoem.owmclient.model.api.OWMModule;
import com.iamoem.owmclient.model.api.OWMService;
import com.iamoem.owmclient.utility.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by AzamatMurzagalin on 05.07.2016.
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    OWMService provideApiInterface() {
        return OWMModule.getService(Constants.baseUrl);
    }


    @Provides
    @Singleton
    @Named(Constants.ioThreadName)
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(Constants.mainThreadName)
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
