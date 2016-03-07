package com.gwt.internetMarket.client.view.treeResources;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.cellview.client.CellTree;

/**
 * Created by boduill on 02.03.16.
 * Переопределение стилей дерева
 */
@CssResource.ImportedWithPrefix("gwt-CellTree")
public interface TreeStyle extends CellTree.Style {
    /**
     * The path to the default CSS styles used by this resource.
     */
    String DEFAULT_CSS = "cellTree.css";

    /**
     * Applied to the empty message.
     */
    String cellTreeEmptyMessage();

    /**
     * Applied to tree items.
     */
    String cellTreeItem();

    /**
     * Applied to open/close icon.
     */
    String cellTreeItemImage();

    /**
     * Applied to the wrapper around the image and value.
     */
    String cellTreeItemImageValue();

    /**
     * Applied to the value in an item.
     */
    String cellTreeItemValue();

    /**
     * Applied to the keyboard selected item.
     */
    String cellTreeKeyboardSelectedItem();

    /**
     * Applied to open tree items.
     */
    String cellTreeOpenItem();

    /**
     * Applied to selected tree items.
     */
    String cellTreeSelectedItem();

    /**
     * Applied to the show more button.
     */
    String cellTreeShowMoreButton();

    /**
     * Applied to top level items.
     */
    String cellTreeTopItem();

    /**
     * Applied to open/close icon at the top level.
     */
    String cellTreeTopItemImage();

    /**
     * Applied to the wrapper around the image and value of top level items.
     */
    String cellTreeTopItemImageValue();

    /**
     * Applied to the widget.
     */
    String cellTreeWidget();
}
