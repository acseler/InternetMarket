package com.gwt.internetMarket.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.AbstractHasData;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.TreeViewModel;
import com.gwt.internetMarket.client.view.TreeModel.CategoryTreeModel;
import com.gwt.internetMarket.client.presenters.WelcomePagePresenter;
import com.gwt.internetMarket.client.view.renderers.GoodCellRenderer;
import com.gwt.internetMarket.client.view.renderers.ManufactureCellRenderer;
import com.gwt.internetMarket.client.view.treeResources.CategoryTreeResources;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;

/**
 * Created by boduill on 28.02.16.
 */
public class WelcomePageView extends Composite implements WelcomePagePresenter.Display {

    interface WelcomePageViewUiBinder extends UiBinder<HTMLPanel, WelcomePageView> {
    }

    private static WelcomePageViewUiBinder ourUiBinder = GWT.create(WelcomePageViewUiBinder.class);

    @UiField(provided = true)
    CellTree tree;

    @UiField(provided = true)
    CellList<GoodDao> goodList;

    @UiField(provided = true)
    CellList<ManufactureDao> manufactureDaoCellList;

    @UiField
    TextBox search;

    @UiField
    Button searchButton;

    @UiField
    Label thereAreNoGoods;

    @UiField
    Image goodImage;

    @UiField
    Label goodNameLabel;

    @UiField
    Label goodPriceLabel;

    @UiField
    Label goodDescriptionLable;

    @UiField
    HTMLPanel goodViewPanel;

    @UiField
    VerticalPanel goodsViewPanel;


    public WelcomePageView(final GoodCellRenderer renderer, final CategoryTreeModel categoryTreeModel, ManufactureCellRenderer manufactureCellRenderer) {
        final CategoryTreeResources treeResources = GWT.create(CategoryTreeResources.class);
        this.tree = new CellTree(categoryTreeModel, null, treeResources);
        this.tree.setAnimationEnabled(true);
        this.goodList = new CellList<GoodDao>(renderer);
        this.manufactureDaoCellList = new CellList<ManufactureDao>(manufactureCellRenderer);
        initWidget(ourUiBinder.createAndBindUi(this));

    }

    @Override
    public TreeNode getRootTreeNode() {
        return tree.getRootTreeNode();
    }

    @Override
    public TreeViewModel getTreeViewModel() {
        return tree.getTreeViewModel();
    }

    @Override
    public AbstractHasData<GoodDao> getCellListGoods() {
        return goodList;
    }

    @Override
    public AbstractHasData<ManufactureDao> getCellListManufacture() {
        return manufactureDaoCellList;
    }

    @Override
    public Image getGoodImage() {
        return goodImage;
    }

    @Override
    public HasValue<String> getSearchField() {
        return search;
    }

    @Override
    public HasVisibility getThereAreNoGoods() {
        return thereAreNoGoods;
    }

    @Override
    public HasVisibility getGoodViewPanel() {
        return goodViewPanel;
    }

    @Override
    public HasVisibility getGoodsViewPanel() {
        return goodsViewPanel;
    }

    @Override
    public HasClickHandlers getSearchButton() {
        return searchButton;
    }

    @Override
    public HasText getGoodNameLabel() {
        return goodNameLabel;
    }

    @Override
    public HasText getGoodPriceLabel() {
        return goodPriceLabel;
    }

    @Override
    public HasText getGoodDescriptionLabel() {
        return goodDescriptionLable;
    }

    @Override
    public void cellListRedraw() {
        goodList.redraw();
    }


}