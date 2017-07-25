package com.callegasdev.injector;

import com.callegasdev.services.Bath;
import com.callegasdev.services.BathService;
import com.callegasdev.services.CutHair;
import com.callegasdev.services.CutHairService;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(BathService.class).to(Bath.class);
        bind(CutHairService.class).to(CutHair.class);
    }
}
