package com.gwt.internetMarket.client.presenters;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasRows;
import com.gwt.internetMarket.client.events.CategoryTreeNodeSelectEvent;
import com.gwt.internetMarket.client.events.CategoryTreeNodeSelectEventHandler;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;
import com.gwt.internetMarket.shared.GoodDao;

import java.util.List;

/**
 * Created by boduill on 25.02.16.
 */
public class WelcomePagePresenter implements Presenter {

    public interface Display {
        AbstractHasData getCellList();
        void cellListRedraw();
        Widget asWidget();
    }

    private final IGoodServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;

    public WelcomePagePresenter(IGoodServiceAsync rpcService, HandlerManager eventBus, Display display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        bind();
    }

    public void go(final HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
        initTree();
    }

    public void bind() {
        eventBus.addHandler(CategoryTreeNodeSelectEvent.TYPE, new CategoryTreeNodeSelectEventHandler() {
            @Override
            public void onTreeNodeSelect(CategoryTreeNodeSelectEvent event) {
                setGoodByCategory(event.getCategory());
            }
        });
    }

    private void setGoodByCategory(final String category) {
        rpcService.getGoodsByCategory(category, new AsyncCallback<List<GoodDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<GoodDao> result) {
                display.getCellList().setRowCount(0);
                display.getCellList().setRowData(0, result);
                display.cellListRedraw();
            }
        });
    }

    private void initTree() {
        rpcService.getGoodsByCategory("Smartphone", new AsyncCallback<List<GoodDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }
            @Override
            public void onSuccess(List<GoodDao> result) {
                display.getCellList().setRowData(0, result);
            }
        });
    }
}
