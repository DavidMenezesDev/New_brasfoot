/*
 * Decompiled with CFR 0.152.
 */
package components;

import a.bz;
import best.aq;
import c.a;
import components.ao;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

public class K
extends JLayeredPane {
    @Override
    public String getToolTipText(MouseEvent mouseEvent) {
        Point point = new Point(mouseEvent.getX(), mouseEvent.getY());
        if (ao.V(mouseEvent.getX(), mouseEvent.getY())) {
            int n2 = ao.S(mouseEvent.getX(), mouseEvent.getY());
            if (n2 >= 1 && ((ao)bz.oa().get(n2)).x() != null) {
                String string = "";
                Double d2 = 0.0;
                if (n2 >= 0 && n2 < bz.oa().size()) {
                    d2 = ((ao)bz.oa().get(n2)).x().F();
                }
                String string2 = String.format("%.2f", d2);
                if (d2 < 2.0) {
                    string2 = "--";
                }
                if (n2 <= 25 && aq.sE[n2][0] != ((ao)bz.oa().get(n2)).x().getPosicao()) {
                    string = "Improvisado como " + aq.rH[aq.sE[n2][0]];
                }
                if (!a.SR.isHabilidadeIndividual()) {
                    return "<html>" + ((ao)bz.oa().get(n2)).x().getNome() + "(F:" + Integer.toString(((ao)bz.oa().get(n2)).x().fi()) + " E:" + Integer.toString(((ao)bz.oa().get(n2)).x().fp()) + ")" + "<br><b>Posic\u00e3o original:</b> " + aq.rH[((ao)bz.oa().get(n2)).x().getPosicao()] + "<br><b>Lado original:</b> " + aq.rK[((ao)bz.oa().get(n2)).x().getLado()] + "<br><b>Idade:</b> " + Integer.toString(((ao)bz.oa().get(n2)).x().getIdade()) + "<br><b>Caract:</b> " + aq.qN[((ao)bz.oa().get(n2)).x().getCr1()] + "/" + aq.qN[((ao)bz.oa().get(n2)).x().getCr2()] + "<br><b>Nota m\u00e9dia</b>: " + string2 + "<br>" + string + "</html>";
                }
                return "<html>" + ((ao)bz.oa().get(n2)).x().getNome() + " (E:" + Integer.toString(((ao)bz.oa().get(n2)).x().fp()) + ")" + "<br><b>Posic\u00e3o original: </b>" + aq.rH[((ao)bz.oa().get(n2)).x().getPosicao()] + "<br><b>Lado original: </b>" + aq.rK[((ao)bz.oa().get(n2)).x().getLado()] + "<br><b>Idade: </b>" + Integer.toString(((ao)bz.oa().get(n2)).x().getIdade()) + "<br><b>Caract: </b>" + aq.qN[((ao)bz.oa().get(n2)).x().getCr1()] + "/" + aq.qN[((ao)bz.oa().get(n2)).x().getCr2()] + "<br><b>Gol: " + Integer.toString(((ao)bz.oa().get(n2)).x().gK()) + "<br><b>Des: " + Integer.toString(((ao)bz.oa().get(n2)).x().gN()) + "<br><b>Arm: " + Integer.toString(((ao)bz.oa().get(n2)).x().gO()) + "<br><b>Fin: " + Integer.toString(((ao)bz.oa().get(n2)).x().gP()) + "<br><b>Vel: " + Integer.toString(((ao)bz.oa().get(n2)).x().gJ()) + "<br><b>Tec: " + Integer.toString(((ao)bz.oa().get(n2)).x().gL()) + "<br><b>Pas: " + Integer.toString(((ao)bz.oa().get(n2)).x().gM()) + "<br><b>Nota m\u00e9dia</b>: " + string2 + "<br>" + string + "</html>";
            }
        } else if (ao.X(mouseEvent.getX(), mouseEvent.getY())) {
            int n3 = ao.U(mouseEvent.getX(), mouseEvent.getY());
            Double d3 = 0.0;
            if (n3 >= 0 && n3 < bz.oa().size()) {
                d3 = ((ao)bz.oa().get(n3)).x().F();
            }
            String string = String.format("%.2f", d3);
            if (d3 < 2.0) {
                string = "--";
            }
            if (n3 >= 1 && ((ao)bz.oa().get(n3)).x() != null) {
                if (!a.SR.isHabilidadeIndividual()) {
                    return "<html>" + ((ao)bz.oa().get(n3)).x().getNome() + "<br><b>Posic\u00e3o original:</b>" + aq.rH[((ao)bz.oa().get(n3)).x().getPosicao()] + "<br><b>Lado original:</b>" + aq.rK[((ao)bz.oa().get(n3)).x().getLado()] + "<br><b>Idade:</b>" + Integer.toString(((ao)bz.oa().get(n3)).x().getIdade()) + "<br><b>Caract:</b>" + aq.qN[((ao)bz.oa().get(n3)).x().getCr1()] + "/" + aq.qN[((ao)bz.oa().get(n3)).x().getCr2()] + "<br><b>Nota m\u00e9dia</b>: " + string + "</html>";
                }
                return "<html>" + ((ao)bz.oa().get(n3)).x().getNome() + "<br><b>Posic\u00e3o original:</b>" + aq.rH[((ao)bz.oa().get(n3)).x().getPosicao()] + "<br><b>Lado original:</b>" + aq.rK[((ao)bz.oa().get(n3)).x().getLado()] + "<br><b>Idade:</b>" + Integer.toString(((ao)bz.oa().get(n3)).x().getIdade()) + "<br><b>Caract:</b>" + aq.qN[((ao)bz.oa().get(n3)).x().getCr1()] + "/" + aq.qN[((ao)bz.oa().get(n3)).x().getCr2()] + "<br><b>Gol: " + Integer.toString(((ao)bz.oa().get(n3)).x().gK()) + "<br><b>Des:" + Integer.toString(((ao)bz.oa().get(n3)).x().gN()) + "<br><b>Arm:" + Integer.toString(((ao)bz.oa().get(n3)).x().gO()) + "<br><b>Fin: " + Integer.toString(((ao)bz.oa().get(n3)).x().gP()) + "<br><b>Vel:" + Integer.toString(((ao)bz.oa().get(n3)).x().gJ()) + "<br><b>Tec:" + Integer.toString(((ao)bz.oa().get(n3)).x().gL()) + "<br><b>Pas: " + Integer.toString(((ao)bz.oa().get(n3)).x().gM()) + "<br><b>Nota m\u00e9dia</b>: " + string + "</html>";
            }
        }
        return super.getToolTipText(mouseEvent);
    }
}

