package com.maxcriser.tweets_android.manager;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class TweetFileManager {

    public static void Save(final File file, final String[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                for (int i = 0; i < data.length; i++) {
                    fos.write(data[i].getBytes());
                    if (i < data.length - 1) {
                        fos.write("\n".getBytes());
                    }
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                fos.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] Load(final File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fis != null;
        final InputStreamReader isr = new InputStreamReader(fis);
        final BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl = 0;
        try {
            while ((test = br.readLine()) != null) {
                anzahl++;
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

        try {
            fis.getChannel().position(0);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final String[] array = new String[anzahl];

        String line;
        int i = 0;
        try {
            while ((line = br.readLine()) != null) {
                array[i] = line;
                i++;
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}