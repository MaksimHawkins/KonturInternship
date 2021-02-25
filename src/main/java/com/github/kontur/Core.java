package com.github.kontur;

import com.blade.Blade;

public class Core {

    private static UnitManager unitManager;

    public static void main(String[] args) {
        new Core().start(args);
    }

    private void start(String[] args) {
        new CsvHandler().testHandle();

        Blade.of()
                .listen(80)
                .appName("KonturInternshipTask")
                .devMode(true)
                .start();
    }

    public static UnitManager getUnitManager() {
        return unitManager;
    }
}
