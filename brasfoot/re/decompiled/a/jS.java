/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jH;
import best.ah;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class jS
implements TreeSelectionListener {
    final /* synthetic */ jH afI;

    jS(jH jH2) {
        this.afI = jH2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)jH.g(this.afI).getLastSelectedPathComponent();
        if (defaultMutableTreeNode == null) {
            return;
        }
        Object object = defaultMutableTreeNode.getUserObject();
        if (defaultMutableTreeNode.isLeaf() && object instanceof ah) {
            ah ah2 = (ah)object;
            jH.a(this.afI, ah2);
        }
    }
}

