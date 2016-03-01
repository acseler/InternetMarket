package com.gwt.internetMarket.client.presenters;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.gwt.internetMarket.client.events.*;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boduill on 25.02.16.
 */
public class WelcomePagePresenter implements Presenter {

    public interface Display {
        AbstractHasData<GoodDao> getCellListGoods();
        AbstractHasData<ManufactureDao> getCellListManufacture();
        Image getGoodImage();
        HasClickHandlers getSearchButton();
        HasText getGoodNameLabel();
        HasText getGoodPriceLabel();
        HasText getGoodDescriptionLabel();
        HasValue<String> getSearchField();
        HasVisibility getThereAreNoGoods();
        HasVisibility getGoodViewPanel();
        HasVisibility getGoodsViewPanel();
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
        init();
    }

    public void bind() {
        eventBus.addHandler(CategoryTreeNodeSelectEvent.TYPE, new CategoryTreeNodeSelectEventHandler() {
            @Override
            public void onTreeNodeSelect(CategoryTreeNodeSelectEvent event) {
                setGoodByCategory(event.getCategory());
            }
        });
        eventBus.addHandler(ManufactureListSelectEvent.TYPE, new ManufactureListSelectEventHandler() {
            @Override
            public void onListSelect(ManufactureListSelectEvent event) {
                setGoodByManufacture(event.getMaufacture());
            }
        });
        this.display.getSearchButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                setGoodBySearch(display.getSearchField().getValue());
            }
        });
        eventBus.addHandler(GoodItemSelectEvent.TYPE, new GoodItemSelectItemEventHandler() {
            @Override
            public void onGoodItemSelect(GoodItemSelectEvent event) {
                History.newItem("good");
                setSingleGoodView(event.getGood());
            }
        });
    }

    private void setGoodByCategory(String category) {
        rpcService.getGoodsByCategory(category, new AsyncCallback<List<GoodDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<GoodDao> result) {
                if (result.isEmpty()) {
                    setEmptyViewOfGood();
                } else {
                    setGoodsIntoView(result);
                }
            }
        });
    }

    private void setGoodByManufacture(String manufacture) {
        rpcService.getGoodsByManufacture(manufacture, new AsyncCallback<List<GoodDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<GoodDao> result) {
                if (result.isEmpty()) {
                    setEmptyViewOfGood();
                } else {
                    setGoodsIntoView(result);
                }
            }
        });
    }

    private void setGoodBySearch(String searchValue) {
        rpcService.getGoodsByName(searchValue, new AsyncCallback<List<GoodDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<GoodDao> result) {
                if (result.isEmpty()) {
                    setEmptyViewOfGood();
                } else {
                    setGoodsIntoView(result);
                }
            }
        });
    }

    private void setSingleGoodView(GoodDao good) {
        display.getGoodsViewPanel().setVisible(false);
        display.getGoodViewPanel().setVisible(true);
        display.getGoodImage().setUrl("/img/" + good.getImage());
        display.getGoodNameLabel().setText(good.getName());
        display.getGoodPriceLabel().setText(String.valueOf(good.getPrice()));
        display.getGoodDescriptionLabel().setText(good.getDescriprion());
    }

    private void setGoodsIntoView(List<GoodDao> list) {
        display.getGoodViewPanel().setVisible(false);
        display.getThereAreNoGoods().setVisible(false);
        display.getGoodsViewPanel().setVisible(true);
        display.getCellListGoods().setRowCount(0);
        display.getCellListGoods().setRowData(0, list);
        display.cellListRedraw();
    }

    private void setEmptyViewOfGood () {
        display.getGoodViewPanel().setVisible(false);
        display.getThereAreNoGoods().setVisible(true);
        display.getCellListGoods().setRowCount(0);
        display.cellListRedraw();
    }

    private void init() {
        rpcService.getManufactures(new AsyncCallback<List<ManufactureDao>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<ManufactureDao> result) {
                display.getCellListManufacture().setRowData(0, result);
            }
        });
    }
}
