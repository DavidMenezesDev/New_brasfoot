/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.d;
import best.ah;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class g
implements TreeSelectionListener {
    final /* synthetic */ d ux;

    g(d d2) {
        this.ux = d2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)d.c(this.ux).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof ah) {
            ah ah2 = (ah)object;
            this.ux.F(ah2);
        }
    }
}

