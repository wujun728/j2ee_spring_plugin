package com.xxl.job.core.biz.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by xuxueli on 16/7/22.
 */
public class TriggerParam implements Serializable{
    private static final long serialVersionUID = 42L;

    private int jobId;

    private String executorHandler;
    private String executorParams;

    private boolean glueSwitch;
    private long glueUpdatetime;

    private int logId;
    private long logDateTim;

    private Set<String> logAddress;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getExecutorHandler() {
        return executorHandler;
    }

    public void setExecutorHandler(String executorHandler) {
        this.executorHandler = executorHandler;
    }

    public String getExecutorParams() {
        return executorParams;
    }

    public void setExecutorParams(String executorParams) {
        this.executorParams = executorParams;
    }

    public boolean isGlueSwitch() {
        return glueSwitch;
    }

    public void setGlueSwitch(boolean glueSwitch) {
        this.glueSwitch = glueSwitch;
    }

    public long getGlueUpdatetime() {
        return glueUpdatetime;
    }

    public void setGlueUpdatetime(long glueUpdatetime) {
        this.glueUpdatetime = glueUpdatetime;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public long getLogDateTim() {
        return logDateTim;
    }

    public void setLogDateTim(long logDateTim) {
        this.logDateTim = logDateTim;
    }

    public Set<String> getLogAddress() {
        return logAddress;
    }

    public void setLogAddress(Set<String> logAddress) {
        this.logAddress = logAddress;
    }
}
