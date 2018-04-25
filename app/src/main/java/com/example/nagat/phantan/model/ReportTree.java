package com.example.nagat.phantan.model;

/**
 * Created by nagat on 25/4/2018.
 */

public class ReportTree {

    private User userReport;
    private String messageReport;
    private long timeSendReport;
    private Tree treeReport;
    public ReportTree(User userReport, String messageReport, long timeSendReport,Tree treeReport) {
        this.userReport = userReport;
        this.messageReport = messageReport;
        this.timeSendReport = timeSendReport;
        this.treeReport = treeReport;
    }

    public ReportTree() {
    }

    public Tree getTreeReport() {
        return treeReport;
    }

    public void setTreeReport(Tree treeReport) {
        this.treeReport = treeReport;
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
