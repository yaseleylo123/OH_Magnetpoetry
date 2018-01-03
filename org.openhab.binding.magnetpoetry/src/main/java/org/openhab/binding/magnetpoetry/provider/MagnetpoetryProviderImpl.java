package org.openhab.binding.magnetpoetry.provider;

import java.util.ArrayList;
import java.util.List;

import org.openhab.binding.magnetpoetry.MagnetpoetryBindingConstants;
import org.openhab.binding.magnetpoetry.elements.category.MpCategory;
import org.openhab.binding.magnetpoetry.elements.category.MpCategoryElement;
import org.openhab.binding.magnetpoetry.elements.magnet.MpMagnet;
import org.openhab.binding.magnetpoetry.elements.semantic.MpSemanticIdentifier;
import org.openhab.binding.magnetpoetry.rest.MpItem;
import org.openhab.binding.magnetpoetry.rest.MpRest;
import org.openhab.binding.magnetpoetry.util.MagnetpoetryUtil;

public class MagnetpoetryProviderImpl implements MagnetpoetryProvider {

    private List<MpCategory> categories = null;
    private MpRest restProvider = new MpRest();

    @Override
    public void init() {
        createCategories();
        // Testing getItems
        List<MpItem> items = new MpRest().getItems();
        initializeMagnets(items);
    }

    public List<MpCategory> getCategories() {
        return this.categories;
    }

    public List<MpMagnet> getMagnetsOfCategoryElement(MpCategoryElement categoryelement) {
        for (MpCategory category : categories) {
            if (category.getName().equals(categoryelement)) {
                return category.getMagnets();
            }
        }
        return null;
    }

    @Override
    public void addMagnet(MpMagnet magnet, MpCategoryElement categoryname) {
        for (MpCategory category : categories) {
            if (category.getName().equals(categoryname)) {
                category.addMagnet(magnet);
            }
        }
    }

    @Override
    public void removeMagnet(MpMagnet magnet, MpCategoryElement categoryname) {
        for (MpCategory category : categories) {
            if (category.getName().equals(categoryname)) {
                category.removeMagnet(magnet);
            }
        }
    }

    @Override
    public void evaluate(List<MpMagnet> magnets) {
        // TODO Auto-generated method stub

    }

    private void createCategories() {
        this.categories = new ArrayList<MpCategory>();
        for (MpCategoryElement categoryname : MpCategoryElement.values()) {
            MpCategory category = new MpCategory(categoryname);
            categories.add(category);
        }
    }

    private void initializeMagnets(List<MpItem> items) {
        List<String> persons = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHO_PERSON_FILE);
        List<String> rooms = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHERE_ROOMS_FILE);
        List<String> locations = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHERE_LOCATIONS_FILE);
        List<String> devices = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHAT_DEVICES_FILE);
        for (MpItem item : items) {
            devices.add(item.getLabel());
        }
        List<String> devicevalues = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHAT_DEVICEVALUES_FILE);
        List<String> verbs = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHAT_VERBS_FILE);
        List<String> dates = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHEN_DATE_FILE);
        List<String> clocks = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHEN_CLOCK_FILE);
        List<String> rtas = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHEN_RTA_FILE);
        List<String> etas = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHEN_ETA_FILE);
        List<String> tps = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.WHEN_TP_FILE);
        List<String> ifs = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_IF_FILE);
        List<String> ors = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_OR_FILE);
        List<String> ands = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_AND_FILE);
        List<String> thens = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_THEN_FILE);
        List<String> numbers = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_NUMBERS_FILE);
        List<String> others = MagnetpoetryUtil.readFile(MagnetpoetryBindingConstants.GENERAL_OTHERS_FILE);

        createMagnets(persons, MpCategoryElement.WHO, MpSemanticIdentifier.SE_WHO_01);
        createMagnets(rooms, MpCategoryElement.WHERE, MpSemanticIdentifier.SE_WHERE_1);
        createMagnets(locations, MpCategoryElement.WHERE, MpSemanticIdentifier.SE_WHERE_2);
        createMagnets(devices, MpCategoryElement.WHAT, MpSemanticIdentifier.SE_WHAT_1);
        createMagnets(devicevalues, MpCategoryElement.WHAT, MpSemanticIdentifier.SE_WHAT_2);
        createMagnets(verbs, MpCategoryElement.WHAT, MpSemanticIdentifier.SE_WHAT_3);
        createMagnets(dates, MpCategoryElement.WHEN, MpSemanticIdentifier.SE_WHEN_1);
        createMagnets(clocks, MpCategoryElement.WHEN, MpSemanticIdentifier.SE_WHEN_2);
        createMagnets(rtas, MpCategoryElement.WHEN, MpSemanticIdentifier.SE_WHEN_3);
        createMagnets(etas, MpCategoryElement.WHEN, MpSemanticIdentifier.SE_WHEN_4);
        createMagnets(tps, MpCategoryElement.WHEN, MpSemanticIdentifier.SE_WHEN_5);
        createMagnets(ifs, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_1);
        createMagnets(thens, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_2);
        createMagnets(ands, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_3);
        createMagnets(ors, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_4);
        createMagnets(numbers, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_5);
        createMagnets(others, MpCategoryElement.GENERAL, MpSemanticIdentifier.SE_GENERAL_6);
    }

    private void createMagnets(List<String> data, MpCategoryElement categoryname,
            MpSemanticIdentifier semanticIdentifier) {

        for (MpCategory category : categories) {
            if (categoryname.equals(category.getName())) {
                for (String word : data) {
                    MpMagnet newMagnet = new MpMagnet(word);
                    int index = categories.indexOf(category);
                    categories.get(index).addMagnet(newMagnet);
                }
            }
        }
    }

}
