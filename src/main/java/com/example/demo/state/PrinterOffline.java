package com.example.demo.state;

public class PrinterOffline extends PrinterController{
    @Override
    public void pushPower(Printer printer) {
        System.out.println("\nPowering printer on please wait. . .");
        printer.setPrinterState(new PrinterOnline());
    }
}
