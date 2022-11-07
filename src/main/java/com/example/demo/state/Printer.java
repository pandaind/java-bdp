package com.example.demo.state;

public class Printer {
  private PrinterController printerState;

  public Printer(PrinterController pState) {
    this.printerState = pState;
  }

  public PrinterController getPrinterState() {
    return printerState;
  }

  public void setPrinterState(PrinterController pState) {
    this.printerState = pState;
  }

  public void pushPowerButton() {
    printerState.pushPower(this);
  }
}
