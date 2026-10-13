/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.RangeSliderUI;
import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicSliderUI;

public class ac
extends BasicSliderUI.TrackListener {
    final /* synthetic */ RangeSliderUI Rd;

    public ac(RangeSliderUI rangeSliderUI) {
        this.Rd = rangeSliderUI;
        super(rangeSliderUI);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (!RangeSliderUI.c(this.Rd).isEnabled()) {
            return;
        }
        this.currentMouseX = mouseEvent.getX();
        this.currentMouseY = mouseEvent.getY();
        if (RangeSliderUI.c(this.Rd).isRequestFocusEnabled()) {
            RangeSliderUI.c(this.Rd).requestFocus();
        }
        boolean bl2 = false;
        boolean bl3 = false;
        if (RangeSliderUI.d(this.Rd) || RangeSliderUI.c(this.Rd).getMinimum() == RangeSliderUI.c(this.Rd).getValue()) {
            if (RangeSliderUI.e(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
                bl3 = true;
            } else if (RangeSliderUI.f(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
                bl2 = true;
            }
        } else if (RangeSliderUI.f(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
            bl2 = true;
        } else if (RangeSliderUI.e(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
            bl3 = true;
        }
        if (bl2) {
            switch (RangeSliderUI.c(this.Rd).getOrientation()) {
                case 1: {
                    this.offset = this.currentMouseY - RangeSliderUI.f((RangeSliderUI)this.Rd).y;
                    break;
                }
                case 0: {
                    this.offset = this.currentMouseX - RangeSliderUI.f((RangeSliderUI)this.Rd).x;
                }
            }
            RangeSliderUI.a(this.Rd, false);
            RangeSliderUI.b(this.Rd, true);
            return;
        }
        RangeSliderUI.b(this.Rd, false);
        if (bl3) {
            switch (RangeSliderUI.c(this.Rd).getOrientation()) {
                case 1: {
                    this.offset = this.currentMouseY - RangeSliderUI.e((RangeSliderUI)this.Rd).y;
                    break;
                }
                case 0: {
                    this.offset = this.currentMouseX - RangeSliderUI.e((RangeSliderUI)this.Rd).x;
                }
            }
            RangeSliderUI.a(this.Rd, true);
            RangeSliderUI.c(this.Rd, true);
            return;
        }
        RangeSliderUI.c(this.Rd, false);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        RangeSliderUI.b(this.Rd, false);
        RangeSliderUI.c(this.Rd, false);
        RangeSliderUI.c(this.Rd).setValueIsAdjusting(false);
        super.mouseReleased(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (!RangeSliderUI.c(this.Rd).isEnabled()) {
            return;
        }
        this.currentMouseX = mouseEvent.getX();
        this.currentMouseY = mouseEvent.getY();
        if (RangeSliderUI.a(this.Rd)) {
            RangeSliderUI.c(this.Rd).setValueIsAdjusting(true);
            this.uw();
        } else if (RangeSliderUI.b(this.Rd)) {
            RangeSliderUI.c(this.Rd).setValueIsAdjusting(true);
            this.ux();
        }
    }

    @Override
    public boolean shouldScroll(int n2) {
        return false;
    }

    private void uw() {
        int n2 = 0;
        switch (RangeSliderUI.c(this.Rd).getOrientation()) {
            case 1: {
                int n3 = RangeSliderUI.f((RangeSliderUI)this.Rd).height / 2;
                int n4 = this.currentMouseY - this.offset;
                int n5 = RangeSliderUI.g((RangeSliderUI)this.Rd).y;
                int n6 = RangeSliderUI.g((RangeSliderUI)this.Rd).y + (RangeSliderUI.g((RangeSliderUI)this.Rd).height - 1);
                int n7 = RangeSliderUI.a(this.Rd, RangeSliderUI.c(this.Rd).getValue() + RangeSliderUI.c(this.Rd).getExtent());
                if (RangeSliderUI.h(this.Rd)) {
                    n6 = n7;
                } else {
                    n5 = n7;
                }
                n4 = Math.max(n4, n5 - n3);
                n4 = Math.min(n4, n6 - n3);
                this.Rd.setThumbLocation(RangeSliderUI.f((RangeSliderUI)this.Rd).x, n4);
                n2 = n4 + n3;
                RangeSliderUI.c(this.Rd).setValue(this.Rd.valueForYPosition(n2));
                break;
            }
            case 0: {
                int n8 = RangeSliderUI.f((RangeSliderUI)this.Rd).width / 2;
                int n9 = this.currentMouseX - this.offset;
                int n10 = RangeSliderUI.g((RangeSliderUI)this.Rd).x;
                int n11 = RangeSliderUI.g((RangeSliderUI)this.Rd).x + (RangeSliderUI.g((RangeSliderUI)this.Rd).width - 1);
                int n12 = RangeSliderUI.b(this.Rd, RangeSliderUI.c(this.Rd).getValue() + RangeSliderUI.c(this.Rd).getExtent());
                if (RangeSliderUI.h(this.Rd)) {
                    n10 = n12;
                } else {
                    n11 = n12;
                }
                n9 = Math.max(n9, n10 - n8);
                n9 = Math.min(n9, n11 - n8);
                this.Rd.setThumbLocation(n9, RangeSliderUI.f((RangeSliderUI)this.Rd).y);
                n2 = n9 + n8;
                RangeSliderUI.c(this.Rd).setValue(this.Rd.valueForXPosition(n2));
                break;
            }
            default: {
                return;
            }
        }
    }

    private void ux() {
        int n2 = 0;
        switch (RangeSliderUI.c(this.Rd).getOrientation()) {
            case 1: {
                int n3 = RangeSliderUI.f((RangeSliderUI)this.Rd).height / 2;
                int n4 = this.currentMouseY - this.offset;
                int n5 = RangeSliderUI.g((RangeSliderUI)this.Rd).y;
                int n6 = RangeSliderUI.g((RangeSliderUI)this.Rd).y + (RangeSliderUI.g((RangeSliderUI)this.Rd).height - 1);
                int n7 = RangeSliderUI.a(this.Rd, RangeSliderUI.c(this.Rd).getValue());
                if (RangeSliderUI.h(this.Rd)) {
                    n5 = n7;
                } else {
                    n6 = n7;
                }
                n4 = Math.max(n4, n5 - n3);
                n4 = Math.min(n4, n6 - n3);
                RangeSliderUI.a(this.Rd, RangeSliderUI.f((RangeSliderUI)this.Rd).x, n4);
                n2 = n4 + n3;
                RangeSliderUI.c(this.Rd).setExtent(this.Rd.valueForYPosition(n2) - RangeSliderUI.c(this.Rd).getValue());
                break;
            }
            case 0: {
                int n8 = RangeSliderUI.f((RangeSliderUI)this.Rd).width / 2;
                int n9 = this.currentMouseX - this.offset;
                int n10 = RangeSliderUI.g((RangeSliderUI)this.Rd).x;
                int n11 = RangeSliderUI.g((RangeSliderUI)this.Rd).x + (RangeSliderUI.g((RangeSliderUI)this.Rd).width - 1);
                int n12 = RangeSliderUI.b(this.Rd, RangeSliderUI.c(this.Rd).getValue());
                if (RangeSliderUI.h(this.Rd)) {
                    n11 = n12;
                } else {
                    n10 = n12;
                }
                n9 = Math.max(n9, n10 - n8);
                n9 = Math.min(n9, n11 - n8);
                RangeSliderUI.a(this.Rd, n9, RangeSliderUI.f((RangeSliderUI)this.Rd).y);
                n2 = n9 + n8;
                RangeSliderUI.c(this.Rd).setExtent(this.Rd.valueForXPosition(n2) - RangeSliderUI.c(this.Rd).getValue());
                break;
            }
            default: {
                return;
            }
        }
    }
}

