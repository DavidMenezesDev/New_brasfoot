/*
 * Decompiled with CFR 0.152.
 */
package e;

import e.g;
import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class t
implements Serializable {
    private static final long serialVersionUID = 16L;
    private boolean valid = false;
    private int id = 0;
    private int a;
    private int b;
    private int c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private transient Color j;
    private transient Color k;
    private ArrayList l = new ArrayList();
    private ArrayList m = new ArrayList();
    private int n;
    private int o;
    private int tid;
    private int sid;
    private int aid;
    private int vid;
    private transient String nomep;
    private transient boolean mark = false;
    private String cor1 = "";
    private String cor2 = "";

    public String getCor1() {
        return this.cor1;
    }

    public String getCor2() {
        return this.cor2;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean bl2) {
        this.valid = bl2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int n2) {
        this.id = n2;
    }

    public int getPais() {
        return this.a;
    }

    public void setPais(int n2) {
        this.a = n2;
    }

    public int getEstado() {
        return this.b;
    }

    public void setEstado(int n2) {
        this.b = n2;
    }

    public int getNivel() {
        return this.c;
    }

    public void setNivel(int n2) {
        this.c = n2;
    }

    public String getFileRef() {
        return this.d;
    }

    public boolean semEscudo() {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudos/" + this.d + ".png");
        return !file.exists() || file.isDirectory();
    }

    public boolean semCamisa() {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams/camisas/" + this.d + ".png");
        return !file.exists() || file.isDirectory();
    }

    public boolean hasDuplicado() {
        boolean bl2 = false;
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.l.size()) {
            n2 = 0;
            int n4 = 0;
            while (n4 < this.l.size()) {
                if (((g)this.l.get(n3)).getNome().equals(((g)this.l.get(n4)).getNome())) {
                    ++n2;
                }
                ++n4;
            }
            if (n2 > 1) {
                bl2 = true;
                break;
            }
            ++n3;
        }
        return bl2;
    }

    public void setFileRef(String string) {
        this.d = string;
    }

    public String getNome() {
        return this.e;
    }

    public void setNome(String string) {
        this.e = string;
    }

    public String getEstadio() {
        return this.f;
    }

    public void setEstadio(String string) {
        this.f = string;
    }

    public int getCapacidade() {
        return this.g;
    }

    public void setCapacidade(int n2) {
        this.g = n2;
    }

    public String getTecnico() {
        return this.h;
    }

    public void setTecnico(String string) {
        this.h = string;
    }

    public int getTecNac() {
        return this.i;
    }

    public void setTecNac(int n2) {
        this.i = n2;
    }

    public ArrayList getJogadores() {
        return this.l;
    }

    public void setJogadores(ArrayList arrayList) {
        this.l = arrayList;
    }

    public ArrayList getJuniores() {
        return this.m;
    }

    public void setJuniores(ArrayList arrayList) {
        this.m = arrayList;
    }

    public int getReputacao() {
        return this.n;
    }

    public void setReputacao(int n2) {
        this.n = n2;
    }

    public int getCorBase() {
        return this.o;
    }

    public void setCorBase(int n2) {
        this.o = n2;
    }

    public int getNumeroTitulares() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.getJogadores().size()) {
            if (((g)this.getJogadores().get(n3)).getStatus() == 1) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public int getNumeroTitularesJuniores() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.getJuniores().size()) {
            if (((g)this.getJuniores().get(n3)).getStatus() == 1) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public int getTid() {
        return this.tid;
    }

    public void setTid(int n2) {
        this.tid = n2;
    }

    public int getSid() {
        return this.sid;
    }

    public void setSid(int n2) {
        this.sid = n2;
    }

    public int getAid() {
        return this.aid;
    }

    public void setAid(int n2) {
        this.aid = n2;
    }

    public String getNomep() {
        return this.nomep;
    }

    public void setNomep(String string) {
        this.nomep = string;
    }

    public boolean isMark() {
        return this.mark;
    }

    public void setMark(boolean bl2) {
        this.mark = bl2;
    }

    public int getVid() {
        return this.vid;
    }

    public void setVid(int n2) {
        this.vid = n2;
    }

    public void setCor1(String string) {
        this.cor1 = string;
    }

    public void setCor2(String string) {
        this.cor2 = string;
    }

    public Color getCorF() {
        if (this.j == null) {
            this.j = new Color(Integer.valueOf(this.cor1.substring(1, 3), 16), Integer.valueOf(this.cor1.substring(3, 5), 16), Integer.valueOf(this.cor1.substring(5, 7), 16));
        }
        return this.j;
    }

    public void setCorF(Color color) {
        String string;
        this.cor1 = string = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        this.j = color;
    }

    public Color getCorT() {
        if (this.k == null) {
            this.k = new Color(Integer.valueOf(this.cor2.substring(1, 3), 16), Integer.valueOf(this.cor2.substring(3, 5), 16), Integer.valueOf(this.cor2.substring(5, 7), 16));
        }
        return this.k;
    }

    public void setCorT(Color color) {
        String string;
        this.cor2 = string = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        this.k = color;
    }
}

