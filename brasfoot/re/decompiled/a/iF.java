/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.iA;
import best.ah;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class iF
implements TreeSelectionListener {
    final /* synthetic */ iA MV;

    iF(iA iA2) {
        this.MV = iA2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)iA.j(this.MV).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof ah) {
            ah ah2 = (ah)object;
            this.MV.F(ah2);
        }
    }
}

