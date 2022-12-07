package com.example.tie.dtos;

import com.example.tie.models.Television;

public class TelevisionDto {

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

    public RemoteDto remote;


    public static TelevisionDto fromTelevision(Television tv) {
        var tvDto = new TelevisionDto();

        tvDto.id = tv.getId();
        tvDto.type = tv.getType();
        tvDto.brand = tv.getBrand();
        tvDto.name = tv.getName();
        tvDto.price = tv.getPrice();
        tvDto.availableSize = tv.getAvailableSize();
        tvDto.refreshRate = tv.getRefreshRate();
        tvDto.screenType = tv.getScreenType();
        tvDto.screenQuality = tv.getScreenQuality();
        tvDto.smartTv = tv.getSmartTv();
        tvDto.wifi = tv.getWifi();
        tvDto.voiceControl = tv.getVoiceControl();
        tvDto.hdr = tv.getHdr();
        tvDto.bluetooth = tv.getBluetooth();
        tvDto.ambiLight = tv.getAmbiLight();
        tvDto.originalStock = tv.getOriginalStock();
        tvDto.sold = tv.getSold();


        return tvDto;
    }

}
