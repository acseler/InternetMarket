package com.gwt.internetMarket.client.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiRenderer;
import com.gwt.internetMarket.shared.GoodDao;

/**
 * Created by boduill on 28.02.16.
 */
public class GoodCellRenderer extends AbstractCell<GoodDao> {

    public interface Renderer extends UiRenderer {
        void render(SafeHtmlBuilder sb, String name, String price, String description, String image);

        void onBrowserEvent(GoodCellRenderer o, NativeEvent e, Element p, GoodDao n);
    }

    private final Renderer uiRenderer = GWT.create(Renderer.class);

    public GoodCellRenderer() {
        super(BrowserEvents.CLICK);
    }

    @Override
    public void onBrowserEvent(Context context, Element parent, GoodDao value,
                               NativeEvent event, ValueUpdater<GoodDao> valueUpdater) {
        uiRenderer.onBrowserEvent(this, event, parent, value);
    }

    @Override
    public void render(Context context, GoodDao value, SafeHtmlBuilder sb) {
        String name = value.getName();
        String price = String.valueOf(value.getPrice());
        String description = value.getDescriprion();
        String image = value.getImage();

        uiRenderer.render(sb, name, price, description, image);
    }

}