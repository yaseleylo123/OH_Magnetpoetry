package org.openhab.binding.magnetpoetry.provider;

import org.openhab.binding.magnetpoetry.elements.category.MpCategoryElement;
import org.openhab.binding.magnetpoetry.elements.magnet.MpMagnet;

public interface MagnetpoetryProvider {

    public void init();

    public void addMagnet(MpMagnet magnet, MpCategoryElement categoryname);

    public void removeMagnet(MpMagnet magnet, MpCategoryElement categoryname);

    public void evaluate(String[] words);
}
