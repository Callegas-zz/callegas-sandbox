package com.callegasdev.msa;

import com.callegasdev.rest.StorageService;
import com.callegasdev.ribbon.RibbonMathClient;
import com.google.inject.AbstractModule;

public class GuiceBindingsModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(RibbonMathClient.class);
    	bind(StorageService.class);
	}
	
}
