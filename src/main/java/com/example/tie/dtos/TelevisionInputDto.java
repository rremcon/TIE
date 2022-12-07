package com.example.tie.dtos;

import com.example.tie.models.Television;

public class TelevisionInputDto {

    public Long id;

    public String type;
    public String brand;
    public String name;
    public double price;
    public double availableSize;
    public double refreshRate;
    public String screenType;
    public String screenQuality;
    public boolean smartTv;
    public boolean wifi;
    public boolean voiceControl;
    public boolean hdr;
    public boolean bluetooth;
    public boolean ambiLight;
    public int originalStock;
    public int sold;


    public Television toTelevision(TelevisionInputDto televisionInputDto) {
        var tv = new Television();

        tv.setId(id);
        tv.setType(type);
        tv.setBrand(brand);
        tv.setName(name);
        tv.setPrice(price);
        tv.setAvailableSize(availableSize);
        tv.setRefreshRate(refreshRate);
        tv.setScreenType(screenType);
        tv.setScreenQuality(screenQuality);
        tv.setSmartTv(smartTv);
        tv.setWifi(wifi);
        tv.setVoiceControl(voiceControl);
        tv.setHdr(hdr);
        tv.setBluetooth(bluetooth);
        tv.setAmbiLight(ambiLight);
        tv.setOriginalStock(originalStock);
        tv.setSold(sold);


        return tv;
    }

}
