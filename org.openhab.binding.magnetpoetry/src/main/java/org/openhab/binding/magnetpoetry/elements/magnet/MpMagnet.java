package org.openhab.binding.magnetpoetry.elements.magnet;

import java.util.UUID;

import org.openhab.binding.magnetpoetry.elements.MagnetpoetryElement;
import org.openhab.binding.magnetpoetry.elements.semantic.MpSemanticSimple;

public class MpMagnet implements MagnetpoetryElement {

    private String name;
    private UUID uuid;

    private MpSemanticSimple semantic;

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

    public void setSemantic(MpSemanticSimple semantic) {
        this.semantic = semantic;
    }

    public MpSemanticSimple getSemantic() {
        return this.semantic;
    }

}
