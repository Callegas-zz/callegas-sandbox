package com.callegasdev.services;

public class MockCutHairService implements CutHairService {
    @Override
    public boolean execute(Integer petId, String cutHairType) {
        return true;
    }
}
