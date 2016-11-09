package com.moilion.circle.r044.interceptor.cdn;

import com.moilion.circle.r044.util.Ipv4Range;

/**
 * @author trydofor
 * @since 2016-10-24
 */
public class CdnFunction {

    private final CdnConfig config;
    private final String ip;

    public CdnFunction(CdnConfig config, String ip) {
        this.config = config;
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String url(String uri) {
        if (config.getChina().contains(ip) || Ipv4Range.isChina(ip)) {
            return config.getHost() + uri + config.getVersion();
        }
        return uri;
    }
}
