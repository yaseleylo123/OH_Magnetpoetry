/**
 * Copyright (c) 2014,2017 by the respective copyright holders.
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.magnetpoetry.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.openhab.binding.magnetpoetry.MagnetpoetryBindingConstants;
import org.openhab.binding.magnetpoetry.elements.category.MpCategoryElement;
import org.openhab.binding.magnetpoetry.elements.magnet.MpMagnet;
import org.openhab.binding.magnetpoetry.provider.MagnetpoetryProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link MagnetpoetryHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Yasemin Dogan - Initial contribution
 */
@NonNullByDefault
public class MagnetpoetryHandler extends BaseThingHandler {

    private final Logger logger = LoggerFactory.getLogger(MagnetpoetryHandler.class);

    private MagnetpoetryProviderImpl magnetpoetryProvider = new MagnetpoetryProviderImpl();

    private HashMap<String, String> semNumberIdentifierMap = new HashMap<String, String>();

    public MagnetpoetryHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(MagnetpoetryBindingConstants.ADD_CHANNEL)) {
            String[] split = command.toString().split("#");
            this.magnetpoetryProvider.addMagnet(split[0], MpCategoryElement.valueOf(split[1]), split[2]);

            // TODO: handle command
        }
        if (channelUID.getId().equals(MagnetpoetryBindingConstants.REMOVE_CHANNEL)) {

        }
        if (channelUID.getId().equals(MagnetpoetryBindingConstants.MAGNETCHOICE_CHANNEL)) {
            String[] split = command.toString().split("#");
            this.magnetpoetryProvider.evaluate(split);
            // TODO: then update semanticnumber channel
            // ############# TEST ################
            this.semNumberIdentifierMap.put("1", "Test statement 1 with Identifier SE_21_11");
        }
        if (channelUID.getId().equals(MagnetpoetryBindingConstants.SEMANTICCHOICE_CHANNEL)) {
            // TODO: send semantic number via rest .. now trigger is for other bundle
            int semanticnumber = Integer.parseInt(command.toString());
            updateState(getThing().getChannel(MagnetpoetryBindingConstants.SEMANTICCHOICE_CHANNEL).getUID(),
                    getIdentifierOfNr(semanticnumber));

        }
    }

    private State getIdentifierOfNr(int semanticnumber) {
        // TODO
        String state = null;
        for (Entry<String, String> map : semNumberIdentifierMap.entrySet()) {
            int nr = Integer.parseInt(map.getKey());
            if (nr == semanticnumber) {
                // sending to an other osgi bundle via rest ?
                this.magnetpoetryProvider.sendSemanticToRule(semanticnumber);

            }
        }
        return new StringType(state);
    }

    private State parseCategoryData(List<MpMagnet> magnets) {
        StringBuilder stringbuilder = new StringBuilder();
        for (MpMagnet magnet : magnets) {
            stringbuilder.append(magnet.getName());
            stringbuilder.append("#");
        }
        String stringState = stringbuilder.toString();
        return new StringType(stringState);
    }

    @Override
    public void initialize() {
        magnetpoetryProvider.init();
        List<MpMagnet> whatMagnets = magnetpoetryProvider
                .getMagnetsOfCategoryElement(MpCategoryElement.valueOf("WHAT"));
        List<MpMagnet> whoMagnets = magnetpoetryProvider.getMagnetsOfCategoryElement(MpCategoryElement.valueOf("WHO"));
        List<MpMagnet> whereMagnets = magnetpoetryProvider
                .getMagnetsOfCategoryElement(MpCategoryElement.valueOf("WHERE"));
        List<MpMagnet> whenMagnets = magnetpoetryProvider
                .getMagnetsOfCategoryElement(MpCategoryElement.valueOf("WHEN"));
        List<MpMagnet> generalMagnets = magnetpoetryProvider
                .getMagnetsOfCategoryElement(MpCategoryElement.valueOf("GENERAL"));
        Channel whatChannel = getThing().getChannel(MagnetpoetryBindingConstants.WHAT_CHANNEL);
        Channel whoChannel = getThing().getChannel(MagnetpoetryBindingConstants.WHO_CHANNEL);
        Channel whereChannel = getThing().getChannel(MagnetpoetryBindingConstants.WHERE_CHANNEL);
        Channel whenChannel = getThing().getChannel(MagnetpoetryBindingConstants.WHEN_CHANNEL);
        Channel generalChannel = getThing().getChannel(MagnetpoetryBindingConstants.GENERAL_CHANNEL);
        updateState(whatChannel.getUID(), parseCategoryData(whatMagnets));
        updateState(whoChannel.getUID(), parseCategoryData(whoMagnets));
        updateState(whereChannel.getUID(), parseCategoryData(whereMagnets));
        updateState(whenChannel.getUID(), parseCategoryData(whenMagnets));
        updateState(generalChannel.getUID(), parseCategoryData(generalMagnets));

        // TODO: Initialize the thing. If done set status to ONLINE to indicate proper working.
        // Long running initialization should be done asynchronously in background.
        updateStatus(ThingStatus.ONLINE);

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work
        // as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");
    }
}
