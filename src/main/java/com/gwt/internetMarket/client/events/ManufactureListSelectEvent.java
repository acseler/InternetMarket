package com.gwt.internetMarket.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by boduill on 29.02.16.
 */
public class ManufactureListSelectEvent extends GwtEvent<ManufactureListSelectEventHandler> {
    public static Type<ManufactureListSelectEventHandler> TYPE = new Type<ManufactureListSelectEventHandler>();

    private final String maufacture;

    public ManufactureListSelectEvent(String maufacture) {
        this.maufacture = maufacture;
    }

    public String getMaufacture() {
        return maufacture;
    }

    @Override
    public Type<ManufactureListSelectEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ManufactureListSelectEventHandler handler) {
        handler.onListSelect(this);
    }
}
