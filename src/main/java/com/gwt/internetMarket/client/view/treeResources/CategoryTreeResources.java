package com.gwt.internetMarket.client.view.treeResources;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;

/**
 * Created by boduill on 29.02.16.
 */
public interface CategoryTreeResources extends CellTree.Resources {

    @Source("cellTreeClosedItem.gif")
    ImageResource cellTreeClosedItem();

    @Source("cellTreeOpenItem.gif")
    ImageResource cellTreeOpenItem();

    @Source("cellTree.css")
    CellTree.Style cellTreeStyle();
}
