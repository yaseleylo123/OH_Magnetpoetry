package org.openhab.binding.magnetpoetry.elements.magnet;

import java.util.UUID;

import org.openhab.binding.magnetpoetry.elements.MagnetpoetryElement;
import org.openhab.binding.magnetpoetry.elements.semantic.MpSemantic;

public class MpMagnet implements MagnetpoetryElement {

    private String name;
    private UUID uuid;

    private MpSemantic semantic;

    public MpMagnet(String name) {
        this.name = name;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemantic(MpSemantic semantic) {
        this.semantic = semantic;
    }

    public MpSemantic getSemantic() {
        return this.semantic;
    }

}
