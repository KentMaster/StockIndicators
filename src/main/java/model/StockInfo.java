package model;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

/**
 * Created by li on 12/21/14.
 */
public class StockInfo {
    //Date	Open	High	Low	Close	Volume	Adj Close

    @Id
    private BigInteger id;
    private String date;
    private double open;
    private double high;
    private double low;
    private BigInteger volume;
    private double adjustedClose;

    public StockInfo(String date, double open, double high, double low, BigInteger volume, double adjustedClose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.adjustedClose = adjustedClose;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    public double getAdjustedClose() {
        return adjustedClose;
    }

    public void setAdjustedClose(double adjustedClose) {
        this.adjustedClose = adjustedClose;
    }
}
