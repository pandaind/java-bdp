package com.example.demo.state;

public class Runner {
    public static void main(String[] args) {

        PrinterOffline initialPrinterState = new PrinterOffline();
        Printer printer = new Printer(initialPrinterState);

        System.out.println("\n");

        printer.pushPowerButton();
        printer.pushPowerButton();
        printer.pushPowerButton();
    }
}
