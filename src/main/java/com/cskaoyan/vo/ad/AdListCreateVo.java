package com.cskaoyan.vo.ad;

/**
 * @Classname AdListCreateVo
 * @Author LM
 * @Description
 * @Data 2019/10/2
 */
public class AdListCreateVo {
   String content;
   boolean enabled;
   String link;
   String name;
   int position;
   String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AdListCreateVo{" +
                "content='" + content + '\'' +
                ", enabled=" + enabled +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", url='" + url + '\'' +
                '}';
    }
}
