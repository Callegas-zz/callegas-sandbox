package com.callegasdev.services;

/**
 * Created by Fellipe on 5/28/2017.
 */
public class MockBathService implements BathService {
    @Override
    public boolean execute(Integer petId, String bathType, boolean perfume) {
        return true;
    }
}
