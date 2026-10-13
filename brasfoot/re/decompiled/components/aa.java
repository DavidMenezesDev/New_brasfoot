/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.RangeSliderUI;
import javax.swing.JSlider;

public class aa
extends JSlider {
    public aa() {
        this.uu();
    }

    public aa(int n2, int n3) {
        super(n2, n3);
        this.uu();
    }

    private void uu() {
        this.setOrientation(0);
    }

    @Override
    public void updateUI() {
        this.setUI(new RangeSliderUI(this));
        this.updateLabelUIs();
    }

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(int n2) {
        int n3 = this.getValue();
        if (n3 == n2) {
            return;
        }
        int n4 = this.getExtent();
        int n5 = Math.min(Math.max(this.getMinimum(), n2), n3 + n4);
        int n6 = n4 + n3 - n5;
        this.getModel().setRangeProperties(n5, n6, this.getMinimum(), this.getMaximum(), this.getValueIsAdjusting());
    }

    public int uv() {
        return this.getValue() + this.getExtent();
    }

    public void dP(int n2) {
        int n3 = this.getValue();
        int n4 = Math.min(Math.max(0, n2 - n3), this.getMaximum() - n3);
        this.setExtent(n4);
    }
}

