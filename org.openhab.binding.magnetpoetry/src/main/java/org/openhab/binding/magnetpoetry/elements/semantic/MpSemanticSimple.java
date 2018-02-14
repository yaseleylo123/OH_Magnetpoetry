package org.openhab.binding.magnetpoetry.elements.semantic;

import java.util.UUID;

import org.openhab.binding.magnetpoetry.elements.MagnetpoetryElement;
import org.openhab.binding.magnetpoetry.util.MagnetpoetryUtil;

public class MpSemanticSimple implements MagnetpoetryElement {

    private MpSemanticIdentifier identifier = null;
    private UUID uuid = null;
    private String statement = null;

    public MpSemanticSimple(String word, MpSemanticIdentifier identifier) {
        this.identifier = identifier;
        String statementForIdentifier = MagnetpoetryUtil.getStatementByIdentifier(identifier.toString());
        this.statement = statementForIdentifier.replaceAll("{0}", word);
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
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
