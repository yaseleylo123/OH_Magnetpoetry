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

import java.util.List;

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

    public MagnetpoetryHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(MagnetpoetryBindingConstants.ADD_CHANNEL)) {
            String[] split = command.toString().split("#");

            // TODO: handle command

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
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
        Channel whatChannel = getThing().getChannel(MagnetpoetryBindingConstants.WHAT_CHANNEL);
        updateState(whatChannel.getUID(), parseCategoryData(whatMagnets));

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
