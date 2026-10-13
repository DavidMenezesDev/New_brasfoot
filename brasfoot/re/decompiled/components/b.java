/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.a;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class b
implements LayoutManager2,
Serializable {
    static final long serialVersionUID = -1919857869177070440L;
    protected Hashtable NA = new Hashtable();

    @Override
    public void addLayoutComponent(String string, Component component) {
        throw new IllegalArgumentException();
    }

    @Override
    public void removeLayoutComponent(Component component) {
        this.NA.remove(component);
    }

    @Override
    public Dimension preferredLayoutSize(Container container) {
        int n2 = 0;
        int n3 = 0;
        Enumeration enumeration = this.NA.keys();
        while (enumeration.hasMoreElements()) {
            int n4;
            Component component = (Component)enumeration.nextElement();
            a a2 = (a)this.NA.get(component);
            Dimension dimension = component.getPreferredSize();
            int n5 = a2.getWidth();
            if (n5 == -1) {
                n5 = dimension.width;
            }
            if ((n4 = a2.getHeight()) == -1) {
                n4 = dimension.height;
            }
            if (a2.x + n5 > n2) {
                n2 = a2.x + n5;
            }
            if (a2.y + n4 <= n3) continue;
            n3 = a2.y + n4;
        }
        return new Dimension(n2, n3);
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        int n2 = 0;
        int n3 = 0;
        Enumeration enumeration = this.NA.keys();
        while (enumeration.hasMoreElements()) {
            int n4;
            Component component = (Component)enumeration.nextElement();
            a a2 = (a)this.NA.get(component);
            Dimension dimension = component.getMinimumSize();
            int n5 = a2.getWidth();
            if (n5 == -1) {
                n5 = dimension.width;
            }
            if ((n4 = a2.getHeight()) == -1) {
                n4 = dimension.height;
            }
            if (a2.x + n5 > n2) {
                n2 = a2.x + n5;
            }
            if (a2.y + n4 <= n3) continue;
            n3 = a2.y + n4;
        }
        return new Dimension(n2, n3);
    }

    @Override
    public void layoutContainer(Container container) {
        Enumeration enumeration = this.NA.keys();
        while (enumeration.hasMoreElements()) {
            int n2;
            Component component = (Component)enumeration.nextElement();
            a a2 = (a)this.NA.get(component);
            Dimension dimension = component.getPreferredSize();
            int n3 = a2.getWidth();
            if (n3 == -1) {
                n3 = dimension.width;
            }
            if ((n2 = a2.getHeight()) == -1) {
                n2 = dimension.height;
            }
            component.setBounds(a2.x, a2.y, n3, n2);
        }
    }

    @Override
    public void addLayoutComponent(Component component, Object object) {
        if (!(object instanceof a)) {
            throw new IllegalArgumentException();
        }
        this.NA.put(component, object);
    }

    @Override
    public Dimension maximumLayoutSize(Container container) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public float getLayoutAlignmentX(Container container) {
        return 0.0f;
    }

    @Override
    public float getLayoutAlignmentY(Container container) {
        return 0.0f;
    }

    @Override
    public void invalidateLayout(Container container) {
    }
}

