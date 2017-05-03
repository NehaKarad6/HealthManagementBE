package com.example.abhms.healthmanagement;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by neha on 8/2/17.
 */

public class Q {

    private static RequestQueue queue;

    private Q() {
        // no object creation
    }

    public static RequestQueue q(Context context) {
        if (queue == null) queue = Volley.newRequestQueue(context);
        return queue;
    }
}