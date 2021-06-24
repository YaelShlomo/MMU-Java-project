package com.hit.client;

import com.hit.view.CacheUnitView;

import java.beans.PropertyChangeEvent;

public class CacheUnitClientObserver {
    private CacheUnitClient cacheUnitClient;
    private CacheUnitView cacheUnitView;

    public CacheUnitClientObserver() {
        this.cacheUnitClient = new CacheUnitClient();
    }

    public void propertyChange(PropertyChangeEvent event) {
        String response;
        response = this.cacheUnitClient.send((String) event.getNewValue());	//Receive Respond from the server
        this.cacheUnitView = (CacheUnitView) event.getSource();
        this.cacheUnitView.updateUIData(response);	//Send the Respond to CacheUnitView
    }
}
