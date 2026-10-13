/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.Y;
import d.Z;
import d.aC;
import d.aa;
import d.ab;
import d.ay;
import d.e;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sun.java2d.SunGraphicsEnvironment;

public class X {
    public JFrame Vi;
    public JPanel xb;
    public JPanel Vj;
    public JPanel Vk;
    public JTable table;
    public JTable UQ;
    public TableModel Vl;
    Comparator UB = new Y(this);

    public void wT() {
        this.wU();
        this.wV();
    }

    private void wU() {
        this.Vi = new JFrame("Editor Brasfoot");
        this.Vi.setLayout(new BorderLayout());
        this.Vi.setDefaultCloseOperation(3);
    }

    private void wV() {
        this.xb = new JPanel();
        this.Vi.add(this.xb);
        Color color = Color.decode("#007700");
        this.xb.setBackground(color);
        this.wW();
        this.wX();
        this.wY();
        this.xb();
        this.wZ();
    }

    private void wW() {
        this.Vj = new JPanel();
        this.Vj.setLayout(new BoxLayout(this.Vj, 1));
        this.xb.add(this.Vj);
        Color color = Color.BLUE;
        this.Vj.setBackground(color);
    }

    private void wX() {
        this.Vk = new JPanel();
        this.xb.add(this.Vk);
        Color color = Color.RED;
        this.Vk.setBackground(color);
    }

    private void wY() {
        ay ay2 = new ay();
        this.table = new Z(this, ay2);
        this.table.setShowGrid(false);
        this.table.setDefaultRenderer(String.class, new e());
        this.table.setDefaultRenderer(Integer.class, new e());
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.table.getModel());
        tableRowSorter.setComparator(2, this.UB);
        this.table.setRowSorter(tableRowSorter);
        this.table.getModel().addTableModelListener(new aC());
        this.table.setSelectionMode(0);
        this.table.setOpaque(true);
        this.table.setRowSelectionAllowed(true);
        this.table.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane jScrollPane = new JScrollPane(this.table);
        this.Vj.add((Component)jScrollPane, 0);
    }

    private void wZ() {
        ay ay2 = new ay();
        this.UQ = new aa(this, ay2);
        this.UQ.setDefaultRenderer(String.class, new e());
        this.UQ.setDefaultRenderer(Integer.class, new e());
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.UQ.getModel());
        tableRowSorter.setComparator(2, this.UB);
        this.UQ.setRowSorter(tableRowSorter);
        this.UQ.getModel().addTableModelListener(new aC());
        this.UQ.setSelectionMode(0);
        this.UQ.setOpaque(true);
        this.UQ.setRowSelectionAllowed(true);
        this.UQ.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane jScrollPane = new JScrollPane(this.UQ);
        this.Vk.add(jScrollPane);
    }

    public void xa() {
        this.Vi.setUndecorated(true);
        this.Vi.pack();
        GraphicsConfiguration graphicsConfiguration = this.Vi.getGraphicsConfiguration();
        Rectangle rectangle = SunGraphicsEnvironment.getUsableBounds(graphicsConfiguration.getDevice());
        this.Vi.setMaximizedBounds(new Rectangle(0, 0, rectangle.width, rectangle.height));
        this.Vi.setExtendedState((this.Vi.getExtendedState() & 6) == 6 ? 0 : 6);
        this.Vi.setVisible(true);
    }

    public Component prepareRenderer(TableCellRenderer tableCellRenderer, int n2, int n3) {
        Component component = this.table.prepareRenderer(tableCellRenderer, n2, n3);
        Object object = this.table.getValueAt(n2, n3);
        if (object.toString().equals("Red")) {
            component.setBackground(Color.RED);
        } else if (n2 % 2 == 0 && !this.table.isCellSelected(n2, n3)) {
            component.setBackground(Color.YELLOW);
        } else {
            component.setBackground(this.table.getBackground());
        }
        return component;
    }

    private void xb() {
        JButton jButton = new JButton("Add/remove");
        jButton.addActionListener(new ab(this));
        this.Vj.add(jButton);
    }
}

