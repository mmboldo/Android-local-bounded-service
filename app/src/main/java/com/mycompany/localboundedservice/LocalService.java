package com.mycompany.localboundedservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class LocalService extends Service {

    private final Random mGenerator = new Random();
    private final IBinder mBinder = new LocalBinder();

    public LocalService() {
    }

    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

    // this time, it is a bounded service, so we need to implement this onBind
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}