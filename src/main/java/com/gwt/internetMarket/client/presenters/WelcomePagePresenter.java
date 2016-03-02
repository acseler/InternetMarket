package com.gwt.internetMarket.client.presenters;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.gwt.internetMarket.client.events.*;
import com.gwt.internetMarket.client.service.IGoodServiceAsync;
import com.gwt.internetMarket.client.view.TreeModel.CategoryTreeModel;
import com.gwt.internetMarket.shared.Category;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;

import javax.lang.model.element.ElementVisitor;
import java.util.List;

/**
 * Created by boduill on 25.02.16.
 */
public class WelcomePagePresenter implements Presenter {

    public interface Display {
        TreeNode getRootTreeNode();
        TreeViewModel getTreeViewModel();
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

    public interface HelpTree {
        SingleSelectionModel<Category> getSingleSelectionModelCategory();
        SingleSelectionModel<String> getSingleSelectionModelItem();
        List<Category> getCategoryList();
    }

    private final IGoodServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;
    private final CategoryTreeModel categoryTree;

    public WelcomePagePresenter(IGoodServiceAsync rpcService, HandlerManager eventBus, Display display) {
        this.rpcService = rpcService;
        this.eventBus = eventBus;
        this.display = display;
        this.categoryTree = (CategoryTreeModel) display.getTreeViewModel();
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
        eventBus.addHandler(GoodItemSelectEvent.TYPE, new GoodItemSelectItemEventHandler() {
            @Override
            public void onGoodItemSelect(GoodItemSelectEvent event) {
                History.newItem("good");
                setSingleGoodView(event.getGood());
            }
        });
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String token = event.getValue();
                if (token.equals("good")) {
                    display.getGoodsViewPanel().setVisible(false);
                    display.getGoodViewPanel().setVisible(true);
                } else if (token.equals("welcome")) {
                    display.getGoodsViewPanel().setVisible(true);
                    display.getGoodViewPanel().setVisible(false);
                }
            }
        });
        this.display.getSearchButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!display.getSearchField().getValue().isEmpty()){
                    setGoodBySearch(display.getSearchField().getValue());
                }
            }
        });

        this.categoryTree.getSingleSelectionModelCategory().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                List<Category> catList = categoryTree.getCategoryList();
                for (int i = 0; i < categoryTree.getCategoryList().size(); i++) {
                    if (categoryTree.getSingleSelectionModelCategory().isSelected(catList.get(i))) {
                        display.getRootTreeNode().setChildOpen(i, true);
                    } else if (false) {

                    } else {
                        display.getRootTreeNode().setChildOpen(i, false);
                    }
                }
            }
        });

        this.categoryTree.getSingleSelectionModelItem().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                eventBus.fireEvent(new CategoryTreeNodeSelectEvent(categoryTree.getSingleSelectionModelItem().getSelectedObject()));
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
                if ("good".equals(History.getToken())) {
                    History.newItem("welcome");
                }
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
                if ("good".equals(History.getToken())) {
                    History.newItem("welcome");
                }
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
                if ("good".equals(History.getToken())) {
                    History.newItem("welcome");
                }
                display.getSearchField().setValue("");
                if (result.isEmpty()) {
                    setEmptyViewOfGood();
                } else {
                    setGoodsIntoView(result);
                }
            }
        });
    }

    private void setSingleGoodView(GoodDao good) {
        display.getGoodImage().setUrl("/img/" + good.getImage());
        display.getGoodNameLabel().setText(good.getName());
        display.getGoodPriceLabel().setText(String.valueOf(good.getPrice()));
        display.getGoodDescriptionLabel().setText(good.getDescriprion());
    }

    private void setGoodsIntoView(List<GoodDao> list) {
        display.getThereAreNoGoods().setVisible(false);
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
