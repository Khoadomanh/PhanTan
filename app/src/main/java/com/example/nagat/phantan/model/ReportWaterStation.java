package com.example.nagat.phantan.model;

/**
 * Created by nagat on 25/4/2018.
 */

public class ReportWaterStation {
    private User userReport;
    private String messageReport;
    private long timeSendReport;
    private WaterStation waterStationReport;

    public ReportWaterStation(User userReport, String messageReport, long timeSendReport, WaterStation waterStationReport) {
        this.userReport = userReport;
        this.messageReport = messageReport;
        this.timeSendReport = timeSendReport;
        this.waterStationReport = waterStationReport;
    }

    public WaterStation getWaterStationReport() {
        return waterStationReport;
    }

    public void setWaterStationReport(WaterStation waterStationReport) {
        this.waterStationReport = waterStationReport;
    }

    public ReportWaterStation() {
    }

    public User getUserReport() {
        return userReport;
    }

    public void setUserReport(User userReport) {
        this.userReport = userReport;
    }

    public String getMessageReport() {
        return messageReport;
    }

    public void setMessageReport(String messageReport) {
        this.messageReport = messageReport;
    }

    public long getTimeSendReport() {
        return timeSendReport;
    }

    public void setTimeSendReport(long timeSendReport) {
        this.timeSendReport = timeSendReport;
    }
}
