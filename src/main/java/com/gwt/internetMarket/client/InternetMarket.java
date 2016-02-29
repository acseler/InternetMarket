package com.gwt.internetMarket.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.gwt.internetMarket.client.service.IGoodService;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;
import com.gwt.internetMarket.client.view.GoodCellRenderer;
import com.gwt.internetMarket.shared.GoodDao;

import java.util.Arrays;
import java.util.List;


/**
 * Created by boduill on 20.02.16.
 */
public class InternetMarket implements EntryPoint {

    public void onModuleLoad() {
        IGoodServiceAsync rpc = GWT.create(IGoodService.class);
        HandlerManager eventBus = new HandlerManager(null);
        AppController appViewer = new AppController(eventBus, rpc);
        appViewer.go(RootPanel.get("gwtContainer"));

//        final CellList<GoodDao> cellList = new CellList<GoodDao>(new GoodCellRenderer());
//        IGoodServiceAsync rpc = GWT.create(IGoodService.class);
//        rpc.getGoodsByCategory("Smartphone", new AsyncCallback<List<GoodDao>>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                Window.alert(caught.getMessage());
//            }
//
//            @Override
//            public void onSuccess(List<GoodDao> result) {
//                cellList.setRowData(0, result);
//            }
//        });
//        RootPanel.get("gwtContainer").add(cellList);
    }
}
