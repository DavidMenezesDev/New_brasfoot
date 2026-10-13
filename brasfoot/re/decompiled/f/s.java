/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.I;
import best.L;
import best.S;
import best.Z;
import best.ag;
import best.ah;
import best.al;
import best.at;
import best.i;
import best.t;
import best.w;
import c.a;
import components.aD;
import components.h;
import est.LoadLigaOptions;
import f.B;
import f.G;
import f.o;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class s
extends L
implements Serializable {
    private static final long serialVersionUID = 1L;
    private at YY = null;
    private Z RT = null;
    private w YZ = null;
    private int divisao = 0;
    private ArrayList Za = new ArrayList();
    private ArrayList Zb = new ArrayList();
    private z Zc = null;
    private ah NS = null;
    private int Zd = 0;
    private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
    private ArrayList as = new ArrayList();
    private int Ze;
    private int Zf = 1;
    private int var0 = -1;
    private int Zg = -1;
    private boolean Zi = false;
    private boolean pulaDuasDatas = false;
    private int Zj = 0;
    private String nomeLiga = null;
    private String nomeDivisao = null;
    public boolean jogosDentroGrupo = true;
    public boolean doisTurnos = true;
    public int nTimes = 0;
    public int desempateEstadual = 0;
    public boolean melhoresTerceiros = false;
    private int numeroTurnos = 0;
    private int Zk = 0;
    public static transient s Zl = null;
    private transient ArrayList wK = new ArrayList();
    private transient ArrayList xc = new ArrayList();
    private int[] Zm;
    private int[] Zn;
    private int[] Zo;
    private int[] Zp;
    private int[] Zq;
    private int[] Zr;
    private int[] Zs;
    private int[] Zt;
    private int[] Zu;
    private int[] Zv;
    private int[] Zw;
    private int[] Zx;
    private int[] Zy;
    private int[] Zz;

    public s() {
        int[] nArray = new int[2];
        nArray[1] = 1;
        this.Zm = nArray;
        int[] nArray2 = new int[2];
        nArray2[0] = 1;
        this.Zn = nArray2;
        int[] nArray3 = new int[4];
        nArray3[1] = 3;
        nArray3[2] = 1;
        nArray3[3] = 2;
        this.Zo = nArray3;
        int[] nArray4 = new int[4];
        nArray4[0] = 3;
        nArray4[2] = 2;
        nArray4[3] = 1;
        this.Zp = nArray4;
        int[] nArray5 = new int[4];
        nArray5[1] = 3;
        nArray5[2] = 2;
        nArray5[3] = 1;
        this.Zq = nArray5;
        int[] nArray6 = new int[4];
        nArray6[0] = 3;
        nArray6[2] = 1;
        nArray6[3] = 2;
        this.Zr = nArray6;
        int[] nArray7 = new int[8];
        nArray7[1] = 1;
        nArray7[2] = 2;
        nArray7[3] = 3;
        nArray7[4] = 4;
        nArray7[5] = 5;
        nArray7[6] = 6;
        nArray7[7] = 7;
        this.Zs = nArray7;
        int[] nArray8 = new int[8];
        nArray8[0] = 1;
        nArray8[2] = 3;
        nArray8[3] = 2;
        nArray8[4] = 5;
        nArray8[5] = 4;
        nArray8[6] = 7;
        nArray8[7] = 6;
        this.Zt = nArray8;
        int[] nArray9 = new int[8];
        nArray9[0] = 1;
        nArray9[1] = 6;
        nArray9[2] = 3;
        nArray9[3] = 4;
        nArray9[5] = 7;
        nArray9[6] = 2;
        nArray9[7] = 5;
        this.Zu = nArray9;
        int[] nArray10 = new int[8];
        nArray10[0] = 6;
        nArray10[1] = 1;
        nArray10[2] = 4;
        nArray10[3] = 3;
        nArray10[4] = 7;
        nArray10[6] = 5;
        nArray10[7] = 2;
        this.Zv = nArray10;
        int[] nArray11 = new int[16];
        nArray11[1] = 3;
        nArray11[2] = 4;
        nArray11[3] = 7;
        nArray11[4] = 8;
        nArray11[5] = 11;
        nArray11[6] = 12;
        nArray11[7] = 15;
        nArray11[8] = 2;
        nArray11[9] = 1;
        nArray11[10] = 6;
        nArray11[11] = 5;
        nArray11[12] = 10;
        nArray11[13] = 9;
        nArray11[14] = 14;
        nArray11[15] = 13;
        this.Zw = nArray11;
        int[] nArray12 = new int[16];
        nArray12[0] = 3;
        nArray12[2] = 7;
        nArray12[3] = 4;
        nArray12[4] = 11;
        nArray12[5] = 8;
        nArray12[6] = 15;
        nArray12[7] = 12;
        nArray12[8] = 1;
        nArray12[9] = 2;
        nArray12[10] = 5;
        nArray12[11] = 6;
        nArray12[12] = 9;
        nArray12[13] = 10;
        nArray12[14] = 13;
        nArray12[15] = 14;
        this.Zx = nArray12;
        int[] nArray13 = new int[32];
        nArray13[0] = 7;
        nArray13[2] = 2;
        nArray13[3] = 5;
        nArray13[4] = 3;
        nArray13[5] = 4;
        nArray13[6] = 6;
        nArray13[7] = 1;
        nArray13[8] = 15;
        nArray13[9] = 8;
        nArray13[10] = 10;
        nArray13[11] = 13;
        nArray13[12] = 11;
        nArray13[13] = 12;
        nArray13[14] = 14;
        nArray13[15] = 9;
        nArray13[16] = 23;
        nArray13[17] = 16;
        nArray13[18] = 18;
        nArray13[19] = 21;
        nArray13[20] = 19;
        nArray13[21] = 20;
        nArray13[22] = 22;
        nArray13[23] = 17;
        nArray13[24] = 31;
        nArray13[25] = 24;
        nArray13[26] = 26;
        nArray13[27] = 29;
        nArray13[28] = 27;
        nArray13[29] = 28;
        nArray13[30] = 30;
        nArray13[31] = 25;
        this.Zy = nArray13;
        int[] nArray14 = new int[32];
        nArray14[0] = 31;
        nArray14[2] = 25;
        nArray14[3] = 6;
        nArray14[4] = 24;
        nArray14[5] = 7;
        nArray14[6] = 27;
        nArray14[7] = 4;
        nArray14[8] = 23;
        nArray14[9] = 8;
        nArray14[10] = 22;
        nArray14[11] = 9;
        nArray14[12] = 29;
        nArray14[13] = 2;
        nArray14[14] = 21;
        nArray14[15] = 10;
        nArray14[16] = 26;
        nArray14[17] = 5;
        nArray14[18] = 20;
        nArray14[19] = 11;
        nArray14[20] = 19;
        nArray14[21] = 12;
        nArray14[22] = 28;
        nArray14[23] = 3;
        nArray14[24] = 18;
        nArray14[25] = 13;
        nArray14[26] = 17;
        nArray14[27] = 14;
        nArray14[28] = 16;
        nArray14[29] = 15;
        nArray14[30] = 30;
        nArray14[31] = 1;
        this.Zz = nArray14;
    }

    public s(LoadLigaOptions loadLigaOptions, ArrayList arrayList, int n2, s s2, s s3, Z z2, int n3, w w2, boolean bl2, s s4, boolean bl3, at at2) {
        int[] nArray = new int[2];
        nArray[1] = 1;
        this.Zm = nArray;
        int[] nArray2 = new int[2];
        nArray2[0] = 1;
        this.Zn = nArray2;
        int[] nArray3 = new int[4];
        nArray3[1] = 3;
        nArray3[2] = 1;
        nArray3[3] = 2;
        this.Zo = nArray3;
        int[] nArray4 = new int[4];
        nArray4[0] = 3;
        nArray4[2] = 2;
        nArray4[3] = 1;
        this.Zp = nArray4;
        int[] nArray5 = new int[4];
        nArray5[1] = 3;
        nArray5[2] = 2;
        nArray5[3] = 1;
        this.Zq = nArray5;
        int[] nArray6 = new int[4];
        nArray6[0] = 3;
        nArray6[2] = 1;
        nArray6[3] = 2;
        this.Zr = nArray6;
        int[] nArray7 = new int[8];
        nArray7[1] = 1;
        nArray7[2] = 2;
        nArray7[3] = 3;
        nArray7[4] = 4;
        nArray7[5] = 5;
        nArray7[6] = 6;
        nArray7[7] = 7;
        this.Zs = nArray7;
        int[] nArray8 = new int[8];
        nArray8[0] = 1;
        nArray8[2] = 3;
        nArray8[3] = 2;
        nArray8[4] = 5;
        nArray8[5] = 4;
        nArray8[6] = 7;
        nArray8[7] = 6;
        this.Zt = nArray8;
        int[] nArray9 = new int[8];
        nArray9[0] = 1;
        nArray9[1] = 6;
        nArray9[2] = 3;
        nArray9[3] = 4;
        nArray9[5] = 7;
        nArray9[6] = 2;
        nArray9[7] = 5;
        this.Zu = nArray9;
        int[] nArray10 = new int[8];
        nArray10[0] = 6;
        nArray10[1] = 1;
        nArray10[2] = 4;
        nArray10[3] = 3;
        nArray10[4] = 7;
        nArray10[6] = 5;
        nArray10[7] = 2;
        this.Zv = nArray10;
        int[] nArray11 = new int[16];
        nArray11[1] = 3;
        nArray11[2] = 4;
        nArray11[3] = 7;
        nArray11[4] = 8;
        nArray11[5] = 11;
        nArray11[6] = 12;
        nArray11[7] = 15;
        nArray11[8] = 2;
        nArray11[9] = 1;
        nArray11[10] = 6;
        nArray11[11] = 5;
        nArray11[12] = 10;
        nArray11[13] = 9;
        nArray11[14] = 14;
        nArray11[15] = 13;
        this.Zw = nArray11;
        int[] nArray12 = new int[16];
        nArray12[0] = 3;
        nArray12[2] = 7;
        nArray12[3] = 4;
        nArray12[4] = 11;
        nArray12[5] = 8;
        nArray12[6] = 15;
        nArray12[7] = 12;
        nArray12[8] = 1;
        nArray12[9] = 2;
        nArray12[10] = 5;
        nArray12[11] = 6;
        nArray12[12] = 9;
        nArray12[13] = 10;
        nArray12[14] = 13;
        nArray12[15] = 14;
        this.Zx = nArray12;
        int[] nArray13 = new int[32];
        nArray13[0] = 7;
        nArray13[2] = 2;
        nArray13[3] = 5;
        nArray13[4] = 3;
        nArray13[5] = 4;
        nArray13[6] = 6;
        nArray13[7] = 1;
        nArray13[8] = 15;
        nArray13[9] = 8;
        nArray13[10] = 10;
        nArray13[11] = 13;
        nArray13[12] = 11;
        nArray13[13] = 12;
        nArray13[14] = 14;
        nArray13[15] = 9;
        nArray13[16] = 23;
        nArray13[17] = 16;
        nArray13[18] = 18;
        nArray13[19] = 21;
        nArray13[20] = 19;
        nArray13[21] = 20;
        nArray13[22] = 22;
        nArray13[23] = 17;
        nArray13[24] = 31;
        nArray13[25] = 24;
        nArray13[26] = 26;
        nArray13[27] = 29;
        nArray13[28] = 27;
        nArray13[29] = 28;
        nArray13[30] = 30;
        nArray13[31] = 25;
        this.Zy = nArray13;
        int[] nArray14 = new int[32];
        nArray14[0] = 31;
        nArray14[2] = 25;
        nArray14[3] = 6;
        nArray14[4] = 24;
        nArray14[5] = 7;
        nArray14[6] = 27;
        nArray14[7] = 4;
        nArray14[8] = 23;
        nArray14[9] = 8;
        nArray14[10] = 22;
        nArray14[11] = 9;
        nArray14[12] = 29;
        nArray14[13] = 2;
        nArray14[14] = 21;
        nArray14[15] = 10;
        nArray14[16] = 26;
        nArray14[17] = 5;
        nArray14[18] = 20;
        nArray14[19] = 11;
        nArray14[20] = 19;
        nArray14[21] = 12;
        nArray14[22] = 28;
        nArray14[23] = 3;
        nArray14[24] = 18;
        nArray14[25] = 13;
        nArray14[26] = 17;
        nArray14[27] = 14;
        nArray14[28] = 16;
        nArray14[29] = 15;
        nArray14[30] = 30;
        nArray14[31] = 1;
        this.Zz = nArray14;
        this.YY = at2;
        this.a(n3);
        this.var0 = loadLigaOptions.var0;
        this.Zi = loadLigaOptions.classificaPeloGeral;
        this.pulaDuasDatas = loadLigaOptions.pulaDuasDatas;
        this.Zd = loadLigaOptions.numeroTimesMataMata;
        this.duasVoltasMataMata = loadLigaOptions.duasVoltasMataMata;
        this.Zj = loadLigaOptions.nGrupos;
        this.jogosDentroGrupo = loadLigaOptions.jogosDentroGrupo;
        this.doisTurnos = loadLigaOptions.doisTurnos;
        this.nTimes = loadLigaOptions.nTimes;
        this.desempateEstadual = loadLigaOptions.desempateEstadual;
        this.melhoresTerceiros = loadLigaOptions.melhoresTerceiros;
        this.nomeLiga = loadLigaOptions.nomeLiga;
        this.nomeDivisao = loadLigaOptions.nomeDivisao;
        this.numeroTurnos = loadLigaOptions.numeroTurnos;
        if (arrayList.size() > 0) {
            int n4 = n2;
            while (n4 < this.nTimes + n2) {
                this.Zb.add((ah)arrayList.get(n4));
                ++n4;
            }
        }
        if (z2 != null) {
            if (s4 == null) {
                z2.jb();
                this.divisao = z2.ec();
            } else {
                this.divisao = s4.getDivisao();
            }
            this.RT = z2;
            this.setNome("Nacional");
        }
        if (this.Zd == 1020) {
            this.Zd = this.Zj > 1 ? 4 : 8;
            this.var0 = 1020;
        }
        if (this.nTimes == 68) {
            this.var0 = 1068;
            if (arrayList.size() == 68) {
                this.a(at2, arrayList);
            }
        } else if (arrayList.size() > 0) {
            if (this.Zj <= 1) {
                this.a(this.Zb, this.doisTurnos, false, null);
            } else if (loadLigaOptions.gruposNumeroDiferenteTimes) {
                this.a(this.Zj, loadLigaOptions.numeroDefinidoTimesPorGrupo);
            } else {
                this.j(this.Zj, bl3);
            }
        }
        this.yH();
        if (z2 != null) {
            this.yI();
        }
        if (w2 != null) {
            this.YZ = w2;
            if (s4 == null && this.var0 != 1801 && this.var0 != 1802 && this.var0 != 1803 && this.var0 != 1804 && this.var0 != 1805) {
                this.YZ.ed();
            }
            this.divisao = w2.ec();
            this.setNome(w2.ea());
        }
    }

    private void a(at at2, ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 67;
        while (n2 > 59) {
            arrayList2.add((ah)arrayList.get(n2));
            --n2;
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        z z2 = new z(this, 8, this.b(), 1, blArray, this.YY, 1068);
        ((B)at2).d(z2);
        G g2 = new G();
        g2.a(z2, arrayList2, 0, true, 0, 0, this.b(), false);
        g2.fb(1068);
    }

    public void aN(boolean bl2) {
        if (this.var0 == 1020) {
            ((B)this.YY).zF();
        }
        this.NS = null;
        this.Za.clear();
        this.Zc = null;
        this.as.clear();
        this.Zf = 1;
        this.wK.clear();
        this.xc.clear();
        this.YY.mw();
        if (this.RT != null) {
            this.RT.jx();
        }
        if (bl2) {
            this.Zb.clear();
        }
        if (this.var0 == 1068) {
            this.aS(false);
            if (this.Zb.size() > 0) {
                this.a(this.YY, this.Zb);
            }
        } else if (this.Zb.size() > 0) {
            if (this.Zj <= 1) {
                this.a(this.Zb, this.doisTurnos, false, null);
            } else {
                this.j(this.Zj, false);
            }
        }
    }

    public void ai(ArrayList arrayList) {
        this.Zb.removeAll(arrayList);
        Collections.sort(this.Zb, h.a.aaV);
        this.j(8, true);
        this.Zb.addAll(arrayList);
        this.yH();
    }

    private void a(int n2, int[] nArray) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n5 = 0;
            while (n5 < nArray[n4]) {
                arrayList.add((ah)this.Zb.get(n3));
                ++n3;
                ++n5;
            }
            best.G g2 = new best.G();
            g2.E(arrayList);
            this.Za.add(g2);
            this.a(arrayList, this.doisTurnos, false, null);
            ++n4;
        }
    }

    private void j(int n2, boolean bl2) {
        int n3;
        int n4;
        int n5 = n2;
        int n6 = this.Zb.size();
        int n7 = n6 / n5;
        ah[][] ahArray = new ah[n5][n7];
        int n8 = 0;
        if (!bl2) {
            n4 = 0;
            while (n4 < n7) {
                n3 = 0;
                while (n3 < n5) {
                    ahArray[n3][n4] = (ah)this.Zb.get(n8);
                    ++n8;
                    ++n3;
                }
                ++n4;
            }
        } else {
            n4 = 0;
            while (n4 < n5) {
                n3 = 0;
                while (n3 < n7) {
                    ahArray[n4][n3] = (ah)this.Zb.get(n8);
                    ++n8;
                    ++n3;
                }
                ++n4;
            }
        }
        n4 = 0;
        while (n4 < n5) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n9 = 0;
            while (n9 < n7) {
                arrayList.add(ahArray[n4][n9]);
                ++n9;
            }
            best.G g2 = new best.G();
            g2.E(arrayList);
            this.Za.add(g2);
            if (this.jogosDentroGrupo) {
                if (this.b() != 7) {
                    this.a(arrayList, this.doisTurnos, false, null);
                } else if (this.b() == 7) {
                    this.a(arrayList, this.doisTurnos, false, null);
                }
            }
            ++n4;
        }
        if (!(this.b() == 7 && a.SR.H() == 1 || this.jogosDentroGrupo)) {
            this.a(this.Zb, this.doisTurnos, true, this.Za);
        }
    }

    private void a(ArrayList arrayList, boolean bl2, boolean bl3, ArrayList arrayList2) {
        int n2;
        ah[][][] ahArray = null;
        at at2 = null;
        at2 = this.YY;
        if (!bl3) {
            if (arrayList.size() == 4 && this.var0 == 7700) {
                ahArray = t.v(arrayList);
            } else if (arrayList.size() == 3 && this.doisTurnos) {
                ahArray = t.a(this, arrayList);
            } else if (arrayList.size() == 3) {
                ahArray = t.g(this, arrayList);
            } else if (arrayList.size() == 5 && !this.doisTurnos) {
                ahArray = t.y(arrayList);
            } else if (arrayList.size() == 5) {
                ahArray = t.b(this, arrayList);
            } else if (arrayList.size() == 6 && this.doisTurnos) {
                ahArray = t.h(this, arrayList);
            } else if (arrayList.size() == 9) {
                ahArray = t.a(this, arrayList, true);
            } else if (arrayList.size() == 11) {
                ahArray = t.c(this, arrayList);
            } else if (arrayList.size() == 19) {
                ahArray = t.e(this, arrayList);
            } else if (arrayList.size() == 25) {
                ahArray = t.d(this, arrayList);
            } else {
                if (this.b() == 1) {
                    bl2 = arrayList.size() != 30 && arrayList.size() != 26 && arrayList.size() != 28 && arrayList.size() != 36;
                }
                if (this.b() == 1 && this.Zj == 0) {
                    this.aS(false);
                }
                n2 = 2;
                if (this.b() == 1) {
                    if (arrayList.size() == 20 && this.var0 == 1020) {
                        n2 = 1;
                    } else if (arrayList.size() == 8 && this.Zj == 0) {
                        n2 = 4;
                    } else if (arrayList.size() == 10 && this.Zj == 0) {
                        n2 = 4;
                        if (this.numeroTurnos == 2) {
                            n2 = 2;
                        } else if (this.numeroTurnos == 3) {
                            n2 = 3;
                        }
                    } else if (arrayList.size() == 12 && this.Zj == 0) {
                        n2 = 3;
                        if (this.numeroTurnos == 2) {
                            n2 = 2;
                        }
                    } else if (arrayList.size() == 14 && this.Zj == 0) {
                        n2 = 3;
                        if (this.numeroTurnos == 2) {
                            n2 = 2;
                        }
                    } else {
                        n2 = bl2 ? 2 : 1;
                    }
                } else {
                    n2 = bl2 ? 2 : 1;
                }
                ahArray = t.a(this, arrayList, n2);
            }
        } else if (this.var0 == 7) {
            ahArray = t.a(arrayList, arrayList2);
        } else if (this.var0 == 10) {
            ahArray = t.b(arrayList, arrayList2);
        }
        n2 = arrayList.size() / 2;
        ArrayList arrayList3 = new ArrayList();
        arrayList3 = best.a.a(this.b(), this.pulaDuasDatas);
        int n3 = 0;
        while (n3 < ahArray.length) {
            int n4 = 0;
            while (n4 < n2) {
                if (ahArray[n3][n4][0] != null && ahArray[n3][n4][3] != null) {
                    new I(this, n3, ahArray[n3][n4][0], ahArray[n3][n4][3], (Integer)arrayList3.get(n3), at2, null);
                }
                ++n4;
            }
            if (!this.yF().contains(arrayList3.get(n3))) {
                this.eZ((Integer)arrayList3.get(n3));
            }
            ++n3;
        }
    }

    private void eZ(int n2) {
        this.as.add(n2);
    }

    public ArrayList yF() {
        return this.as;
    }

    public int yG() {
        return this.Ze;
    }

    public void yH() {
        this.Ze = this.yF().size();
    }

    public void yI() {
        int n2 = 0;
        while (n2 < this.Zb.size()) {
            ((ah)this.Zb.get(n2)).setDivisao(this.divisao);
            ++n2;
        }
    }

    public void yJ() {
        int n2 = 0;
        while (n2 < this.Zb.size()) {
            ((ah)this.Zb.get(n2)).setDivisao(0);
            this.RT.ek().add((ah)this.Zb.get(n2));
            ++n2;
        }
        this.Zb.clear();
    }

    public ArrayList yK() {
        return this.Zb;
    }

    public int getDivisao() {
        return this.divisao;
    }

    private void yN() {
        int n2 = 0;
        while (n2 < this.yQ().size()) {
            a.SR.aY().a(this.YY, a.SR.s(((ah)((best.G)this.yQ().get(n2)).gR().get(0)).getPais()));
            ++n2;
        }
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < this.yQ().size()) {
            arrayList.add((ah)((best.G)this.yQ().get(n3)).gR().get(1));
            ++n3;
        }
        Collections.sort(arrayList, h.a.abn);
        if (arrayList.size() >= 8) {
            n3 = 0;
            while (n3 < 8) {
                arrayList2.add((ah)arrayList.get(n3));
                ++n3;
            }
        }
        Collections.shuffle(arrayList2);
        this.Zc = new z(this, 8, this.b(), 1, this.duasVoltasMataMata, this.YY, -1);
        G g2 = new G();
        g2.a(this.Zc, arrayList2, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), false);
        this.Zc.fc(90);
    }

    private void yO() {
        int n2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int[] nArray = null;
        int n3 = 0;
        while (n3 < this.yQ().size()) {
            n2 = 0;
            while (n2 < this.Zd) {
                arrayList.add((ah)((best.G)this.yQ().get(n3)).gR().get(n2));
                ++n2;
            }
            ++n3;
        }
        if (this.Zj == 10 && this.var0 == 1403) {
            n3 = 0;
            while (n3 < this.yQ().size()) {
                if (((best.G)this.yQ().get(n3)).gR().size() >= 2) {
                    arrayList2.add((ah)((best.G)this.yQ().get(n3)).gR().get(1));
                }
                ++n3;
            }
        } else if (this.Zj != 17) {
            n3 = 0;
            while (n3 < this.yQ().size()) {
                if (((best.G)this.yQ().get(n3)).gR().size() >= 3) {
                    arrayList2.add((ah)((best.G)this.yQ().get(n3)).gR().get(2));
                }
                ++n3;
            }
        } else {
            n3 = 0;
            while (n3 < this.yQ().size()) {
                if (((best.G)this.yQ().get(n3)).gR().size() >= 3) {
                    arrayList2.add((ah)((best.G)this.yQ().get(n3)).gR().get(1));
                }
                ++n3;
            }
        }
        if (this.divisao == 4) {
            Collections.sort(arrayList, h.a.abn);
        }
        Collections.sort(arrayList2, h.a.abn);
        n3 = 0;
        if (this.Zj == 10 && this.var0 == 1403) {
            n3 = 6;
        } else if (this.Zj == 3) {
            n3 = 2;
        } else if (this.Zj == 6) {
            n3 = 4;
        } else if (this.Zj == 12) {
            n3 = 8;
        } else if (this.Zj == 17) {
            n3 = 15;
        }
        if (arrayList2.size() >= n3) {
            n2 = 0;
            while (n2 < n3) {
                arrayList.add((ah)arrayList2.get(n2));
                ++n2;
            }
        }
        if (arrayList.size() == 32) {
            nArray = this.Zz;
        } else if (arrayList.size() == 16) {
            nArray = this.Zw;
        } else if (arrayList.size() == 8) {
            nArray = this.Zu;
            if (this.duasVoltasMataMata[0]) {
                nArray = this.Zv;
            }
        }
        if (nArray != null) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                arrayList3.add((ah)arrayList.get(nArray[n2]));
                ++n2;
            }
            this.Zc = new z(this, arrayList3.size(), this.b(), 0, this.duasVoltasMataMata, this.YY, -1);
            G g2 = new G();
            g2.a(this.Zc, arrayList3, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), false);
        }
    }

    private void yP() {
        int n2;
        boolean bl2 = false;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int[] nArray = null;
        if (this.yQ().size() > 0 && !this.Zi) {
            n2 = 0;
            boolean bl3 = false;
            if (this.b() == 4) {
                if (this.yT().gg() == 1 || this.yT().gg() == 2 || this.yT().gg() == 3) {
                    n2 = 1;
                } else if (this.yT().gg() == 0) {
                    bl3 = true;
                }
            }
            if ((this.b() == 4 || this.b() == 6) && this.yT().gg() == 1) {
                bl2 = true;
            }
            if (this.b() == 6 && this.yT().gg() == 0) {
                bl3 = true;
            }
            if (!bl3 && n2 == 0) {
                int n3 = 0;
                while (n3 < this.yQ().size()) {
                    int n4 = 0;
                    while (n4 < this.Zd) {
                        arrayList.add((ah)((best.G)this.yQ().get(n3)).gR().get(n4));
                        ++n4;
                    }
                    ++n3;
                }
                if (this.var0 == 7 || this.var0 == 10) {
                    nArray = this.Zs;
                    if (this.duasVoltasMataMata[0]) {
                        nArray = this.Zt;
                    }
                } else if (arrayList.size() == 32) {
                    nArray = this.Zy;
                } else if (arrayList.size() == 16) {
                    nArray = this.Zw;
                    if (this.duasVoltasMataMata[0]) {
                        nArray = this.Zx;
                    }
                } else if (arrayList.size() == 8) {
                    nArray = this.Zu;
                    if (this.duasVoltasMataMata[0]) {
                        nArray = this.Zv;
                    }
                } else if (arrayList.size() == 4) {
                    nArray = this.Zq;
                    if (this.duasVoltasMataMata[0]) {
                        nArray = this.Zr;
                    }
                } else if (arrayList.size() == 2) {
                    nArray = this.Zm;
                    if (this.duasVoltasMataMata[0]) {
                        nArray = this.Zn;
                    }
                } else {
                    arrayList2 = arrayList;
                }
                if (nArray != null) {
                    n3 = 0;
                    while (n3 < arrayList.size()) {
                        arrayList2.add((ah)arrayList.get(nArray[n3]));
                        ++n3;
                    }
                }
            } else {
                ArrayList<ah> arrayList3 = new ArrayList<ah>();
                ArrayList<ah> arrayList4 = new ArrayList<ah>();
                int n5 = 0;
                while (n5 < this.yQ().size()) {
                    arrayList3.add((ah)((best.G)this.yQ().get(n5)).gR().get(0));
                    arrayList4.add((ah)((best.G)this.yQ().get(n5)).gR().get(1));
                    ++n5;
                }
                if (n2 != 0) {
                    Collections.sort(arrayList3, h.a.abn);
                    Collections.sort(arrayList4, h.a.abn);
                } else {
                    Collections.shuffle(arrayList3);
                    Collections.shuffle(arrayList4);
                }
                int[] nArray2 = new int[8];
                nArray2[1] = 7;
                nArray2[2] = 3;
                nArray2[3] = 4;
                nArray2[4] = 1;
                nArray2[5] = 6;
                nArray2[6] = 2;
                nArray2[7] = 5;
                int[] nArray3 = nArray2;
                int[] nArray4 = new int[8];
                nArray4[0] = 7;
                nArray4[2] = 4;
                nArray4[3] = 3;
                nArray4[4] = 6;
                nArray4[5] = 1;
                nArray4[6] = 5;
                nArray4[7] = 2;
                int[] nArray5 = nArray4;
                int n6 = 0;
                while (n6 < arrayList3.size()) {
                    arrayList2.add((ah)arrayList4.get(nArray5[n6]));
                    arrayList2.add((ah)arrayList3.get(nArray3[n6]));
                    ++n6;
                }
            }
        } else {
            n2 = 0;
            while (n2 < this.Zd) {
                arrayList.add((ah)this.Zb.get(n2));
                ++n2;
            }
            if (arrayList.size() == 16) {
                nArray = this.Zw;
            } else if (arrayList.size() == 8) {
                nArray = this.Zu;
                if (this.duasVoltasMataMata[0]) {
                    nArray = this.Zv;
                }
            } else if (arrayList.size() == 4) {
                nArray = this.Zo;
                if (this.duasVoltasMataMata[0]) {
                    nArray = this.Zp;
                }
            } else if (arrayList.size() == 2) {
                nArray = this.Zm;
                if (this.duasVoltasMataMata[0]) {
                    nArray = this.Zn;
                }
            } else {
                arrayList2 = arrayList;
            }
            if (nArray != null) {
                n2 = 0;
                while (n2 < arrayList.size()) {
                    arrayList2.add((ah)arrayList.get(nArray[n2]));
                    ++n2;
                }
            }
        }
        if (this.var0 == 1020) {
            ((B)this.YY).a(arrayList2, this, this.var0);
        } else {
            this.Zc = new z(this, arrayList2.size(), this.b(), 0, this.duasVoltasMataMata, this.YY, -1);
            G g2 = new G();
            g2.a(this.Zc, arrayList2, 0, this.duasVoltasMataMata[0], 0, 0, this.b(), bl2);
            if (this.var0 == 1802) {
                this.Zc.fc(1802);
            } else if (this.var0 == 1803) {
                this.Zc.fc(1803);
            }
        }
    }

    public void pO() {
        ArrayList arrayList = new ArrayList();
        arrayList = ((best.a)a.SR.R().get(a.SR.J())).h();
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((I)arrayList.get(n2)).ht() == this) {
                ((I)arrayList.get(n2)).hc().a((I)arrayList.get(n2), this);
                ((I)arrayList.get(n2)).hd().a((I)arrayList.get(n2), this);
            }
            ++n2;
        }
        Zl = this;
        Collections.sort(this.Zb, h.a.abn);
        n2 = 0;
        while (n2 < this.yQ().size()) {
            Collections.sort(((best.G)this.yQ().get(n2)).gR(), h.a.abn);
            ++n2;
        }
        ++this.Zf;
        if (this.b() == 1 && this.Zd == 0 && this.Zf == this.zk()) {
            a.afQ.zj();
            ag.b(this);
        }
        if (this.Zf > this.Ze) {
            if (this.b() == 1 && this.Zd > 0) {
                ag.b(this);
            }
            if (this.Zd > 0) {
                n2 = 0;
                while (n2 < this.Zb.size()) {
                    ((ah)this.Zb.get(n2)).bW(n2);
                    ++n2;
                }
            }
            if (this.var0 == 14001) {
                a.SR.sq().yt();
            } else if (this.var0 == 14401) {
                a.SR.ym().yt();
            } else if (this.var0 == 14003) {
                a.SR.sq().BB();
            } else if (this.var0 != 14002 && this.var0 != 14004 && this.var0 != 14402 && this.var0 != 14403) {
                if (this.var0 == 4005) {
                    a.SR.aI().yt();
                } else if (this.var0 == 6005) {
                    a.SR.aK().Be();
                } else if (this.var0 == 4104) {
                    a.SR.aF().yt();
                } else if (this.var0 == 12005) {
                    a.SR.mj().Be();
                } else if (this.var0 == 6105) {
                    a.SR.aH().yt();
                } else if (this.var0 == 7700) {
                    a.SR.aY().yt();
                } else if (this.var0 == 7701) {
                    a.SR.bQ().Bn();
                } else if (this.var0 == 9001) {
                    a.SR.bL().Bk();
                } else if (this.var0 == 9400) {
                    a.SR.bR().Bp();
                } else if (this.var0 == 9402) {
                    a.SR.bR().Bm();
                } else if (this.var0 == 9500) {
                    a.SR.bS().Bq();
                } else if (this.var0 == 9501) {
                    a.SR.bS().yt();
                } else if (this.var0 == 9100) {
                    a.SR.bK().Bm();
                } else if (this.Zd == 0 && this.var0 == 90) {
                    this.yN();
                } else if (this.var0 == 9201) {
                    a.SR.bM().Bk();
                } else if (this.var0 == 9301) {
                    a.SR.bQ().yt();
                } else if (this.var0 == 9302) {
                    a.SR.bQ().Bm();
                } else if (this.Zd > 0 && this.melhoresTerceiros) {
                    this.yO();
                } else if (this.Zd > 0) {
                    this.yP();
                } else {
                    new i(this.YY, this, (ah)this.Zb.get(0), (ah)this.Zb.get(1));
                }
            }
        }
    }

    public ArrayList yQ() {
        return this.Za;
    }

    public int yR() {
        int n2 = 0;
        if (this.Zd > 0) {
            int n3 = 1;
            int n4 = 0;
            if (this.Zj == 0 || this.Zi) {
                n4 = this.Zd;
            } else {
                n4 = this.Zd * this.Zj;
                if (this.melhoresTerceiros) {
                    if (this.Zj == 3) {
                        n4 += 2;
                    } else if (this.Zj == 6) {
                        n4 += 4;
                    } else if (this.Zj == 12) {
                        n4 += 8;
                    } else if (this.Zj == 17) {
                        n4 += 15;
                    }
                }
            }
            if (n4 == 128) {
                n3 = 7;
            } else if (n4 == 64) {
                n3 = 6;
            } else if (n4 == 32) {
                n3 = 5;
            } else if (n4 == 16) {
                n3 = 4;
            } else if (n4 == 8) {
                n3 = 3;
            } else if (n4 == 4) {
                n3 = 2;
            } else if (n4 == 2) {
                n3 = 1;
            }
            n2 = n3 - 1;
        }
        return n2;
    }

    public ah[] yS() {
        ah[] ahArray = new ah[2];
        int n2 = 0;
        while (n2 < this.YY.mn().size()) {
            if (((i)this.YY.mn().get(n2)).H() == a.SR.H()) {
                ahArray[0] = ((i)this.YY.mn().get(n2)).ce();
                ahArray[1] = ((i)this.YY.mn().get(n2)).cf();
                return ahArray;
            }
            ++n2;
        }
        return null;
    }

    public ah cS() {
        ah ah2 = null;
        int n2 = 0;
        while (n2 < this.YY.mn().size()) {
            if (((i)this.YY.mn().get(n2)).H() == a.SR.H()) {
                ah2 = ((i)this.YY.mn().get(n2)).ce();
                return ah2;
            }
            ++n2;
        }
        return null;
    }

    public ah cv(int n2) {
        ah ah2 = null;
        int n3 = 0;
        while (n3 < this.YY.mn().size()) {
            if (((i)this.YY.mn().get(n3)).H() == n2) {
                ah2 = ((i)this.YY.mn().get(n3)).ce();
                return ah2;
            }
            ++n3;
        }
        return null;
    }

    public at yT() {
        return this.YY;
    }

    public ArrayList yU() {
        return this.xc;
    }

    public ArrayList l(int n2, boolean bl2) {
        z z2;
        int n3;
        int n4;
        Serializable serializable;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        if (this.Zd == 0) {
            if (this.Zb.size() > 0) {
                int n5 = 0;
                while (n5 < n2) {
                    arrayList.add((ah)this.Zb.get(n5));
                    ++n5;
                }
            }
        } else if (this.ze() == 1020) {
            s s2 = ((B)this.YY).zP();
            serializable = s2.yY();
            if (n2 > arrayList.size()) {
                arrayList.add((ah)((G)((z)serializable).zp().get(0)).zY().get(0));
            }
            if (n2 > arrayList.size()) {
                int n6 = 0;
                while (n6 < ((G)((z)serializable).zp().get(0)).zV().size()) {
                    if (!arrayList.contains(((G)((z)serializable).zp().get(0)).zV().get(n6))) {
                        arrayList.add((ah)((G)((z)serializable).zp().get(0)).zV().get(n6));
                    }
                    ++n6;
                }
            }
            Zl = s2;
            if (n2 > arrayList.size()) {
                ArrayList<ah> arrayList2 = new ArrayList<ah>();
                n4 = 0;
                while (n4 < s2.yQ().size()) {
                    arrayList2.add((ah)((best.G)s2.yQ().get(n4)).gR().get(1));
                    ++n4;
                }
                Collections.sort(arrayList2, h.a.abn);
                arrayList.addAll(arrayList2);
            }
            if (arrayList.size() < n2) {
                ArrayList<ah> arrayList3 = new ArrayList<ah>();
                n4 = 0;
                while (n4 < s2.yQ().size()) {
                    n3 = 0;
                    while (n3 < ((best.G)s2.yQ().get(n4)).gR().size()) {
                        if (!arrayList.contains(((best.G)s2.yQ().get(n4)).gR().get(n3))) {
                            arrayList3.add((ah)((best.G)s2.yQ().get(n4)).gR().get(n3));
                        }
                        ++n3;
                    }
                    ++n4;
                }
                Collections.sort(arrayList3, h.a.abn);
                n4 = n2 - arrayList.size();
                n3 = 0;
                while (n3 < arrayList3.size()) {
                    if (n4 > 0) {
                        arrayList.add((ah)arrayList3.get(n3));
                        --n4;
                    }
                    ++n3;
                }
            }
        } else if (this.Zc != null && n2 > 0) {
            int n7 = this.Zc.zp().size() - 1;
            while (n7 >= 0) {
                int n8 = 0;
                while (n8 < ((G)this.Zc.zp().get(n7)).zY().size()) {
                    if (n2 > arrayList.size() && !arrayList.contains(((G)this.Zc.zp().get(n7)).zY().get(n8))) {
                        arrayList.add((ah)((G)this.Zc.zp().get(n7)).zY().get(n8));
                    }
                    ++n8;
                }
                --n7;
            }
            if (n2 > arrayList.size()) {
                n7 = 0;
                while (n7 < n2) {
                    if (n2 > arrayList.size() && !arrayList.contains(this.Zb.get(n7))) {
                        arrayList.add((ah)this.Zb.get(n7));
                    }
                    ++n7;
                }
            }
        } else {
            int n9 = 0;
            while (n9 < n2) {
                if (n2 > arrayList.size() && !arrayList.contains(this.Zb.get(n9))) {
                    arrayList.add((ah)this.Zb.get(n9));
                }
                ++n9;
            }
        }
        if (bl2 && this.YY != null && this.YY instanceof B && this.RT != null && (z2 = ((B)this.YY).BR()) != null) {
            serializable = new ArrayList();
            int n10 = -1;
            if (z2.zp().size() == 1) {
                n10 = 0;
            } else if (z2.zp().size() == 2) {
                n10 = 1;
            }
            if (n10 >= 0 && n10 < z2.zp().size()) {
                ((ArrayList)serializable).addAll(((G)z2.zp().get(n10)).zY());
            }
            n4 = arrayList.size() - ((ArrayList)serializable).size();
            n3 = 0;
            while (n3 < n4) {
                ((ArrayList)serializable).add((ah)arrayList.get(n3));
                ++n3;
            }
            Collections.reverse(serializable);
            arrayList.clear();
            arrayList.addAll((Collection<ah>)((Object)serializable));
        }
        return arrayList;
    }

    public ArrayList fG(int n2) {
        ArrayList<ah> arrayList;
        block12: {
            block11: {
                arrayList = new ArrayList<ah>();
                if (this.Zd != 0) break block11;
                if (this.Zb.size() <= 0) break block12;
                int n3 = this.Zb.size() - 1;
                while (n3 >= this.Zb.size() - n2) {
                    arrayList.add((ah)this.Zb.get(n3));
                    --n3;
                }
                break block12;
            }
            if (!this.zc() || this.Za == null || this.Za.size() == 0) {
                if (this.Zj >= 12 && this.Zc != null) {
                    int n4 = this.Zb.size() - 1;
                    while (n4 >= this.Zb.size() - n2) {
                        if (!this.Zc.U((ah)this.Zb.get(n4))) {
                            arrayList.add((ah)this.Zb.get(n4));
                        }
                        --n4;
                    }
                } else {
                    int n5 = this.Zb.size() - 1;
                    while (n5 >= this.Zb.size() - n2) {
                        arrayList.add((ah)this.Zb.get(n5));
                        --n5;
                    }
                }
            } else {
                if (this.ze() == 1020 || this.zc()) {
                    n2 = n2 == 4 ? 2 : 1;
                }
                int n6 = 0;
                while (n6 < this.Za.size()) {
                    int n7 = ((best.G)this.Za.get(n6)).gR().size() - 1;
                    while (n7 >= ((best.G)this.Za.get(n6)).gR().size() - n2) {
                        arrayList.add((ah)((best.G)this.Za.get(n6)).gR().get(n7));
                        --n7;
                    }
                    ++n6;
                }
            }
        }
        return arrayList;
    }

    public void ah(int n2, int n3) {
        this.xc = new ArrayList();
        this.wK = new ArrayList();
        this.wK.addAll(this.l(n2, true));
        this.xc.addAll(this.fG(n3));
    }

    public ArrayList yV() {
        int n2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        z z2 = this.Zc;
        s s2 = null;
        if (this.ze() == 1020 && (s2 = ((B)this.YY).zP()) != null) {
            z2 = s2.yY();
        }
        if (z2 != null) {
            n2 = z2.zp().size() - 1;
            while (n2 >= 0) {
                int n3 = 0;
                while (n3 < ((G)z2.zp().get(n2)).zY().size()) {
                    if (!arrayList.contains(((G)z2.zp().get(n2)).zY().get(n3))) {
                        arrayList.add((ah)((G)z2.zp().get(n2)).zY().get(n3));
                    }
                    ++n3;
                }
                --n2;
            }
        }
        if (s2 != null) {
            n2 = 0;
            while (n2 < s2.yK().size()) {
                if (!arrayList.contains(s2.yK().get(n2))) {
                    arrayList.add((ah)s2.yK().get(n2));
                }
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < this.Zb.size()) {
            if (!arrayList.contains(this.Zb.get(n2))) {
                arrayList.add((ah)this.Zb.get(n2));
            }
            ++n2;
        }
        return arrayList;
    }

    public ArrayList yW() {
        return this.wK;
    }

    public int yX() {
        return this.Zd;
    }

    public z yY() {
        return this.Zc;
    }

    public void b(ArrayList arrayList, al al2, boolean bl2) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 0;
        int n3 = 0;
        if (bl2) {
            n2 = 2;
            n3 = 6;
        } else {
            n2 = this.Zb.size() - 6;
            n3 = this.Zb.size();
        }
        if (n3 > this.Zb.size()) {
            n3 = this.Zb.size();
        }
        int n4 = n2;
        while (n4 < n3) {
            if (!((ah)this.Zb.get(n4)).jZ().booleanValue() && this.Zb.get(n4) != al2.lF()) {
                arrayList2.add((ah)this.Zb.get(n4));
            }
            ++n4;
        }
        Collections.shuffle(arrayList2);
        n4 = 0;
        while (n4 < arrayList2.size()) {
            if (!arrayList.contains(arrayList2.get(n4))) {
                arrayList.add((ah)arrayList2.get(n4));
                break;
            }
            ++n4;
        }
    }

    public boolean yZ() {
        return this.Zc != null;
    }

    public int P(ah ah2) {
        if (this.Zc != null) {
            return -1;
        }
        int n2 = 0;
        while (n2 < this.Zb.size()) {
            if (this.Zb.get(n2) == ah2) {
                return n2 + 1;
            }
            ++n2;
        }
        return -1;
    }

    public int Q(ah ah2) {
        if (this.Zc != null) {
            return -1;
        }
        if (this.Zj == 0) {
            int n2 = 0;
            while (n2 < this.Zb.size()) {
                if (this.Zb.get(n2) == ah2) {
                    return n2 + 1;
                }
                ++n2;
            }
        } else {
            int n3 = 0;
            while (n3 < this.Za.size()) {
                int n4 = 0;
                while (n4 < ((best.G)this.Za.get(n3)).gR().size()) {
                    if (((best.G)this.Za.get(n3)).gR().get(n4) == ah2) {
                        return n4 + 1;
                    }
                    ++n4;
                }
                ++n3;
            }
        }
        return -1;
    }

    public int R(ah ah2) {
        int n2 = 0;
        while (n2 < this.Zb.size()) {
            if (this.Zb.get(n2) == ah2) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public int getnTimes() {
        return this.nTimes;
    }

    public boolean ei() {
        int n2 = 0;
        while (n2 < this.Zb.size()) {
            if (((ah)this.Zb.get(n2)).jZ().booleanValue()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void f(z z2) {
        int n2;
        at at2 = this.YY;
        int n3 = 0;
        int n4 = 1;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n5 = z2.zp().size() - 1;
        while (n5 >= 0) {
            n2 = 0;
            while (n2 < ((G)z2.zp().get(n5)).zW().size()) {
                ah ah2 = null;
                ah ah3 = null;
                if (((G)z2.zp().get(n5)).zY().contains(((I)((G)z2.zp().get(n5)).zW().get(n2)).hc())) {
                    ah2 = ((I)((G)z2.zp().get(n5)).zW().get(n2)).hc();
                    ah3 = ((I)((G)z2.zp().get(n5)).zW().get(n2)).hd();
                } else if (((G)z2.zp().get(n5)).zY().contains(((I)((G)z2.zp().get(n5)).zW().get(n2)).hd())) {
                    ah2 = ((I)((G)z2.zp().get(n5)).zW().get(n2)).hd();
                    ah3 = ((I)((G)z2.zp().get(n5)).zW().get(n2)).hc();
                }
                if (!arrayList.contains(ah2)) {
                    arrayList.add(ah2);
                    ah2.a(at2, n4, n3);
                    ++n4;
                }
                if (!arrayList.contains(ah3)) {
                    arrayList.add(ah3);
                    ah3.a(at2, n4, n3);
                    ++n4;
                }
                ++n2;
            }
            ++n3;
            --n5;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(((G)this.Zc.zp().get(0)).zV());
        n2 = 0;
        while (n2 < this.Zb.size()) {
            if (!arrayList.contains(this.Zb.get(n2)) && !arrayList2.contains(this.Zb.get(n2))) {
                int n6 = -1;
                if (this.b() == 4 || this.b() == 6 || this.b() == 12) {
                    n6 = 1001;
                }
                ((ah)this.Zb.get(n2)).a(at2, n4, n6);
                ++n4;
            }
            ++n2;
        }
    }

    public void za() {
        at at2 = this.YY;
        boolean bl2 = false;
        if (this.YZ != null) {
            bl2 = true;
        }
        ArrayList<ah> arrayList = new ArrayList<ah>();
        if (this.Zc == null) {
            int n2 = 0;
            while (n2 < this.Zb.size()) {
                ((ah)this.Zb.get(n2)).a(at2, n2 + 1, -1);
                if (bl2 && ((ah)this.Zb.get(n2)).getDivisao() == 0 && a.SR.bx() != null && this.YZ != null) {
                    a.SR.bx().add(new aD(this.YZ.getEstado(), this.divisao, (ah)this.Zb.get(n2), n2 + 1));
                }
                ++n2;
            }
        } else {
            int n3;
            int n4 = 0;
            int n5 = 1;
            int n6 = this.Zc.zp().size() - 1;
            while (n6 >= 0) {
                n3 = 0;
                while (n3 < ((G)this.Zc.zp().get(n6)).zW().size()) {
                    ah ah2 = null;
                    ah ah3 = null;
                    if (((G)this.Zc.zp().get(n6)).zY().contains(((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hc())) {
                        ah2 = ((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hc();
                        ah3 = ((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hd();
                    } else if (((G)this.Zc.zp().get(n6)).zY().contains(((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hd())) {
                        ah2 = ((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hd();
                        ah3 = ((I)((G)this.Zc.zp().get(n6)).zW().get(n3)).hc();
                    }
                    if (!arrayList.contains(ah2)) {
                        arrayList.add(ah2);
                        ah2.a(at2, n5, n4);
                        if (bl2 && ah2.getDivisao() == 0 && a.SR.bx() != null && this.YZ != null) {
                            a.SR.bx().add(new aD(this.YZ.getEstado(), this.divisao, ah2, n5));
                        }
                        ++n5;
                    }
                    if (!arrayList.contains(ah3)) {
                        arrayList.add(ah3);
                        ah3.a(at2, n5, n4);
                        if (bl2 && ah3.getDivisao() == 0 && a.SR.bx() != null && this.YZ != null) {
                            a.SR.bx().add(new aD(this.YZ.getEstado(), this.divisao, ah3, n5));
                        }
                        ++n5;
                    }
                    ++n3;
                }
                ++n4;
                --n6;
            }
            n6 = 0;
            while (n6 < this.Zb.size()) {
                if (!arrayList.contains(this.Zb.get(n6))) {
                    n3 = -1;
                    if (this.b() == 4 || this.b() == 6 || this.b() == 12) {
                        n3 = 1001;
                    }
                    ((ah)this.Zb.get(n6)).a(at2, n5, n3);
                    if (bl2 && ((ah)this.Zb.get(n6)).getDivisao() == 0 && this.YZ != null) {
                        a.SR.bx().add(new aD(this.YZ.getEstado(), this.divisao, (ah)this.Zb.get(n6), n5));
                    }
                    ++n5;
                }
                ++n6;
            }
        }
    }

    @Override
    public w ir() {
        return this.YZ;
    }

    @Override
    public Z iq() {
        return this.YY.iq();
    }

    @Override
    public int ip() {
        return this.divisao;
    }

    @Override
    public String io() {
        return String.valueOf(this.Zf) + "\u00aa rodada";
    }

    @Override
    public String getNome() {
        String string;
        String string2 = super.getNome();
        String string3 = "";
        if (this.divisao > 0 && this.b() != 1) {
            string3 = " - " + this.divisao + "\u00aa D";
        }
        if (this.nomeLiga != null) {
            string2 = this.nomeLiga;
        }
        string2 = string2.replace("Campeonato do", "");
        string2 = string2.replace("Campeonato de", "");
        string2 = string2.replace("Campeonato da", "");
        string2 = string2.replace("Campeonato", "");
        if (this.nomeDivisao != null && this.nomeDivisao.length() > 0) {
            string3 = " - " + this.nomeDivisao;
        }
        if ((string = String.valueOf(string2) + string3).length() > 39) {
            string = String.valueOf(string.substring(0, 39)) + "...";
        }
        return string;
    }

    @Override
    public String is() {
        String string = "";
        if (this.divisao > 0) {
            string = String.valueOf(this.divisao) + "\u00aa Divis\u00e3o";
        }
        if (this.nomeDivisao != null && this.nomeDivisao.length() > 0) {
            string = this.nomeDivisao;
        } else if (this.b() != 3) {
            string = this.nomeLiga;
        }
        if (string.length() > 39) {
            string = String.valueOf(string.substring(0, 39)) + "...";
        }
        return string;
    }

    public int zb() {
        return this.Zf;
    }

    public boolean[] getDuasVoltasMataMata() {
        return this.duasVoltasMataMata;
    }

    public boolean zc() {
        if (this.YY != null && this.YY instanceof B) {
            return ((B)this.YY).zc();
        }
        return false;
    }

    public void aS(boolean bl2) {
        if (this.YY != null && this.YY instanceof B) {
            ((B)this.YY).aS(bl2);
        }
    }

    public int zd() {
        return this.desempateEstadual;
    }

    public void A(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < this.yK().size()) {
            if (((ah)this.yK().get(n2)).ka() != null && ((ah)this.yK().get(n2)).ka().lL() < 10) {
                al al2;
                if (((ah)this.yK().get(n2)).jZ().booleanValue()) {
                    int n3 = 2;
                    n3 = ((ah)this.yK().get(n2)).kb() < 0L ? 1 : new Random().nextInt(2) + 2;
                    al2 = ((ah)this.yK().get(n2)).ka();
                    al al3 = ((ah)this.yK().get(n2)).kE();
                    S.a(al2, al3, (ah)this.yK().get(n2), n3);
                    arrayList.add(new h((ah)this.yK().get(n2), al2, al3, n3));
                } else if (n2 > 5) {
                    al al4 = ((ah)this.yK().get(n2)).ka();
                    al2 = ((ah)this.yK().get(n2)).kE();
                    int n4 = new Random().nextInt(3) + 1;
                    arrayList.add(new h((ah)this.yK().get(n2), al4, al2, n4));
                }
            }
            ++n2;
        }
    }

    public int ze() {
        return this.var0;
    }

    public int zf() {
        return this.Zg;
    }

    public void fb(int n2) {
        this.var0 = n2;
    }

    public void fc(int n2) {
        this.Zg = n2;
    }

    public boolean zg() {
        return this.YZ != null ? this.divisao == this.YZ.eb().size() : this.RT != null && this.divisao == this.RT.eb().size();
    }

    public int zh() {
        if (this.YZ != null) {
            return this.YZ.ek().size();
        }
        if (this.RT != null) {
            return this.RT.ek().size();
        }
        return 0;
    }

    public int[] Bv() {
        int[] nArray = new int[3];
        if (this.YZ != null) {
            if (this.divisao >= 2 && this.divisao - 2 >= 0 && this.divisao - 2 < this.YZ.eb().size()) {
                nArray[0] = ((o)this.YZ.eb().get(this.divisao - 2)).getnRebaixados();
            }
        } else if (this.RT != null && this.divisao >= 2 && this.divisao - 2 >= 0 && this.divisao - 2 < this.RT.eb().size()) {
            nArray[0] = ((B)this.RT.eb().get(this.divisao - 2)).getnRebaixados();
        }
        System.out.println(this.YY);
        return nArray;
    }

    public int getnRebaixados() {
        if (this.YZ != null) {
            return ((o)this.YZ.eb().get(this.divisao - 1)).getnRebaixados();
        }
        if (this.RT != null) {
            return ((B)this.RT.eb().get(this.divisao - 1)).getnRebaixados();
        }
        return 0;
    }

    public int Bw() {
        if (this.RT != null) {
            return ((B)this.RT.eb().get(this.divisao - 1)).getnRebaixados() - ((B)this.RT.eb().get(this.divisao - 1)).getRebaixadosDireto();
        }
        return 0;
    }

    public ah fd(int n2) {
        if (this.RT != null) {
            if (this.RT.gg() == 1) {
                if (n2 == 1) {
                    return a.SR.aF().cS();
                }
                if (n2 == 2) {
                    return a.SR.aH().cS();
                }
            } else if (this.RT.gg() == 0) {
                if (n2 == 1) {
                    return a.SR.aI().cS();
                }
                if (n2 == 2) {
                    return a.SR.aK().cS();
                }
            } else {
                if (this.RT.gg() == 2) {
                    return a.SR.aO().cS();
                }
                if (this.RT.gg() == 3) {
                    return a.SR.aL().cS();
                }
                if (this.RT.gg() == 4) {
                    return a.SR.aP().cS();
                }
                if (this.RT.gg() == 5) {
                    return a.SR.aQ().cS();
                }
            }
        }
        return null;
    }

    public Z vl() {
        return this.RT;
    }

    public int zk() {
        int n2 = 0;
        n2 = this.Zj == 0 ? (this.Zb.size() - 1) * 2 : Math.round(this.Zb.size() / this.Zj) * 2 - 1;
        int n3 = Math.round(n2 / 2);
        if (this.Zf > n3) {
            return Math.round(this.Zf / 2);
        }
        return 0;
    }

    public void setDivisao(int n2) {
        this.divisao = n2;
    }

    public ah tf() {
        return this.NS;
    }

    public boolean zl() {
        return this.Zi;
    }

    public static void r(s s2) {
        Zl = s2;
    }

    public void c(z z2) {
        this.Zc = z2;
    }

    public void Bx() {
        int n2 = 0;
        while (n2 < this.Za.size()) {
            ((best.G)this.Za.get(n2)).dv(n2);
            ++n2;
        }
    }
}

