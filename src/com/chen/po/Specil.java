package com.chen.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Specil implements Serializable {
    private int sid;
    //spilinfoid
    private int did;
    //depinfoid
    private String scode;
    //spilinfocode
    private String sname;
    //spilinfoname
    private String saim;
    //spilinfoaim
    private String sprodire;
    //spilinfoprodire
}
