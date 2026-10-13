/*
 * Decompiled with CFR 0.152.
 */
package est;

import best.aq;
import java.io.Serializable;

public class ConfigEstadualType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id = -1;
    private int divisao = -1;
    private int formula = 0;
    private int nRebaixados = 2;
    private int desempate = 0;
    private int[] finaisIdaVolta = new int[]{2, 2, 2};

    public int getnTimes() {
        return aq.sL[this.formula][0];
    }

    public ConfigEstadualType(int n2, int n3) {
        this.setId(n2);
        this.setDivisao(n3);
    }

    public ConfigEstadualType(int[] nArray) {
        this.setId(nArray[0]);
        this.setDivisao(nArray[1]);
        this.setFormula(nArray[2]);
        this.setnRebaixados(nArray[3]);
        this.setDesempate(nArray[4]);
        this.setFinaisIdaVolta(nArray[5], nArray[6], nArray[7]);
    }

    public void setFinaisIdaVolta(int n2, int n3, int n4) {
        this.finaisIdaVolta[0] = n2;
        this.finaisIdaVolta[1] = n3;
        this.finaisIdaVolta[2] = n4;
    }

    public boolean[] getFinaisIdaVoltaFormatado() {
        boolean[] blArray = new boolean[7];
        blArray[3] = true;
        blArray[4] = true;
        blArray[5] = true;
        blArray[6] = true;
        boolean[] blArray2 = blArray;
        if (this.finaisIdaVolta[0] == 2) {
            blArray2[0] = true;
        }
        if (this.finaisIdaVolta[1] == 2) {
            blArray2[1] = true;
        }
        if (this.finaisIdaVolta[2] == 2) {
            blArray2[2] = true;
        }
        return blArray2;
    }

    public void setFinaisIdaVoltaComIndex(int n2, int n3) {
        if (n3 == 1 || n3 == 2) {
            this.finaisIdaVolta[n2] = n3;
        }
    }

    public String getFinaisIdaVoltaString() {
        return String.valueOf(Integer.toString(this.finaisIdaVolta[0])) + "," + Integer.toString(this.finaisIdaVolta[1]) + "," + Integer.toString(this.finaisIdaVolta[2]);
    }

    public int getId() {
        return this.id;
    }

    public String getIdString() {
        return Integer.toString(this.id);
    }

    public void setId(int n2) {
        this.id = n2 >= 0 && n2 <= 26 ? n2 : -1;
    }

    public int getDivisao() {
        return this.divisao;
    }

    public String getDivisaoString() {
        return Integer.toString(this.divisao);
    }

    public void setDivisao(int n2) {
        if (n2 <= 4) {
            this.divisao = n2;
        }
    }

    public int getFormula() {
        return this.formula;
    }

    public String getFormulaString() {
        return Integer.toString(this.formula);
    }

    public void setFormula(int n2) {
        this.formula = n2 < aq.sL.length ? n2 : 0;
    }

    public int getnRebaixados() {
        return this.nRebaixados;
    }

    public String getnRebaixadosString() {
        return Integer.toString(this.nRebaixados);
    }

    public void setnRebaixados(int n2) {
        if (n2 > 0 && n2 <= 4) {
            this.nRebaixados = n2;
        }
    }

    public int getDesempate() {
        return this.desempate;
    }

    public String getDesempateString() {
        return Integer.toString(this.desempate);
    }

    public void setDesempate(int n2) {
        if (n2 == 0 || n2 == 1) {
            this.desempate = n2;
        }
    }
}

