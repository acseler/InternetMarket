package com.gwt.internetMarket.client.view.renderers;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiRenderer;
import com.google.gwt.user.client.Window;
import com.gwt.internetMarket.client.events.ManufactureListSelectEvent;
import com.gwt.internetMarket.shared.ManufactureDao;

/**
 * Created by boduill on 29.02.16.
 */
public class ManufactureCellRenderer extends AbstractCell<ManufactureDao> {

    public interface Renderer extends UiRenderer {
        void render(SafeHtmlBuilder sb, String name);

        void onBrowserEvent(ManufactureCellRenderer o, NativeEvent e, Element p, ManufactureDao n);
    }

    private final Renderer uiRenderer = GWT.create(Renderer.class);
    private final HandlerManager eventBus;

    public ManufactureCellRenderer(HandlerManager eventBus) {
        super(BrowserEvents.CLICK);
        this.eventBus = eventBus;
    }

    public void onBrowserEvent(Cell.Context context, Element parent, ManufactureDao value,
                               NativeEvent event, ValueUpdater<ManufactureDao> valueUpdater) {
        super.onBrowserEvent(context, parent, value, event, valueUpdater);
            if ("click".equals(event.getType())) {
                EventTarget target = event.getEventTarget();
                if (parent.getFirstChildElement().isOrHasChild(Element.as(target))) {
                    eventBus.fireEvent(new ManufactureListSelectEvent(value.getName()));
                }
            }
    }


    @Override
    public void render(Context context, ManufactureDao value, SafeHtmlBuilder sb) {
        String name = value.getName();
        uiRenderer.render(sb, name);
    }
}