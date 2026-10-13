/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.h;
import best.ah;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class k
implements TreeSelectionListener {
    final /* synthetic */ h uy;

    k(h h3) {
        this.uy = h3;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)h.c(this.uy).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof ah) {
            ah ah2 = (ah)object;
            this.uy.F(ah2);
        }
    }
}

