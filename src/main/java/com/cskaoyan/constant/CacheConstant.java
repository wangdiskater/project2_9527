package com.cskaoyan.constant;

public enum CacheConstant {
    CACHE_HOME("cache_home")
    ;

    String cacheName;

    CacheConstant(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
