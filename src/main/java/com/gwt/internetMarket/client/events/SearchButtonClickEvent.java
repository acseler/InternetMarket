package com.gwt.internetMarket.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by boduill on 29.02.16.
 */
public class SearchButtonClickEvent extends GwtEvent<SearchButtonClickEventHandler> {

    public static  Type<SearchButtonClickEventHandler> TYPE = new Type<SearchButtonClickEventHandler>();
    private final String searchValue;

    public SearchButtonClickEvent(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchValue() {
        return searchValue;
    }

    @Override
    public Type<SearchButtonClickEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SearchButtonClickEventHandler handler) {
        handler.onSearchButtonClick(this);
    }
}
