package com.projectpl.safeapi.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "azure.log.store")
@Component
public @Data class LogStoreEnv {
    private String azureSharedKey;
    private String azureWid;
    private String appName;
    private String appVersion;

    // log manual
    @Value("true")
    private Boolean payload;

    public String getAzureWid() {
        return azureWid;
    }

    public String getAzureSharedKey() {
        return azureSharedKey;
    }

    public void setAppName(String appNames) {
        this.appName = appNames;
    }

    public void setAppVersion(String appVersions) {
        this.appVersion = appVersions;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }
}