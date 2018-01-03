package org.openhab.binding.magnetpoetry.elements.semantic;

import java.util.UUID;

import org.openhab.binding.magnetpoetry.elements.MagnetpoetryElement;

public class MpSemantic implements MagnetpoetryElement {

    private MpSemanticIdentifier identifier = null;
    private UUID uuid = null;
    private String statement = null;

    @Override
    public void setUUID(UUID uuid) {
        // TODO Auto-generated method stub

    }

    @Override
    public UUID getUUID() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setIdentifier(MpSemanticIdentifier identifier) {
        this.identifier = identifier;
    }

    public MpSemanticIdentifier getIdentifier() {
        return this.identifier;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return this.statement;
    }

}
