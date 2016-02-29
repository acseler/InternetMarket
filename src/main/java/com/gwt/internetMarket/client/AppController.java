package com.gwt.internetMarket.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.gwt.internetMarket.client.presenters.Presenter;
import com.gwt.internetMarket.client.presenters.TreeModel.CategoryTreeModel;
import com.gwt.internetMarket.client.presenters.WelcomePagePresenter;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;
import com.gwt.internetMarket.client.view.GoodCellRenderer;
import com.gwt.internetMarket.client.view.WelcomePageView;
import com.gwt.internetMarket.shared.Category;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class AppController implements Presenter, ValueChangeHandler<String> {
    private final HandlerManager eventBus;
    private final IGoodServiceAsync rpc;
    private HasWidgets container;

    public AppController(HandlerManager eventBus, IGoodServiceAsync rpc) {
        this.eventBus = eventBus;
        this.rpc = rpc;
        bind();
    }

    public void bind() {
        History.addValueChangeHandler(this);
    }

    public void go(HasWidgets container) {
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("welcome");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            if (token.equals("welcome")) {
                rpc.getCategories(new AsyncCallback<List<Category>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("@@@@@@RRRRRRRRRRRRRRRRR@@@@@@");
                    }

                    @Override
                    public void onSuccess(List<Category> result) {
                        new WelcomePagePresenter(rpc, eventBus, new WelcomePageView(new GoodCellRenderer(), new CategoryTreeModel(result, eventBus))).go(container);
                    }
                });
            }
        }
    }
}
