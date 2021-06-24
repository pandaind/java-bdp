package com.example.demo.state;

public class StateClient {
    public static void run() {

        PrinterOffline initialPrinterState = new PrinterOffline();
        Printer printer = new Printer(initialPrinterState);

        System.out.println("\n");

        printer.pushPowerButton();
        printer.pushPowerButton();
        printer.pushPowerButton();
    }
}
