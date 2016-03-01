package com.gwt.internetMarket.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.*;
import com.gwt.internetMarket.client.service.IGoodService;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;


/**
 * Created by boduill on 20.02.16.
 */
public class InternetMarket implements EntryPoint {

    public void onModuleLoad() {
        IGoodServiceAsync rpc = GWT.create(IGoodService.class);
        HandlerManager eventBus = new HandlerManager(null);
        AppController appViewer = new AppController(eventBus, rpc);
        appViewer.go(RootPanel.get("gwtContainer"));
    }

}
