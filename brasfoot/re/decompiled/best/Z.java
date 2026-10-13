/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.I;
import best.K;
import best.aa;
import best.ab;
import best.ac;
import best.ad;
import best.ah;
import best.al;
import best.at;
import best.i;
import best.v;
import best.w;
import c.a;
import est.ConfigLigaType;
import est.LoadLigaOptions;
import f.B;
import f.f;
import f.s;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Z
implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList ds = new ArrayList();
    private int pais;
    private ArrayList dt = new ArrayList();
    private int dw = 0;
    private f hu;
    private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
    private ArrayList hv = new ArrayList();
    private ArrayList hw = new ArrayList();
    private ah hy = null;
    private boolean hz = false;
    private int hr = 0;
    private int hA = 12;
    private String hB = "";
    private boolean hC = false;
    private transient ArrayList hD = new ArrayList();
    private transient ArrayList hE = null;
    public static Comparator hF = new aa();
    public static Comparator cN = new ab();

    public Z() {
    }

    public Z(int n2) {
        this.hB = ac.valueOf("P" + n2).getNome();
        this.pais = n2;
        this.hr = new Random().nextInt(50000);
    }

    public void iT() {
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (((ah)a.SR.P().get(n2)).getPais() == this.pais) {
                this.hv.add((ah)a.SR.P().get(n2));
            }
            ++n2;
        }
    }

    public void K() {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            B b2 = null;
            if (n2 + 1 < this.ds.size()) {
                b2 = (B)this.ds.get(n2 + 1);
            }
            ((B)this.ds.get(n2)).a(b2);
            ++n2;
        }
    }

    public boolean fa(int n2) {
        return n2 >= this.ds.size();
    }

    public B fo(int n2) {
        B b2 = null;
        if (n2 < this.ds.size()) {
            b2 = (B)this.ds.get(n2);
            return b2;
        }
        return null;
    }

    public B fp(int n2) {
        if (n2 > 1) {
            B b2 = null;
            int n3 = n2 - 2;
            if (n3 < this.ds.size()) {
                b2 = (B)this.ds.get(n3);
                return b2;
            }
        }
        return null;
    }

    public void Ar() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(this.hv);
        int n2 = 0;
        while (n2 < arrayList.size()) {
            ((ah)arrayList.get(n2)).l(true);
            ++n2;
        }
        Collections.sort(arrayList, h.a.cN);
        arrayList2.addAll(arrayList);
        ConfigLigaType configLigaType = null;
        LoadLigaOptions loadLigaOptions = null;
        boolean bl2 = false;
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n3 = 4;
        int n4 = 1;
        while (n4 <= n3) {
            bl2 = false;
            configLigaType = Z.t(this.pais, n4);
            loadLigaOptions = new LoadLigaOptions();
            arrayList3.clear();
            int n5 = 0;
            if (configLigaType == null) {
                bl2 = true;
            } else if (configLigaType.getnTimes() > arrayList.size()) {
                bl2 = true;
            }
            if (bl2) {
                loadLigaOptions.nTimes = 20;
                n5 = 2;
                if (arrayList.size() >= 20) {
                    loadLigaOptions.nTimes = 20;
                    n5 = 4;
                } else if (arrayList.size() >= 18) {
                    loadLigaOptions.nTimes = 18;
                } else if (arrayList.size() >= 16) {
                    loadLigaOptions.nTimes = 16;
                } else if (arrayList.size() >= 14) {
                    loadLigaOptions.nTimes = 14;
                } else if (arrayList.size() >= 12) {
                    loadLigaOptions.nTimes = 12;
                } else if (arrayList.size() >= 10) {
                    loadLigaOptions.nTimes = 10;
                }
                loadLigaOptions.nomeLiga = ad.br(this.pais);
            } else {
                loadLigaOptions.nTimes = configLigaType.getnTimes();
                loadLigaOptions.doisTurnos = configLigaType.isDoisTurnos();
                loadLigaOptions.nGrupos = configLigaType.getnGrupos();
                loadLigaOptions.jogosDentroGrupo = configLigaType.isJogosDentroGrupo();
                loadLigaOptions.numeroTimesMataMata = configLigaType.getNumeroTimesMataMata();
                n5 = configLigaType.getnRebaixados();
                loadLigaOptions.duasVoltasMataMata = configLigaType.getDuasVoltasMataMata();
                loadLigaOptions.desempateEstadual = configLigaType.getDesempate();
                loadLigaOptions.classificaPeloGeral = configLigaType.isClassificaPeloGeral();
                loadLigaOptions.melhoresTerceiros = configLigaType.isMelhoresTerceiros();
                loadLigaOptions.numeroTurnos = configLigaType.getFormula();
                if (loadLigaOptions.nTimes <= 10 && n5 > 2) {
                    n5 = 2;
                }
                loadLigaOptions.nomeLiga = configLigaType.getNome2() != null ? configLigaType.getNome2() : ad.br(this.pais);
                loadLigaOptions.nomeDivisao = configLigaType.getNomeDivisao();
            }
            if (arrayList.size() >= loadLigaOptions.nTimes) {
                if (n4 == 4 && this.pais == 29 && a.SR.isJogaEstadual()) {
                    a.SR.e(true);
                } else {
                    int n6 = 0;
                    while (n6 < loadLigaOptions.nTimes) {
                        arrayList3.add((ah)arrayList.get(n6));
                        ++n6;
                    }
                }
                B b2 = new B(this, this.ds.size() + 1);
                if (!bl2) {
                    b2.aS(configLigaType.isRebaixadoPeloGrupo());
                    b2.setRebaixadosDireto(configLigaType.getRebaixadosDireto());
                    b2.setVagasSobemPeloMataMata(configLigaType.getVagasSobemPeloMataMata());
                    b2.a(configLigaType.getDuasVoltasplayoffReb());
                    b2.b(configLigaType.getDuasVoltasMataMataSobe());
                    if (configLigaType.getVersaoArquivo() != 22 || configLigaType.getRebaixadosDireto() == 0 || configLigaType.getRebaixadosDireto() > n5) {
                        b2.setRebaixadosDireto(n5);
                    }
                } else {
                    b2.setRebaixadosDireto(n5);
                }
                b2.setnRebaixados(n5);
                s s2 = new s(loadLigaOptions, arrayList3, 0, null, null, this, 1, null, false, null, false, b2);
                b2.q(s2);
                this.ds.add(b2);
                int n7 = 0;
                while (n7 < arrayList3.size()) {
                    arrayList.remove(arrayList3.get(n7));
                    ++n7;
                }
            }
            ++n4;
        }
        this.iV();
        n4 = 1;
        if (this.pais == 29 && a.SR.bk()) {
            n4 = 0;
        } else if (this.pais == 29 && a.SR.isJogaRegionais()) {
            n4 = 0;
        } else if (this.pais == 29 && a.vM().isNovoFormatoCopa()) {
            n4 = 0;
        } else if (this.pais == 29 && !a.SR.isJogaEstadual() && !a.SR.isJogaRegionais()) {
            n4 = 0;
        }
        if (n4 != 0) {
            this.a(arrayList2, false, "criaLigas");
        }
        if (this.pais == 29 && a.SR.isJogaEstadual()) {
            w.dZ();
        }
    }

    public static ConfigLigaType t(int n2, int n3) {
        int n4 = 0;
        while (n4 < a.SR.bG.size()) {
            if (((ConfigLigaType)a.SR.bG.get(n4)).getPais() == n2 && ((ConfigLigaType)a.SR.bG.get(n4)).getDivisao() == n3) {
                return (ConfigLigaType)a.SR.bG.get(n4);
            }
            ++n4;
        }
        return null;
    }

    private void iV() {
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (((ah)a.SR.P().get(n2)).getPais() == this.pais && ((ah)a.SR.P().get(n2)).getDivisao() == 0) {
                this.dt.add((ah)a.SR.P().get(n2));
                ((ah)a.SR.P().get(n2)).setDivisao(0);
            }
            ++n2;
        }
        Collections.sort(this.dt, h.a.abm);
    }

    public int iW() {
        int n2 = this.hv.size();
        int n3 = 0;
        if (n2 >= 128) {
            n3 = 7;
        } else if (n2 >= 64) {
            n3 = 6;
        } else if (n2 >= 32) {
            n3 = 5;
        } else if (n2 >= 16) {
            n3 = 4;
        } else if (n2 >= 8) {
            n3 = 3;
        }
        return n3 - 1;
    }

    public void y(boolean bl2) {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        if (this.ds.size() >= 1) {
            ah[] ahArray;
            ah ah2 = null;
            ah ah3 = null;
            ah ah4 = null;
            arrayList.addAll(((B)this.ds.get(0)).yi().yV());
            if (this.ds.size() > 1) {
                ahArray = ((B)this.ds.get(1)).yi().yV();
                arrayList.addAll((Collection<ah>)ahArray);
                if (ahArray.size() > 0) {
                    ah2 = (ah)ahArray.get(0);
                }
            }
            if (arrayList.size() < 12) {
                arrayList.addAll(this.ek());
            }
            if (bl2 && ah2 != null) {
                arrayList.remove(ah2);
                arrayList.add(0, ah2);
            }
            if ((ahArray = this.bk(a.SR.H() - 1)) != null) {
                arrayList.remove(ahArray[0]);
                arrayList.add(0, ahArray[0]);
            }
            if (a.SR.aH() != null && a.SR.aH().yz() != null && a.SR.aH().yz().getPais() == this.pais) {
                ah4 = a.SR.aH().yz();
                arrayList.remove(ah4);
                arrayList.add(0, ah4);
            }
            if (a.SR.aF() != null && a.SR.aF().yz() != null && a.SR.aF().yz().getPais() == this.pais) {
                ah3 = a.SR.aF().yz();
                arrayList.remove(ah3);
                arrayList.add(0, ah3);
            }
        }
        this.hu.Bi();
        if (arrayList.size() >= 12) {
            int n2 = 0;
            while (n2 <= 11) {
                this.hu.W((ah)arrayList.get(n2));
                ++n2;
            }
        }
    }

    public void ja() {
        this.a(this.hv, false, "CriaCopaAno1PosLib");
    }

    public void a(ArrayList arrayList, boolean bl2, String string) {
        int n2 = arrayList.size();
        if (this.pais == 29 && n2 >= 91 && a.vM().isNovoFormatoCopa() && !bl2) {
            if (this.hu == null) {
                this.hu = new f(this);
            }
            this.hu.b(this.hu, arrayList, this.duasVoltasMataMata);
        } else if (n2 >= 8) {
            if (this.hu == null) {
                this.hu = new f(this);
            }
            this.hu.a(this.hu, arrayList, this.duasVoltasMataMata);
        }
    }

    public int ec() {
        return this.dw;
    }

    public void jb() {
        ++this.dw;
    }

    public ArrayList eb() {
        return this.ds;
    }

    public int jc() {
        return this.pais;
    }

    public void bj(int n2) {
        this.pais = n2;
    }

    public ah[] bk(int n2) {
        ah[] ahArray = new ah[2];
        if (this.hu != null) {
            int n3 = 0;
            while (n3 < this.hu.mn().size()) {
                if (((i)this.hu.mn().get(n3)).H() == n2) {
                    ahArray[0] = ((i)this.hu.mn().get(n3)).ce();
                    ahArray[1] = ((i)this.hu.mn().get(n3)).cf();
                    return ahArray;
                }
                ++n3;
            }
        }
        return null;
    }

    public void jd() {
        if (this.hD.size() == 0) {
            if (this.ds.size() >= 1) {
                this.hD.addAll(((B)this.ds.get(0)).yi().yV());
                if (this.ds.size() > 1) {
                    this.hD.addAll(((B)this.ds.get(1)).yi().yV());
                }
            } else {
                this.hD = this.je();
            }
        }
    }

    public void a(int n2, ArrayList arrayList, ArrayList arrayList2, boolean bl2) {
        ah[] ahArray;
        this.jd();
        if (bl2 && (ahArray = this.bk(a.SR.H() - 1)) != null && !arrayList2.contains(ahArray[0])) {
            arrayList.add(ahArray[0]);
            arrayList2.add(ahArray[0]);
            --n2;
        }
        if (n2 > 0) {
            int n3 = 0;
            while (n3 < this.hD.size()) {
                if (n2 > 0 && !arrayList2.contains(this.hD.get(n3))) {
                    arrayList.add((ah)this.hD.get(n3));
                    arrayList2.add((ah)this.hD.get(n3));
                    --n2;
                }
                if (n2 == 0) break;
                ++n3;
            }
        }
    }

    private ArrayList je() {
        int[] nArray = new int[]{85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35};
        int n2 = 0;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < this.hv.size()) {
            arrayList.add((ah)this.hv.get(n3));
            ((ah)this.hv.get(n3)).bR(new Random().nextInt(1000) + 1);
            ++n3;
        }
        Collections.sort(arrayList, h.a.cN);
        n3 = 0;
        while (n3 < arrayList.size()) {
            n2 = n3 < nArray.length ? nArray[n3] : 20;
            int n4 = new Random().nextInt(100) + 1;
            if (n4 <= n2) {
                arrayList2.add((ah)arrayList.get(n3));
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            if (!arrayList2.contains(arrayList.get(n3))) {
                arrayList2.add((ah)arrayList.get(n3));
            }
            ++n3;
        }
        return arrayList2;
    }

    public int gg() {
        return ac.valueOf("P" + Integer.toString(this.pais)).gg();
    }

    public String jf() {
        return ac.valueOf("P" + Integer.toString(this.pais)).getNome();
    }

    public ArrayList jg() {
        return this.hv;
    }

    public ArrayList jh() {
        return this.hw;
    }

    public void ee() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        boolean bl2 = false;
        if (this.ds.size() > 0) {
            ((B)this.ds.get(0)).yi().ah(0, ((B)this.ds.get(0)).getnRebaixados());
        }
        int n2 = 1;
        while (n2 < this.ds.size()) {
            ((B)this.ds.get(n2)).yi().ah(((B)this.ds.get(n2 - 1)).getnRebaixados(), ((B)this.ds.get(n2)).getnRebaixados());
            ++n2;
        }
        n2 = 0;
        while (n2 < this.ds.size()) {
            int n3;
            if (n2 + 1 < this.ds.size()) {
                arrayList2.clear();
                arrayList.clear();
                if (bl2) {
                    System.out.println("====divisao " + (n2 + 1));
                }
                int n4 = 0;
                while (n4 < ((B)this.ds.get(n2)).yi().yK().size()) {
                    if (bl2) {
                        System.out.println(String.valueOf(n4) + " " + ((ah)((B)this.ds.get(n2)).yi().yK().get(n4)).getNome());
                    }
                    ++n4;
                }
                n4 = 0;
                while (n4 < ((B)this.ds.get(n2)).yi().yU().size()) {
                    arrayList2.add((ah)((B)this.ds.get(n2)).yi().yU().get(n4));
                    ++n4;
                }
                n4 = 0;
                while (n4 < ((B)this.ds.get(n2 + 1)).yi().yW().size()) {
                    arrayList.add((ah)((B)this.ds.get(n2 + 1)).yi().yW().get(n4));
                    ++n4;
                }
                if (bl2) {
                    n4 = 0;
                    while (n4 < arrayList2.size()) {
                        System.out.println("<<desce " + ((ah)arrayList2.get(n4)).getNome());
                        ++n4;
                    }
                }
                if (bl2) {
                    n4 = 0;
                    while (n4 < arrayList.size()) {
                        System.out.println("<<sobe " + ((ah)arrayList.get(n4)).getNome());
                        ++n4;
                    }
                }
                if (a.SR.bk() && n2 == 2 && this.jc() == 29) {
                    a.SR.bY().clear();
                }
                if (arrayList2.size() == arrayList.size()) {
                    ArrayList arrayList3 = new ArrayList();
                    n3 = 0;
                    while (n3 < arrayList2.size()) {
                        if (!((B)this.ds.get(n2)).ac((ah)arrayList2.get(n3))) {
                            ((ah)arrayList2.get(n3)).b((at)this.ds.get(n2), 0);
                            ((ah)arrayList.get(n3)).b((at)this.ds.get(n2 + 1), 1);
                            ((B)this.ds.get(n2)).yi().yK().remove(arrayList2.get(n3));
                            ((B)this.ds.get(n2 + 1)).yi().yK().add((ah)arrayList2.get(n3));
                            ((B)this.ds.get(n2 + 1)).yi().yK().remove(arrayList.get(n3));
                            ((B)this.ds.get(n2)).yi().yK().add((ah)arrayList.get(n3));
                            if (a.SR.bk() && n2 == 2 && this.jc() == 29) {
                                a.SR.bY().add((ah)arrayList2.get(n3));
                            }
                        }
                        ++n3;
                    }
                }
            } else {
                if (bl2) {
                    System.out.println("====divisao ultima " + n2);
                }
                int n5 = 0;
                while (n5 < ((B)this.ds.get(n2)).yi().yK().size()) {
                    if (bl2) {
                        System.out.println(String.valueOf(n5) + " " + ((ah)((B)this.ds.get(n2)).yi().yK().get(n5)).getNome());
                    }
                    ++n5;
                }
                arrayList2.clear();
                arrayList.clear();
                n5 = ((B)this.ds.get(n2)).getnRebaixados();
                if (this.dt.size() < n5) {
                    n5 = this.dt.size();
                }
                if (n5 > 0) {
                    n3 = 0;
                    while (n3 < ((B)this.ds.get(n2)).yi().yU().size()) {
                        if (n3 < n5) {
                            arrayList2.add((ah)((B)this.ds.get(n2)).yi().yU().get(n3));
                        }
                        ++n3;
                    }
                    if (bl2) {
                        n3 = 0;
                        while (n3 < arrayList2.size()) {
                            System.out.println("<<desce " + ((ah)arrayList2.get(n3)).getNome());
                            ++n3;
                        }
                    }
                    n3 = 0;
                    while (n3 < n5) {
                        arrayList.add((ah)this.dt.get(n3));
                        ++n3;
                    }
                    if (bl2) {
                        n3 = 0;
                        while (n3 < arrayList.size()) {
                            System.out.println("<<sobe " + ((ah)arrayList.get(n3)).getNome());
                            ++n3;
                        }
                    }
                    if (arrayList2.size() == arrayList.size()) {
                        Collections.reverse(arrayList);
                        n3 = 0;
                        while (n3 < arrayList2.size()) {
                            if (!((B)this.ds.get(n2)).ac((ah)arrayList2.get(n3))) {
                                ((ah)arrayList2.get(n3)).b((at)this.ds.get(n2), 0);
                                ((B)this.ds.get(n2)).yi().yK().remove(arrayList2.get(n3));
                                this.dt.add((ah)arrayList2.get(n3));
                                ((ah)arrayList2.get(n3)).setDivisao(0);
                                this.dt.remove(arrayList.get(n3));
                                ((B)this.ds.get(n2)).yi().yK().add((ah)arrayList.get(n3));
                            }
                            ++n3;
                        }
                    }
                }
            }
            ((B)this.ds.get(n2)).yi().yI();
            ++n2;
        }
        if (this.pais == 29 && a.SR.bk()) {
            ((B)this.ds.get(this.ds.size() - 1)).yi().yJ();
        }
        n2 = 0;
        while (n2 < this.ds.size()) {
            ((B)this.ds.get(n2)).BJ();
            ++n2;
        }
    }

    public al ji() {
        ArrayList<al> arrayList = new ArrayList<al>();
        ArrayList<al> arrayList2 = new ArrayList<al>();
        ArrayList<al> arrayList3 = new ArrayList<al>();
        ArrayList<al> arrayList4 = new ArrayList<al>();
        ArrayList<al> arrayList5 = new ArrayList<al>();
        ArrayList<al> arrayList6 = new ArrayList<al>();
        int n2 = this.jc();
        int n3 = 0;
        while (n3 < a.SR.L().size()) {
            if (!((al)a.SR.L().get(n3)).jZ().booleanValue() && ((al)a.SR.L().get(n3)).jo() == null) {
                if (((al)a.SR.L().get(n3)).lE() == n2 && ((al)a.SR.L().get(n3)).getReputacao() == 5) {
                    arrayList.add((al)a.SR.L().get(n3));
                }
                if (((al)a.SR.L().get(n3)).lE() == n2 && ((al)a.SR.L().get(n3)).getReputacao() == 4) {
                    arrayList2.add((al)a.SR.L().get(n3));
                }
                if (((al)a.SR.L().get(n3)).lE() == n2 && ((al)a.SR.L().get(n3)).getReputacao() == 3) {
                    arrayList3.add((al)a.SR.L().get(n3));
                }
                if (((al)a.SR.L().get(n3)).getReputacao() == 5) {
                    arrayList4.add((al)a.SR.L().get(n3));
                }
                if (((al)a.SR.L().get(n3)).getReputacao() == 4) {
                    arrayList5.add((al)a.SR.L().get(n3));
                }
                if (((al)a.SR.L().get(n3)).getReputacao() == 3) {
                    arrayList6.add((al)a.SR.L().get(n3));
                }
            }
            ++n3;
        }
        if (arrayList.size() > 0) {
            return (al)arrayList.get(0);
        }
        if (arrayList2.size() > 0) {
            return (al)arrayList2.get(0);
        }
        if (arrayList4.size() > 0) {
            return (al)arrayList4.get(0);
        }
        if (arrayList5.size() > 0) {
            return (al)arrayList5.get(0);
        }
        if (arrayList3.size() > 0) {
            return (al)arrayList3.get(0);
        }
        if (arrayList6.size() > 0) {
            return (al)arrayList6.get(0);
        }
        return null;
    }

    public void z(boolean bl2) {
        Object object;
        this.jo().kc().clear();
        if ((bl2 || this.jo().ka() == null) && !this.jo().jZ().booleanValue() && (object = this.ji()) != null) {
            this.g((al)object);
        }
        if (!this.hz && !this.jk()) {
            K.r(this.pais, this.hA);
        }
        object = new int[]{3, 4, 4, 5, 4, 3};
        int[] nArray = new int[6];
        nArray[1] = 2;
        nArray[2] = 2;
        nArray[3] = 2;
        nArray[4] = 2;
        nArray[5] = 2;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[6];
        nArray3[1] = 2;
        nArray3[2] = 2;
        nArray3[3] = 3;
        nArray3[4] = 2;
        nArray3[5] = 1;
        int[] nArray4 = nArray3;
        ArrayList<F> arrayList = new ArrayList<F>();
        ArrayList<F> arrayList2 = new ArrayList<F>();
        int n2 = 0;
        while (n2 < a.SR.O().size()) {
            if (((F)a.SR.O().get(n2)).getPais() == this.pais && ((F)a.SR.O().get(n2)).fg() != null) {
                arrayList.add((F)a.SR.O().get(n2));
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < a.SR.bN().size()) {
            if (((F)a.SR.bN().get(n2)).getPais() == this.pais) {
                arrayList.add((F)a.SR.bN().get(n2));
            }
            ++n2;
        }
        Collections.sort(arrayList, hF);
        n2 = 0;
        while (n2 < arrayList.size()) {
            if (((F)arrayList.get(n2)).getPosicao() == 0) {
                if (object[0] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    Object object2 = object;
                    object2[0] = object2[0] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() < 3 && ((F)arrayList.get(n2)).getLado() == 0) {
                if (nArray2[((F)arrayList.get(n2)).getPosicao()] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    int n3 = ((F)arrayList.get(n2)).getPosicao();
                    nArray2[n3] = nArray2[n3] - 1;
                    Object object3 = object;
                    int n4 = ((F)arrayList.get(n2)).getPosicao();
                    object3[n4] = object3[n4] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() < 3 && ((F)arrayList.get(n2)).getLado() == 1) {
                if (nArray4[((F)arrayList.get(n2)).getPosicao()] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    int n5 = ((F)arrayList.get(n2)).getPosicao();
                    nArray4[n5] = nArray4[n5] - 1;
                    Object object4 = object;
                    int n6 = ((F)arrayList.get(n2)).getPosicao();
                    object4[n6] = object4[n6] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 3 && ((F)arrayList.get(n2)).getLado() == 0 && ((F)arrayList.get(n2)).fF() == 1) {
                if (nArray2[3] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    nArray2[3] = nArray2[3] - 1;
                    Object object5 = object;
                    object5[3] = object5[3] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 3 && ((F)arrayList.get(n2)).getLado() == 1 && ((F)arrayList.get(n2)).fF() == 1) {
                if (nArray4[3] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    nArray4[3] = nArray4[3] - 1;
                    Object object6 = object;
                    object6[3] = object6[3] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 3 && ((F)arrayList.get(n2)).getLado() == 0 && ((F)arrayList.get(n2)).fF() == 0) {
                if (nArray2[5] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    nArray2[5] = nArray2[5] - 1;
                    Object object7 = object;
                    object7[5] = object7[5] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 3 && ((F)arrayList.get(n2)).getLado() == 1 && ((F)arrayList.get(n2)).fF() == 0) {
                if (nArray4[5] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    nArray4[5] = nArray4[5] - 1;
                    Object object8 = object;
                    object8[5] = object8[5] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 4 && ((F)arrayList.get(n2)).getLado() == 0) {
                if (nArray2[4] > 0) {
                    arrayList2.add((F)arrayList.get(n2));
                    nArray2[4] = nArray2[4] - 1;
                    Object object9 = object;
                    object9[4] = object9[4] - true;
                }
            } else if (((F)arrayList.get(n2)).getPosicao() == 4 && ((F)arrayList.get(n2)).getLado() == 1 && nArray4[4] > 0) {
                arrayList2.add((F)arrayList.get(n2));
                nArray4[4] = nArray4[4] - 1;
                Object object10 = object;
                object10[4] = object10[4] - true;
            }
            ++n2;
        }
        if (arrayList.size() < 23) {
            n2 = 0;
            while (n2 <= 5) {
                int n7 = 0;
                n7 = n2 < 5 ? n2 : 3;
                if (object[n2] > 0) {
                    int n8 = 0;
                    while (n8 < arrayList.size()) {
                        if (((F)arrayList.get(n8)).getPosicao() == n7 && !arrayList2.contains(arrayList.get(n8))) {
                            arrayList2.add((F)arrayList.get(n8));
                        }
                        ++n8;
                    }
                }
                ++n2;
            }
        }
        if (arrayList.size() < 23) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                if (!arrayList2.contains(arrayList.get(n2))) {
                    arrayList2.add((F)arrayList.get(n2));
                }
                ++n2;
            }
        }
        Collections.sort(arrayList2, h.a.abe);
        this.hy.N(arrayList2);
        this.hy.o(null);
        this.hy.n((F)null);
        this.hy.kA();
        this.hy.kz();
    }

    public void jj() {
        int n2 = 0;
        int n3 = 0;
        int[] nArray = new int[5];
        int n4 = 0;
        while (n4 < a.SR.O().size()) {
            if (((F)a.SR.O().get(n4)).getPais() == this.pais) {
                if (((F)a.SR.O().get(n4)).getPosicao() == 0) {
                    ++n3;
                } else {
                    ++n2;
                }
                int n5 = ((F)a.SR.O().get(n4)).getPosicao();
                nArray[n5] = nArray[n5] + 1;
            }
            ++n4;
        }
        this.hz = n2 >= 15 && n3 >= 2;
    }

    public boolean jk() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < a.SR.O().size()) {
            if (((F)a.SR.O().get(n4)).getPais() == this.pais) {
                if (((F)a.SR.O().get(n4)).getPosicao() == 0) {
                    ++n3;
                } else {
                    ++n2;
                }
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < a.SR.bN().size()) {
            if (((F)a.SR.bN().get(n4)).getPais() == this.pais) {
                if (((F)a.SR.bN().get(n4)).getPosicao() == 0) {
                    ++n3;
                } else {
                    ++n2;
                }
            }
            ++n4;
        }
        return n2 >= 16 && n3 >= 2;
    }

    public boolean jl() {
        return this.hz;
    }

    public void A(boolean bl2) {
        this.hz = bl2;
    }

    public static void a(boolean bl2, int n2, int n3, ArrayList arrayList, boolean bl3, Z z2) {
        int[] nArray;
        int n4;
        ArrayList<Z> arrayList2 = new ArrayList<Z>();
        boolean bl4 = false;
        if (bl4) {
            n4 = 0;
            while (n4 < a.SR.aG().size()) {
                if (((Z)a.SR.aG().get(n4)).gg() == n2 && ((Z)a.SR.aG().get((int)n4)).hz) {
                    arrayList2.add((Z)a.SR.aG().get(n4));
                }
                ++n4;
            }
        } else {
            n4 = 0;
            while (n4 < a.SR.aG().size()) {
                if (((Z)a.SR.aG().get(n4)).gg() == n2) {
                    arrayList2.add((Z)a.SR.aG().get(n4));
                }
                ++n4;
            }
        }
        Collections.sort(arrayList2, cN);
        int[] nArray2 = new int[]{95, 80, 70, 50, 30, 20, 10, 5};
        int[] nArray3 = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 50};
        int[] nArray4 = new int[]{100, 95, 30, 10, 5};
        int[] nArray5 = new int[]{80, 80, 70, 70, 70, 50};
        int[] nArray6 = new int[]{90, 50, 30, 10, 5};
        int[] nArray7 = new int[]{100, 90, 80, 60, 30};
        int[] nArray8 = new int[]{99, 95, 30, 10, 5};
        int[] nArray9 = new int[]{100, 95, 80, 50, 30, 20, 10, 5};
        if (!bl2) {
            nArray = new int[]{100, 100, 90, 70, 60, 20, 10, 5};
            int[] nArray10 = new int[]{100, 50, 30, 10, 5};
            int[] nArray11 = new int[]{100, 100, 100, 98, 60, 40};
            int[] nArray12 = new int[]{100, 100, 90, 65, 60};
            int[] nArray13 = new int[]{100, 100, 100, 100, 100, 95, 80};
            int[] nArray14 = new int[]{100, 90, 90, 10, 5};
            nArray2 = nArray;
            nArray4 = nArray10;
            nArray5 = nArray11;
            nArray6 = nArray12;
            nArray7 = nArray13;
            nArray8 = nArray14;
        }
        if (n2 == 0) {
            nArray9 = nArray2;
        } else if (n2 == 1) {
            nArray9 = nArray4;
        } else if (n2 == 2) {
            nArray9 = nArray5;
        } else if (n2 == 3) {
            nArray9 = nArray6;
        } else if (n2 == 4) {
            nArray9 = nArray7;
        } else if (n2 == 5) {
            nArray9 = nArray8;
        }
        if (bl3) {
            if (n2 == 4) {
                nArray = new int[]{100, 100, 100, 95, 75, 70, 70, 70, 70};
                nArray3 = nArray;
            } else if (n2 == 3) {
                nArray = new int[]{100, 100, 70, 70, 70, 70, 70, 70, 70};
                nArray3 = nArray;
            }
            nArray9 = nArray3;
            arrayList2.remove(a.SR.aY().eY(1));
        }
        if (n2 != 3 || n3 == 1) {
            // empty if block
        }
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        boolean bl5 = false;
        if (bl5) {
            System.out.println("-----probs");
        }
        int n9 = 0;
        while (n9 < arrayList2.size()) {
            if (n3 > 0) {
                n6 = new Random().nextInt(100) + 1;
                if (n9 > 0 && ((Z)arrayList2.get(n9)).getNivel() < n7 && ++n5 >= nArray9.length) {
                    n5 = nArray9.length - 1;
                }
                if (arrayList2.get(n9) != z2 && n6 <= nArray9[n5] && !arrayList.contains(arrayList2.get(n9))) {
                    arrayList.add((Z)arrayList2.get(n9));
                    --n3;
                    ++n8;
                    if (bl5) {
                        System.out.println("-sim " + n8 + " " + ((Z)arrayList2.get(n9)).jf() + "(n:" + ((Z)arrayList2.get((int)n9)).hA + ") " + n5 + " rand=" + n6 + " prob" + nArray9[n5] + " " + "randdopais:" + ((Z)arrayList2.get((int)n9)).hr);
                    }
                } else if (bl5) {
                    System.out.println("-n\u00e3o " + ((Z)arrayList2.get(n9)).jf() + "(n:" + ((Z)arrayList2.get((int)n9)).hA + ") " + n5 + " rand=" + n6 + " prob" + nArray9[n5] + " " + "randdopais:" + ((Z)arrayList2.get((int)n9)).hr);
                }
                n7 = ((Z)arrayList2.get((int)n9)).hA;
            }
            ++n9;
        }
        n9 = 0;
        while (n9 < arrayList2.size()) {
            if (n3 > 0 && arrayList2.get(n9) != z2 && !arrayList.contains(arrayList2.get(n9))) {
                arrayList.add((Z)arrayList2.get(n9));
                --n3;
            }
            ++n9;
        }
        if (bl5) {
            System.out.println("nos grupos-----");
            n9 = 0;
            while (n9 < arrayList.size()) {
                System.out.println(String.valueOf(((Z)arrayList.get(n9)).jf()) + " " + ((Z)arrayList.get((int)n9)).hA + " " + ((Z)arrayList.get((int)n9)).hr);
                ++n9;
            }
        }
    }

    public int getNivel() {
        return this.hA;
    }

    public void jm() {
        this.hA = ac.valueOf("P" + Integer.toString(this.pais)).getNivel();
    }

    public ah jn() {
        return this.hy;
    }

    public ah jo() {
        if (this.hy == null) {
            ah ah2;
            this.hy = ah2 = new ah(this.jf(), null, -1, this.jc(), -1, this.getNivel(), null, this.jt(), null, null, null, -1, null, true);
            ah2.bX(a.SR.bH());
            a.SR.bI();
            int[] nArray = ac.valueOf("P" + Integer.toString(this.jc())).jB();
            int[] nArray2 = ac.valueOf("P" + Integer.toString(this.jc())).jC();
            this.hy.d(new Color(nArray[0], nArray[1], nArray[2]));
            this.hy.c(new Color(nArray2[0], nArray2[1], nArray2[2]));
            this.hy.ln();
            this.hy.lo();
        }
        return this.hy;
    }

    public void z(ah ah2) {
        this.hy = ah2;
    }

    public void a(ArrayList arrayList, al al2, boolean bl2, boolean bl3) {
        int[][] nArrayArray = new int[5][];
        int[] nArray = new int[6];
        nArray[2] = 1;
        nArray[3] = 2;
        nArray[4] = -1;
        nArray[5] = -1;
        nArrayArray[0] = nArray;
        nArrayArray[1] = new int[]{1, 1, 2, 3, -1, -1};
        nArrayArray[2] = new int[]{2, 2, 3, -1, -1, -1};
        nArrayArray[3] = new int[]{2, 3, 3, -1, -1, -1};
        nArrayArray[4] = new int[]{-1, -1, -1, -1, -1, -1};
        int[][] nArrayArray2 = nArrayArray;
        int[][] nArrayArray3 = new int[5][];
        int[] nArray2 = new int[6];
        nArray2[1] = -1;
        nArray2[2] = -1;
        nArray2[3] = 2;
        nArray2[4] = -1;
        nArray2[5] = -1;
        nArrayArray3[0] = nArray2;
        nArrayArray3[1] = new int[]{1, -1, 2, -1, -1, -1};
        nArrayArray3[2] = new int[]{2, -1, -1, -1, -1, -1};
        nArrayArray3[3] = new int[]{2, 3, -1, -1, -1, -1};
        nArrayArray3[4] = new int[]{-1, -1, -1, -1, -1, -1};
        int[][] nArrayArray4 = nArrayArray3;
        int[][] nArrayArray5 = new int[5][];
        int[] nArray3 = new int[6];
        nArray3[1] = -1;
        nArray3[2] = -1;
        nArray3[3] = -1;
        nArray3[4] = -1;
        nArray3[5] = -1;
        nArrayArray5[0] = nArray3;
        nArrayArray5[1] = new int[]{1, -1, -1, -1, -1, -1};
        nArrayArray5[2] = new int[]{2, -1, -1, -1, -1, -1};
        nArrayArray5[3] = new int[]{2, 3, -1, -1, -1, -1};
        nArrayArray5[4] = new int[]{-1, -1, -1, -1, -1, -1};
        int[][] nArrayArray6 = nArrayArray5;
        int[][] nArrayArray7 = new int[5][];
        int[] nArray4 = new int[6];
        nArray4[1] = 1;
        nArray4[2] = -1;
        nArray4[3] = -1;
        nArray4[4] = -1;
        nArray4[5] = -1;
        nArrayArray7[0] = nArray4;
        nArrayArray7[1] = new int[]{1, 2, -1, -1, -1, -1};
        nArrayArray7[2] = new int[]{2, 8, -1, -1, -1, -1};
        nArrayArray7[3] = new int[]{3, 8, -1, -1, -1, -1};
        nArrayArray7[4] = new int[]{-1, -1, -1, -1, -1, -1};
        int[][] nArrayArray8 = nArrayArray7;
        int[][] nArrayArray9 = new int[5][];
        int[] nArray5 = new int[6];
        nArray5[1] = -1;
        nArray5[2] = -1;
        nArray5[3] = -1;
        nArray5[4] = -1;
        nArray5[5] = -1;
        nArrayArray9[0] = nArray5;
        nArrayArray9[1] = new int[]{1, -1, -1, -1, -1, -1};
        nArrayArray9[2] = new int[]{8, 8, -1, -1, -1, -1};
        nArrayArray9[3] = new int[]{8, 8, -1, -1, -1, -1};
        nArrayArray9[4] = new int[]{-1, -1, -1, -1, -1, -1};
        int[][] nArrayArray10 = nArrayArray9;
        int n2 = -1;
        n2 = al2.fg() == null ? al2.lG() : al2.fg().getDivisao() - 1;
        if (n2 < 0) {
            n2 = this.ds.size() - 1;
        }
        if (n2 > this.ds.size() - 1) {
            n2 = this.ds.size() - 1;
        }
        if (n2 >= 0) {
            int[] nArray6 = nArrayArray2[n2];
            int n3 = new Random().nextInt(1000);
            if (n3 > 700) {
                nArray6 = nArrayArray4[n2];
            } else if (n3 > 500) {
                nArray6 = nArrayArray6[n2];
            }
            if (!bl3) {
                nArray6 = nArrayArray8[n2];
                if (n3 > 500) {
                    nArray6 = nArrayArray10[n2];
                }
            }
            int n4 = 0;
            while (n4 < nArray6.length) {
                if (nArray6[n4] == 8) {
                    nArray6[n4] = this.ds.size() - 1;
                }
                if (nArray6[n4] >= 0 && nArray6[n4] < this.ds.size()) {
                    if (((B)this.ds.get(nArray6[n4])).yi().yK().size() > 0) {
                        ((B)this.ds.get(nArray6[n4])).yi().b(arrayList, al2, bl2);
                    } else if (!al2.jZ().booleanValue()) {
                        this.a(arrayList, al2, bl2);
                    }
                }
                ++n4;
            }
        }
    }

    public void a(ArrayList arrayList, al al2, boolean bl2) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.ek().size()) {
            if (!((ah)this.ek().get(n2)).jZ().booleanValue() && this.ek().get(n2) != al2.lF()) {
                arrayList2.add((ah)this.ek().get(n2));
            }
            ++n2;
        }
        Collections.shuffle(arrayList2);
        n2 = 0;
        if (n2 < arrayList2.size() && !arrayList.contains(arrayList2.get(n2))) {
            arrayList.add((ah)arrayList2.get(n2));
        }
    }

    public void A(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            ((B)this.ds.get(n2)).yi().A(arrayList);
            ++n2;
        }
    }

    public String jp() {
        return this.hB;
    }

    public ArrayList ek() {
        return this.dt;
    }

    public f jq() {
        return this.hu;
    }

    public boolean jr() {
        return this.hC;
    }

    public void B(boolean bl2) {
        this.hC = bl2;
    }

    public int js() {
        return this.ds.size();
    }

    public int jt() {
        if (this.hA >= 20) {
            return 5;
        }
        if (this.hA >= 19) {
            return 4;
        }
        if (this.hA >= 17) {
            return 3;
        }
        if (this.hA >= 15) {
            return 2;
        }
        return 1;
    }

    private void f(al al2) {
        int n2 = -1;
        n2 = al2.jo().getPais();
        Z z2 = a.SR.s(n2);
        if (z2 != null) {
            al al3 = al2;
            al al4 = z2.ji();
            al3.z(null);
            z2.jo().h(null);
            z2.jo().k(false);
            if (al4 != null) {
                z2.g(al4);
            }
            z2.z(false);
        }
    }

    public void g(al al2) {
        if (this.jo().ka() != null) {
            this.jo().ka().z(null);
        }
        if (al2.jo() != null) {
            this.f(al2);
        }
        this.jo().h(al2);
        al2.z(this.jo());
        this.jo().k(al2.jZ());
    }

    public void a(f f2) {
        if (f2 == null && this.hu == null) {
            this.hu = new f(this);
        }
    }

    public boolean ju() {
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n2)).hy() == this.hu && (((I)a.SR.S().get(n2)).hc().jZ().booleanValue() || ((I)a.SR.S().get(n2)).hd().jZ().booleanValue())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean ei() {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            int n3 = 0;
            while (n3 < ((B)this.ds.get(n2)).yi().yK().size()) {
                if (((ah)((B)this.ds.get(n2)).yi().yK().get(n3)).jZ().booleanValue()) {
                    return true;
                }
                ++n3;
            }
            ++n2;
        }
        return false;
    }

    public boolean jv() {
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (((I)a.SR.S().get(n2)).hy() == this.hu) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean ej() {
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (this.ds.contains(((I)a.SR.S().get(n2)).hy())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void jx() {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            ((B)this.ds.get(n2)).zJ();
            ((B)this.ds.get(n2)).zK();
            ++n2;
        }
    }

    public void a(s s2) {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            if (((B)this.ds.get(n2)).yi() == s2) {
                ((B)this.ds.get(n2)).zH();
            }
            ++n2;
        }
    }

    public void jy() {
        this.hD.clear();
    }

    public int K(int n2) {
        int n3 = n2 - 2;
        if (n2 > 1 && n3 < this.ds.size()) {
            return ((B)this.ds.get(n3)).getnRebaixados();
        }
        return 0;
    }

    public int fq(int n2) {
        int n3 = n2 - 2;
        if (n2 > 1 && n3 < this.ds.size()) {
            return ((B)this.ds.get(n3)).BL();
        }
        return 0;
    }

    public v C(boolean bl2) {
        int n2;
        int n3 = 6;
        if (this.hE == null && a.SR.cc() != null) {
            this.hE = new ArrayList();
            n2 = 0;
            while (n2 < a.SR.cc().size()) {
                if (((v)a.SR.cc().get(n2)).getPais() == this.pais) {
                    this.hE.add((v)a.SR.cc().get(n2));
                    if (--n3 == 0) break;
                }
                ++n2;
            }
        }
        if (this.hE != null && this.hE.size() > 0) {
            if (!bl2) {
                if (this.hE != null && this.hE.size() > 0) {
                    return (v)this.hE.get(new Random().nextInt(this.hE.size()));
                }
            } else {
                n2 = new Random().nextInt(2);
                if (n2 < this.hE.size()) {
                    return (v)this.hE.get(n2);
                }
                this.hE.get(0);
            }
        }
        return null;
    }

    public components.al As() {
        components.al al2 = new components.al();
        int n2 = this.jc();
        if (this.gg() == 0) {
            a.SR.aI().a(n2, al2);
            a.SR.aK().a(n2, al2);
            a.SR.mj().a(n2, al2);
        } else if (this.gg() == 1) {
            a.SR.aF().a(n2, al2);
            a.SR.aH().a(n2, al2);
        } else if (this.gg() == 2) {
            a.SR.aO().a(n2, al2);
        } else if (this.gg() == 3) {
            a.SR.aL().a(n2, al2);
        } else if (this.gg() == 4) {
            a.SR.aP().a(n2, al2);
        } else if (this.gg() == 5) {
            a.SR.aQ().a(n2, al2);
        }
        return al2;
    }

    static /* synthetic */ int b(Z z2) {
        return z2.hA;
    }

    static /* synthetic */ int c(Z z2) {
        return z2.hr;
    }
}

