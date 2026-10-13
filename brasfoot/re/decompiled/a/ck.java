/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ce;
import best.F;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class ck
implements TreeSelectionListener {
    final /* synthetic */ ce BW;

    ck(ce ce2) {
        this.BW = ce2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)ce.f(this.BW).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof F) {
            F f2 = (F)object;
            ce.a(this.BW, f2);
        }
    }
}

