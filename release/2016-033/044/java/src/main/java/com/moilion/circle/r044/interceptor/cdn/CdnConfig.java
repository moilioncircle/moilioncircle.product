package com.moilion.circle.r044.interceptor.cdn;

import java.util.Set;

/**
 * @author trydofor
 * @since 2016-11-09
 */

public class CdnConfig {

    private String host = ""; // CDN 主机
    private String version = "20161024"; //2016102401
    private String scope = "china"; // 应用策略，none|all|china
    private Set<String> china = null;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Set<String> getChina() {
        return china;
    }

    public void setChina(Set<String> china) {
        this.china = china;
    }
}
