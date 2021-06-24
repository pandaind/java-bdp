package com.example.demo.state;

public class PrinterOnline extends PrinterController{
    @Override
    public void pushPower(Printer print) {
        System.out.println("\nClearing buffer and shutting down. . .");
        print.setPrinterState(new PrinterOffline());
    }
}
