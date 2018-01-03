package org.openhab.binding.magnetpoetry.rest;

public class MpItem {

    private String link = null;
    private String type = null;
    private String name = null;
    private String label = null;

    public MpItem(String link, String type, String name, String label) {
        this.link = link;
        this.type = type;
        this.name = name;
        this.label = label;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
