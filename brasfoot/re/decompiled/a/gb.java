/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dV;
import a.gc;
import a.gd;
import a.ge;
import a.gf;
import a.gg;
import best.A;
import best.F;
import components.a;
import components.b;
import components.v;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class gb
extends JPanel {
    private JDialog ub = null;
    private v Db = null;
    private A JO = null;
    private F ef = null;
    private F JP = null;
    private Timer zC;
    private int JQ = 0;
    private int JR = 0;
    private boolean JS = false;
    private dV JT = null;
    private JLabel zM;
    private JLabel JU;
    private JLabel vf;

    public gb(JDialog jDialog, v v2, A a2, F f2, dV dV2) {
        this.ub = jDialog;
        this.JT = dV2;
        this.Db = v2;
        this.JO = a2;
        this.ef = f2;
        if (v2.tR().hc() == a2.cu()) {
            this.JQ = 1;
            this.JR = 2;
            this.JS = v2.tR().hc().jZ();
        } else if (v2.tR().hd() == a2.cu()) {
            this.JQ = 2;
            this.JR = 1;
            this.JS = v2.tR().hd().jZ();
        }
        this.JP = v2.tR().aT(this.JR);
        this.mJ();
        this.vf.setIcon(a2.cu().kU());
        this.JU.setText("<html><center>" + a2.cu().getNome() + " tem um penalty" + "</center></html>");
        this.zC = new Timer();
        this.zC.scheduleAtFixedRate((TimerTask)new gc(this), 2000L, 2000L);
        this.a(this);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new gd(this));
    }

    public void py() {
        int n2 = new Random().nextInt(6);
        String string = "";
        string = n2 == 0 ? String.valueOf(this.ef.getNome()) + " " + "prepara para bater." : (n2 == 1 ? String.valueOf(this.ef.getNome()) + " " + "ajeita com carinho." : (n2 == 2 ? String.valueOf(this.ef.getNome()) + " " + "caminha em dire\u00e7\u00e3o a marca." : (n2 == 3 ? String.valueOf(this.ef.getNome()) + " " + "parece confiante pra bater." : (n2 == 4 ? String.valueOf(this.ef.getNome()) + " " + "corre em dire\u00e7\u00e3o \u00e0 bola." : String.valueOf(this.ef.getNome()) + " " + "coloca a bola na marca."))));
        this.JU.setText("<html><center>" + string + "</center></html>");
        this.zC = new Timer();
        this.zC.scheduleAtFixedRate((TimerTask)new ge(this), 2000L, 2000L);
    }

    private void rJ() {
        int n2 = new Random().nextInt(5);
        String string = "";
        string = n2 == 0 ? "Chuta forte e..." : (n2 == 1 ? "Enfia um bicudo na bola e..." : (n2 == 2 ? "Bate com for\u00e7a e..." : (n2 == 3 ? "Manda uma bomba e..." : "Tenta uma cavadinha e...")));
        this.JU.setText("<html><center>" + string + "</center></html>");
        this.zC = new Timer();
        this.zC.scheduleAtFixedRate((TimerTask)new gf(this), 2000L, 2000L);
    }

    private void nO() {
        int n2 = 70;
        int n3 = 30;
        if (this.ef.getCr1() == 9 || this.ef.getCr2() == 9 || this.ef.gm().booleanValue()) {
            n2 += 10;
            n3 -= 10;
        }
        if (this.ef.ff().booleanValue()) {
            n2 += 5;
            n3 -= 5;
        }
        if (this.JP != null) {
            if (this.JP.getCr1() == 1 || this.JP.getCr2() == 1) {
                n2 -= 10;
                n3 += 10;
            }
            if (this.JP.gm().booleanValue()) {
                n2 -= 10;
                n3 += 10;
            }
            if (this.JP.ff().booleanValue()) {
                n2 -= 5;
                n3 += 5;
            }
        }
        boolean bl2 = false;
        int n4 = new Random().nextInt(100) + 1;
        if (n4 <= n2) {
            bl2 = true;
        }
        String string = "";
        if (bl2) {
            int n5 = new Random().nextInt(7);
            string = n5 == 0 ? "Gol!!!!" : (n5 == 1 ? "Um chute forte e a bola estufa as redes! Gol!!!" : (n5 == 2 ? "Goleiro de um lado e bola do outro! Gol!!!" : (n5 == 3 ? "A torcida vibra, \u00e9 gol!!!" : (n5 == 4 ? "Cobran\u00e7a perfeita! Belo gol!!!" : (n5 == 5 ? "No canto, sem chances para o goleiro!!!" : (n5 == 6 ? String.valueOf(this.ef.getNome()) + " " + "bateu com perfei\u00e7\u00e3o! Gol!!!" : "Gol!!!!"))))));
            this.Db.dJ(this.JQ);
            this.Db.a(this.JO);
            try {
                this.Db.tR().hW().eG(this.JQ - 1);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (this.JQ == 1) {
                this.Db.tR().hv();
            } else {
                this.Db.tR().hx();
            }
            int[] nArray = this.Db.tR().hA();
            int n6 = this.JQ - 1;
            nArray[n6] = nArray[n6] + 1;
            int[] nArray2 = this.Db.tR().hZ();
            int n7 = this.JQ - 1;
            nArray2[n7] = nArray2[n7] + 1;
            this.ef.gB().z();
            if (this.JS && this.JT != null) {
                this.JT.dk(2);
            } else {
                this.JT.dk(3);
            }
        } else {
            int[] nArray = this.Db.tR().hA();
            int n8 = this.JQ - 1;
            nArray[n8] = nArray[n8] + 1;
            this.ef.gB().tF();
            int n9 = new Random().nextInt(7);
            string = n9 == 0 ? "Grande defesa de " + this.JP.getNome() : (n9 == 1 ? "Carimbou a trave!" : (n9 == 2 ? "Pra fora, longe do gol" : (n9 == 3 ? "Grande defesa do goleiro!" : (n9 == 4 ? "O batedor escorrega! Incr\u00edvel! Perdeu!" : (n9 == 5 ? "Bate na trave, no goleiro e vai fora!" : (n9 == 6 ? "Bateu bisonhamente! Foi na arquibancada!" : "Perdeu!!!!"))))));
            if (n9 == 2 || n9 == 6) {
                int[] nArray3 = this.Db.tR().ia();
                int n10 = this.JQ - 1;
                nArray3[n10] = nArray3[n10] + 1;
            } else {
                int[] nArray4 = this.Db.tR().hZ();
                int n11 = this.JQ - 1;
                nArray4[n11] = nArray4[n11] + 1;
            }
            this.JO.a(7);
            if (n9 == 0 || n9 == 3 || n9 == 5) {
                this.JO.g(this.JP);
                this.JP.gB().tJ();
            }
            this.Db.a(this.JO);
            if (this.JS) {
                this.JT.dk(3);
            } else {
                this.JT.dk(2);
            }
        }
        this.JU.setText("<html><center>" + string + "</center></html>");
        this.zC = new Timer();
        this.zC.scheduleAtFixedRate((TimerTask)new gg(this), 2000L, 2000L);
    }

    private void rK() {
        this.ub.dispose();
    }

    private void mJ() {
        this.vf = new JLabel();
        this.JU = new JLabel();
        this.zM = new JLabel();
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setLayout(new b());
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(255, 255, 153));
        this.vf.setHorizontalAlignment(0);
        this.vf.setText("Penalty");
        this.add((Component)this.vf, new a(20, 30, 360, -1));
        this.JU.setFont(new Font("Tahoma", 1, 14));
        this.JU.setForeground(new Color(255, 255, 255));
        this.JU.setHorizontalAlignment(0);
        this.JU.setText("Prepara-se");
        this.add((Component)this.JU, new a(40, 100, 330, 50));
        this.zM.setForeground(new Color(255, 255, 255));
        this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/penalty1.jpg")));
        this.add((Component)this.zM, new a(0, 0, -1, -1));
    }

    static /* synthetic */ Timer a(gb gb2) {
        return gb2.zC;
    }

    static /* synthetic */ void b(gb gb2) {
        gb2.rJ();
    }

    static /* synthetic */ void c(gb gb2) {
        gb2.nO();
    }

    static /* synthetic */ void d(gb gb2) {
        gb2.rK();
    }
}

