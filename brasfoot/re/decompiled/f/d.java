/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.Z;
import best.ah;
import best.at;
import c.a;
import components.y;
import est.LoadLigaOptions;
import f.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class d
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private ArrayList YF = new ArrayList();
    private Z YG = null;
    private int YH = 0;

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YE.clear();
        this.YF.clear();
    }

    public d() {
        this.F(7, 1);
        this.O(true);
    }

    public void ya() {
        this.YE.clear();
        this.YF.clear();
        this.YD = null;
        int[] nArray = new int[2];
        nArray[0] = 10;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[]{1, 3};
        ++this.YH;
        this.YG = this.yb();
        int n2 = 0;
        while (n2 <= 1) {
            if (nArray2[n2] > 0) {
                Z.a(false, nArray3[n2], nArray2[n2], this.YE, false, null);
            }
            ++n2;
        }
        if (this.YE.size() >= 10) {
            s s2;
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n3 = 0;
            while (n3 < this.YE.size()) {
                arrayList.add(((Z)this.YE.get(n3)).jo());
                ((Z)this.YE.get(n3)).z(true);
                ++n3;
            }
            Collections.sort(this.YF, h.a.cN);
            ArrayList arrayList2 = h.a.Al();
            int n4 = 0;
            while (n4 < arrayList2.size()) {
                this.YF.add((ah)arrayList.get((Integer)arrayList2.get(n4)));
                ++n4;
            }
            boolean[] blArray = new boolean[7];
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 10;
            loadLigaOptions.nGrupos = 2;
            loadLigaOptions.numeroTimesMataMata = 4;
            loadLigaOptions.doisTurnos = false;
            loadLigaOptions.duasVoltasMataMata = blArray;
            this.YD = s2 = new s(loadLigaOptions, this.YF, 0, null, null, null, 7, null, false, null, true, this);
            s2.setNome(this.getNome());
            a.afQ.L(this.YF);
        }
    }

    @Override
    public int cy(int n2) {
        int n3 = this.YH - 1;
        n3 %= 10;
        int n4 = 45000;
        int[] nArray = new int[]{65000, 55000, 52698, 48134, 45600, 34990, 37215, 28065};
        int[] nArray2 = new int[]{45000, 42000, 32698, 38134, 35600, 34990, 37215, 28065};
        if (this.YG != null && this.YG.jc() != 11 && this.YG.jc() != 29) {
            nArray = nArray2;
        }
        if (n2 <= 7) {
            n4 = nArray[n2];
        } else if (n2 - 8 < nArray.length) {
            n4 = nArray[n2 - 8];
        }
        return n4;
    }

    @Override
    public String cx(int n2) {
        int n3 = this.YH - 1;
        String[] stringArray = new String[]{"Buenos Aires", "Bogot\u00e1", "C\u00f3rdoba", "Medell\u00edn", "Mendoza", "Ros\u00e1rio", "La Plata", "Cali"};
        String[][] stringArrayArray = new String[][]{{"Buenos Aires", "C\u00f3rdoba", "La Plata", "Mendoza", "Ros\u00e1rio", "Mar del Plata", "Santa F\u00e9", "Almagro"}, {"Quito", "Guayaquil", "Cuenca", "Santo Domingo", "Quito", "Guaiaquil", "Cuenca", "Santo Domingo"}, {"Bogot\u00e1", "Medell\u00edn", "Cali", "Barranquilla", "Bogot\u00e1", "Medell\u00edn", "Cali", "Barranquilla"}, {"Rio de Janeiro", "S\u00e3o Paulo", "Belo Horizonte", "Fortaleza", "Salvador", "Porto Alegre", "Recife", "Curitiba"}, {"Montevid\u00e9u", "Maldonado", "Salto", "Tacuaremb\u00f3", "Montevid\u00e9u", "Maldonado", "Salto", "Tacuaremb\u00f3"}, {"Assun\u00e7\u00e3o", "Ciudad del Este", "Luque", "Capiat\u00e1", "Assun\u00e7\u00e3o", "Ciudad del Este", "Luque", "Capiat\u00e1"}, {"La Paz", "Santa Cruz", "Cochabamba", "Sucre", "Oruro", "Potos\u00ed", "Cochabamba", "Sucre"}, {"Caracas", "Maracaibo", "Valencia", "Barquisimeto", "Maracay", "San Crist\u00f3bal", "Matur\u00edn", "Petare"}, {"Santiago", "Concepci\u00f3n", "Valpara\u00edso", "La Serena", "Antofagasta", "Temuco", "Talca", "Arica"}, {"Lima", "Arequipa", "Cusco", "Iquitos", "Chiclayo", "Trujillo", "Tacna", "Chimbote"}};
        String string = null;
        string = (n3 %= 10) == 0 ? (n2 <= 7 ? stringArray[n2] : stringArray[n2 - 8]) : (n2 <= 7 ? stringArrayArray[n3][n2] : stringArrayArray[n3][n2 - 8]);
        return string;
    }

    public Z yb() {
        int n2 = this.YH - 1;
        int[] nArray = new int[]{11, 60, 46, 29, 195, 150, 26, 198, 42, 151};
        if ((n2 %= 10) >= 0 && n2 < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public s yd() {
        return this.YD;
    }

    public void p(s s2) {
        this.YD = s2;
    }

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"1\u00ba Grupo A", "2\u00ba Grupo B", "1\u00ba Grupo D", "2\u00ba Grupo C", "1\u00ba Grupo B", "2\u00ba Grupo A", "1\u00ba Grupo C", "2\u00ba Grupo D"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.YD.yZ()) {
            L[] lArray2 = new L[]{this.YD.yY()};
            lArray = lArray2;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YD};
        arrayList.add(new y(lArray, "Fase de Grupos"));
        L[] lArray2 = new L[]{this.YD.yY()};
        arrayList.add(new y(lArray2, "Fase Final"));
        return arrayList;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_copaamerica";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public int ye() {
        return this.YH;
    }

    @Override
    public void mr() {
        this.YD.za();
    }
}

