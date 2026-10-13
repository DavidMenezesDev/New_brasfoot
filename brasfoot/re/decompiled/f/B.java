/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.F;
import best.L;
import best.Y;
import best.Z;
import best.ac;
import best.ah;
import best.am;
import best.aq;
import best.at;
import best.e;
import c.a;
import components.y;
import est.LoadLigaOptions;
import f.C;
import f.G;
import f.s;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class B
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YL = null;
    private s ZU = null;
    private z ZV = null;
    private ArrayList ZW = new ArrayList();
    private ArrayList ZX = new ArrayList();
    private ArrayList ZY = new ArrayList();
    private transient ArrayList ZZ = new ArrayList();
    private ArrayList aaa = new ArrayList();
    private int divisao = 0;
    private Z KR = null;
    private boolean agz = false;
    private int nRebaixados = 0;
    private boolean[] duasVoltasplayoffReb = new boolean[3];
    private boolean[] duasVoltasMataMataSobe = new boolean[3];
    private int vagasSobemPeloMataMata = 0;
    private int rebaixadosDireto = 2;
    private z agA = null;
    private z agB = null;
    private boolean GU = false;
    public static Comparator aab = new C();

    @Override
    public void clear() {
        this.ZZ.clear();
        this.aaa.clear();
        this.ZW.clear();
    }

    public B() {
    }

    public B(Z z2, int n2) {
        this.F(1, n2);
        this.divisao = n2;
        this.KR = z2;
    }

    public void zF() {
        this.ZU = null;
    }

    public void a(ArrayList arrayList, s s2, int n2) {
        if (n2 == 1020 && arrayList.size() == 8) {
            s s3;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 8;
            loadLigaOptions.nGrupos = 2;
            loadLigaOptions.numeroTimesMataMata = 1;
            loadLigaOptions.doisTurnos = true;
            this.ZU = s3 = new s(loadLigaOptions, arrayList, 0, null, null, s2.vl(), 1, null, false, s2, true, this);
            s3.setNome(s2.getNome());
            s3.fb(1022);
        }
    }

    public void n(ArrayList arrayList, ArrayList arrayList2) {
        this.YL.ai(arrayList2);
    }

    public e D(F f2) {
        int n2 = 0;
        while (n2 < this.ZW.size()) {
            if (((e)this.ZW.get(n2)).x() == f2) {
                return (e)this.ZW.get(n2);
            }
            ++n2;
        }
        e e2 = new e(this, f2);
        this.ZW.add(e2);
        return e2;
    }

    public void E(F f2) {
        boolean bl2 = true;
        if (f2.getPosicao() == 0 && f2.fT() != 1) {
            bl2 = false;
        } else if (f2.getPosicao() == 1 && f2.getLado() == 0 && f2.fT() != 9) {
            bl2 = false;
        } else if (f2.getPosicao() == 1 && f2.getLado() == 1 && f2.fT() != 2) {
            bl2 = false;
        } else if (f2.getPosicao() == 2) {
            if (f2.fT() < 3 || f2.fT() > 8) {
                bl2 = false;
            }
        } else if (f2.getPosicao() == 3) {
            if (f2.fT() < 10 || f2.fT() > 17) {
                bl2 = false;
            }
        } else if (f2.getPosicao() == 4 && f2.fT() < 18) {
            bl2 = false;
        }
        if (f2.getPosicao() == 1 && f2.getLado() == 0 && f2.fT() == 17) {
            bl2 = true;
        }
        if (f2.getPosicao() == 1 && f2.getLado() == 1 && f2.fT() == 10) {
            bl2 = true;
        }
        int[] nArray = new int[26];
        nArray[0] = -1;
        nArray[2] = 5;
        nArray[3] = 2;
        nArray[4] = 2;
        nArray[5] = 2;
        nArray[6] = 2;
        nArray[7] = 2;
        nArray[8] = 2;
        nArray[9] = 1;
        nArray[10] = 3;
        nArray[11] = 6;
        nArray[12] = 6;
        nArray[13] = 6;
        nArray[14] = 3;
        nArray[15] = 3;
        nArray[16] = 3;
        nArray[17] = 3;
        nArray[18] = 4;
        nArray[19] = 4;
        nArray[20] = 4;
        nArray[21] = 4;
        nArray[22] = 4;
        nArray[23] = 4;
        nArray[24] = 4;
        nArray[25] = 4;
        int[] nArray2 = nArray;
        if (bl2) {
            e e2 = this.D(f2);
            e2.a(f2.gk());
            if (nArray2[f2.fT()] == 3 && f2.fF() == 0) {
                e2.j(6);
            } else if (nArray2[f2.fT()] == 3 && f2.fF() == 1) {
                e2.j(3);
            } else if (nArray2[f2.fT()] == 5 && f2.getPosicao() == 3) {
                e2.j(3);
            } else if (nArray2[f2.fT()] == 1 && f2.getPosicao() == 3) {
                e2.j(3);
            } else {
                e2.j(nArray2[f2.fT()]);
            }
        }
    }

    public void fi(int n2) {
        int n3;
        this.zL();
        int[] nArray = new int[11];
        nArray[1] = 1;
        nArray[2] = 2;
        nArray[3] = 2;
        nArray[4] = 5;
        nArray[5] = 6;
        nArray[6] = 6;
        nArray[7] = 3;
        nArray[8] = 3;
        nArray[9] = 4;
        nArray[10] = 4;
        int[] nArray2 = nArray;
        int n4 = this.yi().zk();
        am am2 = new am();
        am2.k(a.SR.H());
        int n5 = 0;
        while (n5 < nArray2.length) {
            n3 = 0;
            while (n3 < this.ZW.size()) {
                if (((e)this.ZW.get(n3)).E() == nArray2[n5] && ((e)this.ZW.get(n3)).D() >= (double)n4 && !am2.lV().contains(((e)this.ZW.get(n3)).x())) {
                    am2.lV().add(((e)this.ZW.get(n3)).x());
                    am2.lW().add(((e)this.ZW.get(n3)).x().fg());
                    break;
                }
                ++n3;
            }
            ++n5;
        }
        this.ZY.add(am2);
        F f2 = null;
        n3 = 0;
        while (n3 < this.ZW.size()) {
            if (((e)this.ZW.get(n3)).D() >= (double)n4) {
                this.ZX.add(((e)this.ZW.get(n3)).x());
                if (n2 != 0 || (f2 = ((e)this.ZW.get(n3)).x()) == null) break;
                f2.a(true);
                break;
            }
            ++n3;
        }
    }

    public ArrayList fj(int n2) {
        ArrayList<e> arrayList = new ArrayList<e>();
        int n3 = this.yi().zk();
        int n4 = 0;
        int n5 = 0;
        while (n5 < this.ZW.size()) {
            if (((e)this.ZW.get(n5)).E() == n2 && ((e)this.ZW.get(n5)).D() >= (double)n3) {
                if (n4 < 20) {
                    arrayList.add((e)this.ZW.get(n5));
                }
                ++n4;
            }
            if (n4 == 20) break;
            ++n5;
        }
        return arrayList;
    }

    public ArrayList zG() {
        ArrayList<e> arrayList = new ArrayList<e>();
        int n2 = this.yi().zk();
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.ZW.size()) {
            if (((e)this.ZW.get(n4)).D() >= (double)n2 && n3 < 20) {
                arrayList.add((e)this.ZW.get(n4));
                ++n3;
            }
            if (n3 >= 20) break;
            ++n4;
        }
        return arrayList;
    }

    public void F(F f2) {
        Y y2 = new Y();
        y2.a(f2);
        y2.j(f2.gk());
        y2.bi(f2.fT());
        if (this.ZZ == null) {
            this.ZZ = new ArrayList();
        }
        this.ZZ.add(y2);
    }

    public void zH() {
        Collections.sort(this.ZZ, aab);
        int[] nArray = new int[]{1, 9, 3, 3, 2, 11, 11, 14, 14, 18, 18};
        int[] nArray2 = new int[]{1, 9, 8, 8, 2, 13, 13, 16, 16, 25, 25};
        am am2 = new am();
        am2.co(this.aaa.size() - 1);
        int n2 = 0;
        while (n2 <= 10) {
            int n3 = 0;
            while (n3 < this.ZZ.size()) {
                if (((Y)this.ZZ.get(n3)).iR() >= nArray[n2] && ((Y)this.ZZ.get(n3)).iR() <= nArray2[n2] && !am2.lV().contains(((Y)this.ZZ.get(n3)).x())) {
                    am2.lV().add(((Y)this.ZZ.get(n3)).x());
                    am2.lW().add(((Y)this.ZZ.get(n3)).x().fg());
                    break;
                }
                ++n3;
            }
            ++n2;
        }
        this.aaa.add(am2);
        this.ZZ.clear();
    }

    public void BJ() {
        this.agA = null;
        this.agB = null;
    }

    public boolean BK() {
        int n2 = this.BN();
        return n2 > 0 && this.vagasSobemPeloMataMata > 0;
    }

    public int BL() {
        if (this.nRebaixados > 0) {
            return this.nRebaixados - this.rebaixadosDireto;
        }
        return 0;
    }

    public boolean BM() {
        if (this.nRebaixados > 0 && this.nRebaixados != this.rebaixadosDireto) {
            if (this.divisao == 4 && this.KR != null && this.KR.jc() == 29 && a.SR.bk()) {
                this.setRebaixadosDireto(this.nRebaixados);
                return false;
            }
            return true;
        }
        return false;
    }

    public int BN() {
        if (this.divisao > 1) {
            return this.KR.K(this.divisao);
        }
        return 0;
    }

    public int[] t(s s2) {
        int[] nArray = new int[3];
        if (s2 == this.YL) {
            nArray[0] = this.KR.K(this.divisao);
            nArray[2] = this.KR.fq(this.divisao);
        }
        if (nArray[0] > 0) {
            nArray[1] = this.vagasSobemPeloMataMata;
            nArray[0] = nArray[0] - this.vagasSobemPeloMataMata;
        }
        return nArray;
    }

    public boolean ac(ah ah2) {
        return this.agB != null && this.agB.zp().size() > 0 && ((G)this.agB.zp().get(0)).zY().contains(ah2);
    }

    public void BO() {
        this.aT(true);
        this.BP();
    }

    public void r(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList.size()) {
            ((ah)arrayList.get(n2)).c(this, 1090, 1098);
            ++n2;
        }
        n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).c(this, 1091, 1098);
            ++n2;
        }
    }

    public void BP() {
        if (this.KR != null) {
            B b2;
            B b3 = this.KR.fo(this.divisao);
            if (b3 != null && b3.BS()) {
                this.a(b3);
            } else if (this.KR.fa(this.divisao)) {
                this.a((B)null);
            }
            if (this.divisao > 1 && (b2 = this.KR.fp(this.divisao)) != null && b2.BS()) {
                b2.a(this);
            }
        }
    }

    public void a(B b2) {
        if (this.BM() && this.agB == null) {
            int n2;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            arrayList = this.YL.fG(this.nRebaixados);
            if (this.YL.ze() == 1020) {
                n2 = 0;
                while (n2 < arrayList.size()) {
                    System.out.println(String.valueOf(arrayList.size()) + " lista rebaixamento: " + ((ah)arrayList.get(n2)).getNome());
                    ++n2;
                }
            }
            Collections.reverse(arrayList);
            n2 = this.nRebaixados - this.rebaixadosDireto;
            if (b2 != null) {
                arrayList2 = b2.yi().l(this.nRebaixados, true);
                Collections.reverse(arrayList2);
            } else if (this.KR != null) {
                arrayList2 = this.KR.ek();
            }
            int n3 = 0;
            while (n3 < n2) {
                if (n3 < arrayList.size() && n3 < arrayList2.size()) {
                    arrayList3.add((ah)arrayList.get(n3));
                    arrayList3.add((ah)arrayList2.get(n3));
                }
                ++n3;
            }
            if (arrayList3.size() > 0) {
                this.agB = new z(null, arrayList3.size(), this.b(), 1, this.duasVoltasplayoffReb, this, 1098);
                G g2 = new G();
                g2.a(this.agB, arrayList3, 0, this.duasVoltasplayoffReb[0], 0, 0, this.b(), false);
            }
        }
    }

    public void BQ() {
        if (this.divisao > 1 && this.agA == null && this.BK()) {
            int n2 = this.BN();
            int n3 = 4;
            int n4 = n2 - this.vagasSobemPeloMataMata;
            int n5 = n4 + n3;
            int n6 = 0;
            ArrayList arrayList = new ArrayList();
            ArrayList<ah> arrayList2 = new ArrayList<ah>();
            arrayList.addAll(this.YL.l(n5, false));
            if (arrayList.size() >= n5) {
                int n7 = n4;
                while (n7 < n5) {
                    arrayList2.add((ah)arrayList.get(n7));
                    ++n7;
                }
                if (this.vagasSobemPeloMataMata == 2) {
                    n6 = 1;
                }
                this.agA = new z(null, arrayList2.size(), this.b(), n6, this.duasVoltasMataMataSobe, this, 1099);
                G g2 = new G();
                g2.a(this.agA, arrayList2, 0, this.duasVoltasMataMataSobe[0], 0, 0, this.b(), false);
            } else {
                this.aT(true);
                this.BP();
            }
        } else {
            this.aT(true);
            this.BP();
        }
    }

    @Override
    public String getNome() {
        if (this.yi() != null) {
            return this.yi().getNome();
        }
        return "Nacional";
    }

    public ArrayList zI() {
        return this.ZY;
    }

    public void zJ() {
        this.ZW.clear();
    }

    public void zK() {
        this.aaa.clear();
    }

    public void zL() {
        Collections.sort(this.ZW, tZ);
    }

    public ArrayList zM() {
        return this.ZX;
    }

    public s yi() {
        return this.YL;
    }

    public void q(s s2) {
        this.YL = s2;
    }

    public ArrayList zN() {
        return this.aaa;
    }

    public Z yg() {
        return this.KR;
    }

    public int zO() {
        if (this.KR != null) {
            return this.KR.jc();
        }
        return -1;
    }

    @Override
    public void mr() {
        if (this.YL.ze() == 1020 && this.ZU != null) {
            this.ZU.za();
        } else {
            this.YL.za();
        }
    }

    @Override
    public Z iq() {
        return this.KR;
    }

    @Override
    public int ip() {
        return this.divisao;
    }

    @Override
    public String P(boolean bl2) {
        return this.YL.io();
    }

    @Override
    public String is() {
        return this.YL.is();
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YL};
        if (this.agB != null) {
            L[] lArray2 = new L[]{this.agB};
            lArray = lArray2;
        } else if (this.agA != null) {
            L[] lArray3 = new L[]{this.agA};
            lArray = lArray3;
        } else if (this.YL.ze() == 1068) {
            lArray[0] = this.YL != null && this.YL.yQ().size() > 0 ? (this.YL.yY() != null ? this.YL.yY() : this.YL) : this.ZV;
        } else if (this.YL.ze() == 1020) {
            if (this.ZU != null) {
                lArray[0] = this.ZU.yY() != null ? this.ZU.yY() : this.ZU;
            }
        } else if (this.YL.yZ()) {
            L[] lArray4 = new L[]{this.YL.yY()};
            lArray = lArray4;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        Object object;
        L[] lArray;
        boolean bl2 = false;
        boolean bl3 = false;
        ArrayList<y> arrayList = new ArrayList<y>();
        if (this.YL.ze() == 1068) {
            lArray = new L[]{this.ZV};
            arrayList.add(new y(lArray, "Fase Preliminar"));
            if (this.YL != null && this.YL.yQ().size() > 0) {
                object = new L[]{this.YL};
                arrayList.add(new y((L[])object, "Fase de Grupos"));
            } else {
                arrayList.add(new y(null, "Fase de Grupos"));
            }
            object = new L[]{this.yi().yY()};
            arrayList.add(new y((L[])object, "Fase Final"));
            bl2 = true;
        } else if (this.YL.ze() == 1020) {
            lArray = new L[]{this.YL};
            arrayList.add(new y(lArray, "Primeira Fase"));
            object = new L[]{this.ZU};
            arrayList.add(new y((L[])object, "Segunda Fase"));
            L[] lArray2 = new L[1];
            if (this.ZU != null) {
                lArray2[0] = this.ZU.yY();
            }
            arrayList.add(new y(lArray2, "Final"));
            bl2 = true;
        } else if (this.YL.yX() > 0) {
            lArray = "Primeira Fase";
            if (this.YL.yQ().size() > 0) {
                lArray = "Fase de Grupos";
            }
            object = new L[]{this.yi()};
            arrayList.add(new y((L[])object, (String)lArray));
            L[] lArray3 = new L[]{this.yi().yY()};
            arrayList.add(new y(lArray3, "Fase Final"));
            bl2 = true;
        }
        if (this.BK()) {
            lArray = new L[]{this.agA};
            arrayList.add(new y(lArray, "Mata-mata vagas ascenso"));
            bl3 = true;
        }
        if (this.BM()) {
            lArray = new L[]{this.agB};
            object = "Playoff (" + String.valueOf(this.divisao) + "\u00aa div x " + String.valueOf(this.divisao + 1) + "\u00aa div)";
            if (this.divisao == 4) {
                object = "Playoff (" + String.valueOf(this.divisao) + "\u00aa div x " + "sem div.";
            }
            arrayList.add(new y(lArray, (String)object));
            bl3 = true;
        }
        if (!bl2 && bl3) {
            lArray = new L[]{this.yi()};
            arrayList.add(0, new y(lArray, "Tabela Liga"));
            bl2 = true;
        }
        if (bl2) {
            return arrayList;
        }
        return null;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        String string = "tr_nacional_" + ac.valueOf("P" + Integer.toString(this.KR.jc())).jA() + "_d" + Integer.toString(this.divisao);
        String string2 = "tr_nacionalgenerico";
        stringArray[0] = aq.w(string) ? string : (this.divisao == 1 ? (aq.w(string = "tr_nacional_" + ac.valueOf("P" + Integer.toString(this.KR.jc())).jA()) ? string : string2) : string2);
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public s zP() {
        return this.ZU;
    }

    public z zQ() {
        return this.ZV;
    }

    public void d(z z2) {
        this.ZV = z2;
    }

    public boolean zc() {
        return this.agz;
    }

    public void aS(boolean bl2) {
        this.agz = bl2;
    }

    public int getnRebaixados() {
        return this.nRebaixados;
    }

    public void setnRebaixados(int n2) {
        this.nRebaixados = n2;
    }

    public int getRebaixadosDireto() {
        return this.rebaixadosDireto;
    }

    public void setRebaixadosDireto(int n2) {
        this.rebaixadosDireto = n2;
    }

    public int getVagasSobemPeloMataMata() {
        return this.vagasSobemPeloMataMata;
    }

    public void setVagasSobemPeloMataMata(int n2) {
        this.vagasSobemPeloMataMata = n2;
        if (this.vagasSobemPeloMataMata > 2) {
            this.vagasSobemPeloMataMata = 0;
        }
        if (this.vagasSobemPeloMataMata < 0) {
            this.vagasSobemPeloMataMata = 0;
        }
    }

    public boolean[] getDuasVoltasplayoffReb() {
        return this.duasVoltasplayoffReb;
    }

    public void a(boolean[] blArray) {
        this.duasVoltasplayoffReb = blArray;
    }

    public boolean[] getDuasVoltasMataMataSobe() {
        return this.duasVoltasMataMataSobe;
    }

    public void b(boolean[] blArray) {
        this.duasVoltasMataMataSobe = blArray;
    }

    public z BR() {
        return this.agA;
    }

    public boolean BS() {
        return this.GU;
    }

    public void aT(boolean bl2) {
        this.GU = bl2;
    }
}

