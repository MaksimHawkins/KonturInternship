package com.github.kontur;

import com.blade.Blade;

import java.nio.file.Paths;

public class Core {

    private static UnitManager unitManager;
    private static CsvHandler csvHandler;

    public static void main(String[] args) {
        new Core().start(args);
    }

    private void start(String[] args) {
        unitManager = new UnitManager();

        csvHandler = new CsvHandler();
        csvHandler.handleFile(Paths.get("D:\\Dev\\ufo.csv"));

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
