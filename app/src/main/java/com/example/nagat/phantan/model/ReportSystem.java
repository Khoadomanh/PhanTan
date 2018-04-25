package com.example.nagat.phantan.model;

/**
 * Created by nagat on 24/4/2018.
 */

public class ReportSystem {
    private User userReport;
    private String messageReport;
    private long timeSendReport;

    public ReportSystem(User userReport, String messageReport, long timeSendReport) {
        this.userReport = userReport;
        this.messageReport = messageReport;
        this.timeSendReport = timeSendReport;
    }

    public ReportSystem() {
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
