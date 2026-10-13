/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.aq;
import c.a;
import components.ao;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLayeredPane;

public class M
extends JLayeredPane {
    private ArrayList Qp = new ArrayList();

    public M(ArrayList arrayList) {
        this.Qp = arrayList;
    }

    @Override
    public String getToolTipText(MouseEvent mouseEvent) {
        int n2;
        Point point = new Point(mouseEvent.getX(), mouseEvent.getY());
        if (ao.W(mouseEvent.getX(), mouseEvent.getY()) && (n2 = ao.T(mouseEvent.getX(), mouseEvent.getY())) >= 1 && ((ao)this.Qp.get(n2)).x() != null) {
            String string = "";
            if (n2 <= 25 && aq.sE[n2][0] != ((ao)this.Qp.get(n2)).x().getPosicao()) {
                string = "Improvisado como " + aq.rH[aq.sE[n2][0]];
            }
            if (!a.SR.isHabilidadeIndividual()) {
                return "<html>" + ((ao)this.Qp.get(n2)).x().getNome() + " (F:" + Integer.toString(((ao)this.Qp.get(n2)).x().fi()) + " E:" + Integer.toString(((ao)this.Qp.get(n2)).x().fp()) + ")" + "<br><b>Posic\u00e3o original:</b> " + aq.rH[((ao)this.Qp.get(n2)).x().getPosicao()] + "<br><b>Lado original:</b> " + aq.rK[((ao)this.Qp.get(n2)).x().getLado()] + "<br><b>Idade:</b> " + Integer.toString(((ao)this.Qp.get(n2)).x().getIdade()) + "<br><b>Caract:</b> " + aq.qN[((ao)this.Qp.get(n2)).x().getCr1()] + "/" + aq.qN[((ao)this.Qp.get(n2)).x().getCr2()] + "<br>" + string + "</html>";
            }
            return "<html>" + ((ao)this.Qp.get(n2)).x().getNome() + " (E:" + Integer.toString(((ao)this.Qp.get(n2)).x().fp()) + ")" + "<br><b>Posic\u00e3o original:</b> " + aq.rH[((ao)this.Qp.get(n2)).x().getPosicao()] + "<br><b>Lado original:</b> " + aq.rK[((ao)this.Qp.get(n2)).x().getLado()] + "<br><b>Idade:</b> " + Integer.toString(((ao)this.Qp.get(n2)).x().getIdade()) + "<br><b>Caract:</b> " + aq.qN[((ao)this.Qp.get(n2)).x().getCr1()] + "/" + aq.qN[((ao)this.Qp.get(n2)).x().getCr2()] + "<br><b>Gol: " + Integer.toString(((ao)this.Qp.get(n2)).x().gK()) + "<br><b>Des: " + Integer.toString(((ao)this.Qp.get(n2)).x().gN()) + "<br><b>Arm: " + Integer.toString(((ao)this.Qp.get(n2)).x().gO()) + "<br><b>Fin: " + Integer.toString(((ao)this.Qp.get(n2)).x().gP()) + "<br><b>Vel: " + Integer.toString(((ao)this.Qp.get(n2)).x().gJ()) + "<br><b>Tec: " + Integer.toString(((ao)this.Qp.get(n2)).x().gL()) + "<br><b>Pas: " + Integer.toString(((ao)this.Qp.get(n2)).x().gM()) + "<br>" + string + "</html>";
        }
        return super.getToolTipText(mouseEvent);
    }

    public void aa(ArrayList arrayList) {
        this.Qp = arrayList;
    }
}

