package com.gwt.internetMarket.client.view.treeResources;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;
import sun.reflect.generics.tree.Tree;

/**
 * Created by boduill on 29.02.16.
 */
public interface CategoryTreeResources extends CellTree.Resources {

    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal, flipRtl = true)
    @Source("cellTreeSelectedBackground.png")
    ImageResource cellTreeSelectedBackground();

    @Source(TreeStyle.DEFAULT_CSS)
    CellTree.Style cellTreeStyle();
}


