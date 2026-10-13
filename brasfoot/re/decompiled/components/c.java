/*
 * Decompiled with CFR 0.152.
 */
package components;

import b.ah;
import b.m;
import components.e;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class c
extends JPanel {
    private ArrayList vS = new ArrayList();
    private static BufferedImage DH = null;
    private JScrollPane ut;
    private JTable wp;

    public c(ArrayList arrayList) {
        this.vS = arrayList;
        this.mJ();
        this.nc();
    }

    private void nc() {
        m m2 = new m(this.vS);
        this.wp.setModel(m2);
        this.wp.setTableHeader(null);
        int[] nArray = new int[]{20, 20, 120, 20, 20, 20, 20, 20, 20, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.wp.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.wp.setRowHeight(18);
        this.wp.setShowGrid(false);
        this.wp.setDefaultRenderer(e.class, new ah());
        this.wp.setAutoCreateRowSorter(false);
        this.wp.setIntercellSpacing(new Dimension(1, 1));
        this.wp.setCellSelectionEnabled(false);
        this.wp.setSelectionMode(0);
        this.wp.setRowSelectionAllowed(true);
        this.wp.setSelectionBackground(Color.YELLOW);
        this.wp.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.wp = new JTable();
        this.wp.setBackground(Color.BLACK);
        this.ut.setViewportView(this.wp);
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ut, -1, 320, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ut, -1, 300, Short.MAX_VALUE));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        try {
            DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f01.jpg"));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        Dimension dimension = this.getSize();
        super.paintComponent(graphics);
        graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
    }
}

