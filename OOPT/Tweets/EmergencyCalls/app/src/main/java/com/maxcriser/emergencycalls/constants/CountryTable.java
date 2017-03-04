package com.maxcriser.emergencycalls.constants;

import android.content.Context;

import com.maxcriser.emergencycalls.R;
import com.maxcriser.emergencycalls.model.CountryEm;
import com.maxcriser.emergencycalls.model.Em;

import java.util.ArrayList;
import java.util.List;

public final class CountryTable {

    public static List<CountryEm> getEm() {
        return em;
    }

    public static Context mContext;

    public CountryTable(final Context pContext) {
        this.mContext = pContext;
    }

    public static final List<CountryEm> em = new ArrayList<CountryEm>() {

        {
            add(new CountryEm("Australia", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Азербайджан", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Армения", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Афганистан", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 119
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 102
                }
            }));

            add(new CountryEm("Беларусь", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 911
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Болгария", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 160
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 166
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 150
                }
            }));

            add(new CountryEm("Босния и Герцеговина", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 911
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 123
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 122
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 124
                }
            }));

            add(new CountryEm("Венгрия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 105
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 107
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 104
                }
            }));

            add(new CountryEm("Германия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Грузия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 111
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 121
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 113
                }
            }));

            add(new CountryEm("Евросоюз", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Израиль", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 100
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 101
                }
            }));

            add(new CountryEm("Иран", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 125
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 115
                }
            }));

            add(new CountryEm("Казахстан", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Канада", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("США", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Киргизия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("КНР", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 120
                }
            }));

            add(new CountryEm("КНДР", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Корея", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 119
                }
            }));

            add(new CountryEm("Латвия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 113
                }
            }));

            add(new CountryEm("Литва", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // х
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // х
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // х
                }
            }));

            add(new CountryEm("Македония", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); //  193
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                }
            }));

            add(new CountryEm("Молдавия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 901
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 902
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 903
                }
            }));

            add(new CountryEm("Монголия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 100
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Польша", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 998
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 997
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 999
                }
            }));

            add(new CountryEm("Россия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Румыния", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 981
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 955
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 961
                }
            }));

            add(new CountryEm("Сербия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 193
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                }
            }));

            add(new CountryEm("Словакия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 150
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 158
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 155
                }
            }));

            add(new CountryEm("Словения", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 113
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Таджикистан", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 111
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Турция", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Узбекистан", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Украина", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                }
            }));

            add(new CountryEm("Финляндия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Хорватия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 193
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                }
            }));

            add(new CountryEm("Чехия", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 150
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 158
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 155
                }
            }));

            add(new CountryEm("Черногория", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 123
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 122
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 124
                }
            }));

            add(new CountryEm("Швейцария", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 118
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 117
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 144
                }
            }));

            add(new CountryEm("Эстония", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                }
            }));

            add(new CountryEm("Япония", new ArrayList<Em>() {

                {
                    add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                    add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                    add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 119
                }
            }));
        }
    };
}
