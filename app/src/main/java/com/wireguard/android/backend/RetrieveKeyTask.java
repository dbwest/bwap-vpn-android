/*
 * Copyright © 2019 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.backend;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RetrieveKeyTask extends AsyncTask <String, Void, String> {

//    private Exception exception;

    protected String doInBackground(String... nothing) {
        final Request request = new Request.Builder()
                .url("http://104.197.64.12:8000/user5.conf")
                .get()
                .addHeader("authorization", "Basic cnNhdG5laW9AYXJzdG5laW8uY29tOjEyMzRhcnN0")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "38ab92f6-fb4b-2b7b-7f41-47d883196f10")
                .build();

        String key;
        try (Response response = new OkHttpClient().newCall(request).execute()) {
            key = response.body().string();
            Log.i("ASDF", key);
        } catch (IOException e) {
            e.printStackTrace();
            key = "error";
        }

        return key;
    }
}
