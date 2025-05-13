package com.data.demo61.request;

import lombok.Data;

@Data

public class LessionReques {
    private String lessionName;
    private String soGio;
    private String moTaLession;


    public LessionReques() {
    }
    public LessionReques(String lessionName, String soGio, String moTaLession) {
        this.lessionName = lessionName;
        this.soGio = soGio;
        this.moTaLession = moTaLession;
    }
}
