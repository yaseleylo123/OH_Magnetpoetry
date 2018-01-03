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
package org.openhab.binding.magnetpoetry;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link MagnetpoetryBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Yasemin Dogan - Initial contribution
 */
@NonNullByDefault
public class MagnetpoetryBindingConstants {

    private static final String BINDING_ID = "magnetpoetry";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_SAMPLE = new ThingTypeUID(BINDING_ID, "sample");

    // List of all Channel ids
    public static final String CHANNEL_1 = "channel1";
    public static final String WHO_CHANNEL = "channelwho";
    public static final String WHERE_CHANNEL = "channelwhere";
    public static final String WHAT_CHANNEL = "channelwhat";
    public static final String WHEN_CHANNEL = "channelwhen";
    public static final String GENERAL_CHANNEL = "channelgeneral";
    public static final String MAGNETCHOICE_CHANNEL = "channelmagnetchoice";
    public static final String SEMANTIC_CHANNEL = "channelsemantic";
    public static final String SEMANTICCHOICE_CHANNEL = "channelsemanticchoice";
    public static final String ADD_CHANNEL = "channeladd";
    public static final String REMOVE_CHANNEL = "channelremove";

    // List all category related files
    public static final String WHO_PERSON_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/who/person.txt";
    public static final String WHERE_ROOMS_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/where/rooms.txt";
    public static final String WHERE_LOCATIONS_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/where/locations.txt";
    public static final String WHAT_DEVICES_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/what/devices.txt";
    public static final String WHAT_DEVICEVALUES_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/what/devicevalues.txt";
    public static final String WHAT_VERBS_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/what/verbs.txt";
    public static final String WHEN_DATE_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/when/date.txt";
    public static final String WHEN_CLOCK_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/when/clock.txt";
    public static final String WHEN_RTA_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/when/rta.txt";
    public static final String WHEN_ETA_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/when/eta.txt";
    public static final String WHEN_TP_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/when/tp.txt";
    public static final String GENERAL_IF_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/if.txt";
    public static final String GENERAL_OR_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/or.txt";
    public static final String GENERAL_AND_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/and.txt";
    public static final String GENERAL_THEN_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/then.txt";
    public static final String GENERAL_NUMBERS_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/numbers.txt";
    public static final String GENERAL_OTHERS_FILE = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/general/others.txt";

    // List semantic related files
    public static final String SEMANTIC_STATEMENT_PROPERTIES = "home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/semantic/semanticstatements.properties";
    public static final String SEMANTIC_INTERNAL_STATEMENT_PROPERTIES = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/semantic/semanticInternStatements.properties";
    public static final String SEMANTIC_COMPREHENSIVE_STATEMENT_PROPERTIES = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/semantic/semanticComprehensiveStatements.properties";
    public static final String SEMANTIC_COMPREHENSIVE_ELEMENTS_PROPERTIES = "/home/leylo/openhab2-master/git/openhab2-addons/addons/binding/org.openhab.binding.magnetpoetry/files/semantic/semanticComprehensiveElements.properties";

    // List OH Rest URIs
    public static final String REST_URI_ITEMS = "http://localhost:8080/rest/items";
}
