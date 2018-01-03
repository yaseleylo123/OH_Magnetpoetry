package org.openhab.binding.magnetpoetry.elements.category;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openhab.binding.magnetpoetry.elements.MagnetpoetryElement;
import org.openhab.binding.magnetpoetry.elements.magnet.MpMagnet;

public class MpCategory implements MagnetpoetryElement {

    private MpCategoryElement name;
    private UUID uuid;
    private List<MpMagnet> magnets = null;

    public MpCategory(MpCategoryElement categoryname) {
        this.name = categoryname;
        this.magnets = new ArrayList<MpMagnet>();
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    public MpCategoryElement getName() {
        return this.name;
    }

    public void setName(MpCategoryElement name) {
        this.name = name;
    }

    public void addMagnet(MpMagnet magnet) {
        this.magnets.add(magnet);
    }

    public void removeMagnet(MpMagnet magnet) {
        magnets.remove(magnet);
    }

    public List<MpMagnet> getMagnets() {
        return this.magnets;
    }

}
