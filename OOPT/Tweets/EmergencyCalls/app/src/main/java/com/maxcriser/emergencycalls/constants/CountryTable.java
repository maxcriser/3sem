package com.maxcriser.emergencycalls.constants;

import android.content.Context;

import com.maxcriser.emergencycalls.R;
import com.maxcriser.emergencycalls.model.CountryEm;
import com.maxcriser.emergencycalls.model.Em;

import java.util.ArrayList;
import java.util.List;

public final class CountryTable {

    // TODO: 07.03.2017 SET CORRECT COUNTRY NAME

    public List<CountryEm> getEm() {
        return new ArrayList<CountryEm>() {

            {
                add(new CountryEm("Australia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+Australia", "+Australia")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Azerbaijan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Armenia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Afghanistan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 119
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 102
                    }
                }));

                add(new CountryEm("Belarus", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+Belarus", "+Belarus")); // 911
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Bulgaria", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 160
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 166
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 150
                    }
                }));

                add(new CountryEm("Bosnia and Herzegovina", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 911
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 123
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 122
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 124
                    }
                }));

                add(new CountryEm("Hungary", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 105
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 107
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 104
                    }
                }));

                add(new CountryEm("Germany", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+Germany", "+Germany")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Georgia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 111
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 121
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 113
                    }
                }));

                add(new CountryEm("Israel", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 100
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 101
                    }
                }));

                    add(new CountryEm("Iran", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 125
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 115
                    }
                }));

                add(new CountryEm("Kazakhstan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Canada", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("United States", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Kyrgyzstan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("China", new ArrayList<Em>() { // КНР

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 120
                    }
                }));

                add(new CountryEm("China", new ArrayList<Em>() { // КНДР

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Korea", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 119
                    }
                }));

                add(new CountryEm("Latvia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 113
                    }
                }));

                add(new CountryEm("Lithuania", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // х
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // х
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // х
                    }
                }));

                add(new CountryEm("Macedonia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); //  193
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                    }
                }));

                add(new CountryEm("Moldova", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 901
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 902
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 903
                    }
                }));

                add(new CountryEm("Mongolia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 100
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Poland", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 998
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 997
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 999
                    }
                }));

                add(new CountryEm("Russia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Romania", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 981
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 955
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 961
                    }
                }));

                add(new CountryEm("Serbia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 193
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                    }
                }));

                add(new CountryEm("Slovakia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 150
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 158
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 155
                    }
                }));

                add(new CountryEm("Slovenia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 113
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Tajikistan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 111
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Turkey", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Uzbekistan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Ukraine", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 101
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 102
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 103
                    }
                }));

                add(new CountryEm("Finland", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Croatia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 193
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 192
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 194
                    }
                }));

                add(new CountryEm("Czech Republic", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 150
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 158
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 155
                    }
                }));

                add(new CountryEm("Montenegro", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 123
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 122
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 124
                    }
                }));

                add(new CountryEm("Switzerland", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 118
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 117
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 144
                    }
                }));

                add(new CountryEm("Estonia", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.sos), mContext.getString(R.string.a_single_number), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 112
                    }
                }));

                add(new CountryEm("Japan", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.fire_department), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 119
                        add(new Em(mContext.getString(R.string.police), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 110
                        add(new Em(mContext.getString(R.string.ambulance), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 119
                    }
                }));

                add(new CountryEm("Location not found", new ArrayList<Em>() {

                    {
                        add(new Em(mContext.getString(R.string.s911), mContext.getString(R.string.prev_of_emergencies), "+375298893673", "+375298893673")); // 911
                        add(new Em(mContext.getString(R.string.s112), mContext.getString(R.string.protection_of_public_order), "+375298893673", "+375298893673")); // 112
                        add(new Em(mContext.getString(R.string.s111), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 111
                        add(new Em(mContext.getString(R.string.s100), mContext.getString(R.string.prov_emergency_medical_care), "+375298893673", "+375298893673")); // 100
                    }
                }));
            }
        };
    }

    private final Context mContext;

    public CountryTable(final Context pContext) {
        this.mContext = pContext;

    }

}
