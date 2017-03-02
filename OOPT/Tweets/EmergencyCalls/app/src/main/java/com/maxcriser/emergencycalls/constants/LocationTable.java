package com.maxcriser.emergencycalls.constants;

import com.maxcriser.emergencycalls.model.Em;

import java.util.ArrayList;
import java.util.List;

public class LocationTable {

    public static final List<Em> em = new ArrayList<Em>() {

        {
            add(new Em("Fire Department", "Prevention of emergencies", "xxx"));
            add(new Em("Ambulance", "Providing emergency medical care", "yyy"));
            add(new Em("Police", "Protection of public order", "zzz"));
            add(new Em("SOS", "A single emergency number", "tel:+375291897995"));
        }
    };

}
