package com.gwt.internetMarket.client.view;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.gwt.internetMarket.client.presenters.TreeModel.CategoryTreeModel;
import com.gwt.internetMarket.client.presenters.WelcomePagePresenter;
import com.gwt.internetMarket.shared.GoodDao;

import java.util.Arrays;

/**
 * Created by boduill on 28.02.16.
 */
public class WelcomePageView extends Composite implements WelcomePagePresenter.Display {

    @Override
    public AbstractHasData getCellList() {
        return goodList;
    }

    @Override
    public void cellListRedraw() {
        goodList.redraw();
    }

    interface WelcomePageViewUiBinder extends UiBinder<HTMLPanel, WelcomePageView> {
    }

    private static WelcomePageViewUiBinder ourUiBinder = GWT.create(WelcomePageViewUiBinder.class);

    @UiField(provided = true)
    CellTree tree;

    @UiField(provided = true)
    CellList<GoodDao> goodList;

    public WelcomePageView(final GoodCellRenderer renderer, final CategoryTreeModel categoryTreeModel) {
        CategoryTreeResources treeResources = GWT.create(CategoryTreeResources.class);
        tree = new CellTree(categoryTreeModel, null, treeResources);
        goodList = new CellList<GoodDao>(renderer);
        initWidget(ourUiBinder.createAndBindUi(this));
    }



}