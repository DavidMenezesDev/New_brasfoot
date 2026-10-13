/*
 * Decompiled with CFR 0.152.
 */
package est;

import java.io.Serializable;

public class ConfigLigaType
implements Serializable {
    private static final long serialVersionUID = 16L;
    private int pais = -1;
    private int divisao = -1;
    private int formula = 0;
    private int desempate = 0;
    private int nTimes = 0;
    private boolean doisTurnos = true;
    private int nGrupos = 0;
    private boolean jogosDentroGrupo = true;
    private boolean rebaixadoPeloGrupo = false;
    private int numeroTimesMataMata = 0;
    private boolean valido = false;
    private int nRebaixados = 2;
    private boolean[] duasVoltasMataMata = new boolean[]{true, true, true, true, true, true, true};
    private boolean classificaPeloGeral = false;
    private boolean melhoresTerceiros = false;
    private String nome = null;
    private String nomeDivisao = null;
    private int playoffRebaixamento = 0;
    private boolean[] duasVoltasplayoffReb = new boolean[3];
    private boolean[] duasVoltasMataMataSobe = new boolean[3];
    private int vagasSobemPeloMataMata = 0;
    private int rebaixadosDireto = 2;
    private int versaoArquivo = 0;

    public int getPais() {
        return this.pais;
    }

    public void setPais(int n2) {
        this.pais = n2;
    }

    public int getDivisao() {
        return this.divisao;
    }

    public void setDivisao(int n2) {
        this.divisao = n2;
    }

    public int getFormula() {
        return this.formula;
    }

    public void setFormula(int n2) {
        this.formula = n2;
    }

    public int getDesempate() {
        return this.desempate;
    }

    public void setDesempate(int n2) {
        this.desempate = n2;
    }

    public int getnTimes() {
        return this.nTimes;
    }

    public void setnTimes(int n2) {
        this.nTimes = n2;
    }

    public boolean isDoisTurnos() {
        return this.doisTurnos;
    }

    public void setDoisTurnos(boolean bl2) {
        this.doisTurnos = bl2;
    }

    public int getnGrupos() {
        return this.nGrupos;
    }

    public void setnGrupos(int n2) {
        this.nGrupos = n2;
    }

    public boolean isJogosDentroGrupo() {
        return this.jogosDentroGrupo;
    }

    public void setJogosDentroGrupo(boolean bl2) {
        this.jogosDentroGrupo = bl2;
    }

    public boolean isRebaixadoPeloGrupo() {
        return this.rebaixadoPeloGrupo;
    }

    public void setRebaixadoPeloGrupo(boolean bl2) {
        this.rebaixadoPeloGrupo = bl2;
    }

    public int getNumeroTimesMataMata() {
        return this.numeroTimesMataMata;
    }

    public void setNumeroTimesMataMata(int n2) {
        this.numeroTimesMataMata = n2;
    }

    public boolean isValido() {
        return this.valido;
    }

    public void setValido(boolean bl2) {
        this.valido = bl2;
    }

    public int getnRebaixados() {
        return this.nRebaixados;
    }

    public void setnRebaixados(int n2) {
        this.nRebaixados = n2;
    }

    public boolean[] getDuasVoltasMataMata() {
        return this.duasVoltasMataMata;
    }

    public void setDuasVoltasMataMata(boolean[] blArray) {
        this.duasVoltasMataMata = blArray;
    }

    public boolean isClassificaPeloGeral() {
        return this.classificaPeloGeral;
    }

    public void setClassificaPeloGeral(boolean bl2) {
        this.classificaPeloGeral = bl2;
    }

    public boolean isMelhoresTerceiros() {
        return this.melhoresTerceiros;
    }

    public void setMelhoresTerceiros(boolean bl2) {
        this.melhoresTerceiros = bl2;
    }

    public String getNome2() {
        return this.nome;
    }

    public void setNome2(String string) {
        this.nome = string;
    }

    public String getNomeDivisao() {
        return this.nomeDivisao;
    }

    public void setNomeDivisao(String string) {
        this.nomeDivisao = string;
    }

    public int getPlayoffRebaixamento() {
        return this.playoffRebaixamento;
    }

    public void setPlayoffRebaixamento(int n2) {
        this.playoffRebaixamento = n2;
    }

    public int getRebaixadosDireto() {
        return this.rebaixadosDireto;
    }

    public void setRebaixadosDireto(int n2) {
        this.rebaixadosDireto = n2;
    }

    public int getVersaoArquivo() {
        return this.versaoArquivo;
    }

    public void setVersaoArquivo(int n2) {
        this.versaoArquivo = n2;
    }

    public int getVagasSobemPeloMataMata() {
        return this.vagasSobemPeloMataMata;
    }

    public void setVagasSobemPeloMataMata(int n2) {
        this.vagasSobemPeloMataMata = n2;
    }

    public void setIdaVoltaMMSobe(boolean bl2, boolean bl3) {
        boolean[] blArray = new boolean[3];
        if (this.duasVoltasMataMataSobe == null) {
            this.duasVoltasMataMataSobe = blArray;
        }
        this.duasVoltasMataMataSobe[0] = bl2;
        this.duasVoltasMataMataSobe[1] = bl3;
    }

    public boolean[] getDuasVoltasMataMataSobe() {
        if (this.duasVoltasMataMataSobe == null) {
            boolean[] blArray = new boolean[3];
            this.duasVoltasMataMataSobe = blArray;
        }
        return this.duasVoltasMataMataSobe;
    }

    public boolean[] getDuasVoltasplayoffReb() {
        if (this.duasVoltasplayoffReb == null) {
            boolean[] blArray = new boolean[3];
            this.duasVoltasplayoffReb = blArray;
        }
        return this.duasVoltasplayoffReb;
    }

    public void setDuasVoltasplayoffReb(boolean bl2) {
        boolean[] blArray = new boolean[3];
        if (this.duasVoltasplayoffReb == null) {
            this.duasVoltasplayoffReb = blArray;
        }
        this.duasVoltasplayoffReb[0] = bl2;
    }
}

