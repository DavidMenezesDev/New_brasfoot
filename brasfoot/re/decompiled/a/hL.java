/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hF;
import best.ah;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class hL
implements TreeSelectionListener {
    final /* synthetic */ hF Ma;

    hL(hF hF2) {
        this.Ma = hF2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)hF.e(this.Ma).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof ah) {
            ah ah2 = (ah)object;
            this.Ma.F(ah2);
        }
    }
}

