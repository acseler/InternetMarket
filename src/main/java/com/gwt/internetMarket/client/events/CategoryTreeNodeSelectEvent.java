package com.gwt.internetMarket.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by boduill on 28.02.16.
 */
public class CategoryTreeNodeSelectEvent extends GwtEvent<CategoryTreeNodeSelectEventHandler> {
    public static Type<CategoryTreeNodeSelectEventHandler> TYPE = new Type<CategoryTreeNodeSelectEventHandler>();
    private final String category;

    public CategoryTreeNodeSelectEvent(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public Type<CategoryTreeNodeSelectEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CategoryTreeNodeSelectEventHandler handler) {
        handler.onTreeNodeSelect(this);
    }
}
