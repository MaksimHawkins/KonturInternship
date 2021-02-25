package com.github.kontur;

import java.util.ArrayList;

public class UnitManager {

    private ArrayList<Unit> units;

    public UnitManager() {
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
