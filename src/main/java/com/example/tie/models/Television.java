package com.example.tie.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String brand;
    private String name;
    private double price;
    private double availableSize;
    private double refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambiLight;
    private int originalStock;
    private int sold;

    @OneToOne
    private Remote remote;

    @ManyToOne
    @JoinColumn(name = "cimodule_id")
    private CiModule cimodule;

    @ManyToMany
    private List<WallBracket> wallbrackets;

    public List<WallBracket> getWallbrackets() {
        return wallbrackets;
    }

    public void setWallbrackets(List<WallBracket> wallbrackets) {
        this.wallbrackets = wallbrackets;
    }

    public CiModule getCimodule() {
        return cimodule;
    }

    public void setCimodule(CiModule cimodule) {
        this.cimodule = cimodule;
    }

    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public Television() {
    }

    public Television(Long id, String type, String brand, String name, double price, double availableSize, double refreshRate, String screenType, String screenQuality, boolean smartTv, boolean wifi, boolean voiceControl, boolean hdr, boolean bluetooth, boolean ambiLight, int originalStock, int sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean getHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}