package com.gwt.internetMarket.client.presenters.TreeModel;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.gwt.internetMarket.client.events.CategoryTreeNodeSelectEvent;
import com.gwt.internetMarket.shared.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by boduill on 27.02.16.
 */
public class CategoryTreeModel implements TreeViewModel {

    private List<Category> categories = new ArrayList<Category>();
    private final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();

    public CategoryTreeModel(List<Category> categories, final HandlerManager eventBus) {
        this.categories = categories;
        this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                eventBus.fireEvent(new CategoryTreeNodeSelectEvent(selectionModel.getSelectedObject()));
            }
        });
    }

    @Override
    public <T> NodeInfo<?> getNodeInfo(T value) {
        if (value == null) {
            ListDataProvider<Category> dataProvider = new ListDataProvider<Category>(categories);
            Cell<Category> cell = new AbstractCell<Category>() {
                @Override
                public void render(Context context, Category value, SafeHtmlBuilder sb) {
                    if (value != null) {
                        sb.appendEscaped(value.getName());
                    }
                }
            };
            return new DefaultNodeInfo<Category>(dataProvider, cell);
        } else if (value instanceof Category) {
            ListDataProvider<String> dataProvider = new ListDataProvider<String>(((Category) value).getSubCategories());
            return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
        }
        return null;
    }

    @Override
    public boolean isLeaf(Object value) {
        if (value instanceof String) {
            return true;
        }
        return false;
    }


}

