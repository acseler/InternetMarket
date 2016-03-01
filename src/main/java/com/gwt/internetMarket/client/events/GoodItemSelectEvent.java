package com.gwt.internetMarket.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.gwt.internetMarket.shared.GoodDao;

/**
 * Created by boduill on 01.03.16.
 */
public class GoodItemSelectEvent extends GwtEvent<GoodItemSelectItemEventHandler> {
    public static Type<GoodItemSelectItemEventHandler> TYPE = new Type<GoodItemSelectItemEventHandler>();

    private final GoodDao good;

    public GoodItemSelectEvent(GoodDao good) {
        this.good = good;
    }

    public GoodDao getGood() {
        return good;
    }

    @Override
    public Type<GoodItemSelectItemEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GoodItemSelectItemEventHandler handler) {
        handler.onGoodItemSelect(this);
    }
}
