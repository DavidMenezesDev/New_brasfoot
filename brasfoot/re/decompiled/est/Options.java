/*
 * Decompiled with CFR 0.152.
 */
package est;

import c.a;
import java.awt.Color;
import java.io.Serializable;

public class Options
implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean jogaEstadual = true;
    private boolean jogaRegionais = true;
    private boolean usaGrupoPadraoEstadual = true;
    private boolean jogaIntClubes = true;
    private boolean jogaSelecoesAll = true;
    private boolean[] jogaSelecoes = new boolean[]{true, true, true, true, true, true, true};
    private boolean salarioMensal = true;
    private boolean habilidadeIndividual = true;
    private boolean jogaIntano1 = true;
    private boolean gruposIntPadrao = false;
    private boolean[] verJint;
    private int autoSalvar;
    private int velocidade;
    private int velocidadeNH;
    private int verDecisaoPenNaoHumano;
    private int verMudancaTecnicos;
    private int verJanelaSubs;
    private int avisoTerminoContrato;
    private boolean autoRenovaContrato;
    private boolean usaCorPlacar;
    private int corPlacar;
    private boolean usaSons;
    private boolean negritoCasa;
    private boolean usaCoresLista;
    private Color[] coresLista;
    private boolean verEstaduaisAgrupados;
    private boolean ignoraLigas;
    private boolean ignoraEstadual;
    private boolean UsarGruposReaisCopa;
    private boolean[] jogaRegionaisTodos;
    private boolean conviteRegionais;
    private int regionaisSemHumanos;
    private boolean verMundias;
    private boolean verSuperCopas;
    private boolean novoFormatoCopa;
    private int corTema;
    private boolean verLeiloes;

    public Options() {
        boolean[] blArray = new boolean[21];
        blArray[0] = true;
        blArray[1] = true;
        blArray[6] = true;
        blArray[7] = true;
        blArray[8] = true;
        blArray[9] = true;
        blArray[10] = true;
        blArray[11] = true;
        blArray[12] = true;
        blArray[13] = true;
        blArray[14] = true;
        blArray[16] = true;
        blArray[17] = true;
        blArray[18] = true;
        blArray[19] = true;
        blArray[20] = true;
        this.verJint = blArray;
        this.autoSalvar = 0;
        this.velocidade = 4;
        this.velocidadeNH = 4;
        this.verDecisaoPenNaoHumano = 0;
        this.verMudancaTecnicos = 1;
        this.verJanelaSubs = 1;
        this.avisoTerminoContrato = 0;
        this.autoRenovaContrato = true;
        this.usaCorPlacar = true;
        this.corPlacar = 0;
        this.usaSons = true;
        this.negritoCasa = true;
        this.usaCoresLista = false;
        this.coresLista = null;
        this.verEstaduaisAgrupados = false;
        this.ignoraLigas = true;
        this.ignoraEstadual = true;
        this.UsarGruposReaisCopa = false;
        this.jogaRegionaisTodos = new boolean[]{true, true, true, true};
        this.conviteRegionais = false;
        this.regionaisSemHumanos = 0;
        this.verMundias = false;
        this.verSuperCopas = false;
        this.novoFormatoCopa = true;
        this.corTema = 0;
        this.verLeiloes = false;
    }

    public boolean isJogaEstadual() {
        return this.jogaEstadual;
    }

    public void setJogaEstadual(boolean bl2) {
        this.jogaEstadual = bl2;
    }

    public boolean isJogaRegionais() {
        return this.jogaRegionais;
    }

    public void setJogaRegionais(boolean bl2) {
        this.jogaRegionais = bl2;
    }

    public boolean isUsaGrupoPadraoEstadual() {
        return this.usaGrupoPadraoEstadual;
    }

    public void setUsaGrupoPadraoEstadual(boolean bl2) {
        this.usaGrupoPadraoEstadual = bl2;
    }

    public boolean isJogaIntClubes() {
        return this.jogaIntClubes;
    }

    public void setJogaIntClubes(boolean bl2) {
        this.jogaIntClubes = bl2;
    }

    public boolean[] getJogaSelecoes() {
        return this.jogaSelecoes;
    }

    public void setJogaSelecoes(boolean[] blArray) {
        this.jogaSelecoes = blArray;
    }

    public boolean isSalarioMensal() {
        return this.salarioMensal;
    }

    public void setSalarioMensal(boolean bl2) {
        this.salarioMensal = bl2;
    }

    public boolean isHabilidadeIndividual() {
        return this.habilidadeIndividual;
    }

    public void setHabilidadeIndividual(boolean bl2) {
        this.habilidadeIndividual = bl2;
    }

    public boolean isJogaIntano1() {
        return this.jogaIntano1;
    }

    public void setJogaIntano1(boolean bl2) {
        this.jogaIntano1 = bl2;
    }

    public boolean isGruposIntPadrao() {
        return this.gruposIntPadrao;
    }

    public void setGruposIntPadrao(boolean bl2) {
        this.gruposIntPadrao = bl2;
    }

    public boolean[] getVerJint() {
        return this.verJint;
    }

    public void setVerJint(boolean bl2, int n2) {
        this.verJint[n2] = bl2;
        a.SR.setVerJint(bl2, n2);
    }

    public void setVerJint(boolean[] blArray) {
        this.verJint = blArray;
        a.SR.setVerJint(blArray);
    }

    public static long getSerialversionuid() {
        return 1L;
    }

    public boolean isJogaSelecoesAll() {
        return this.jogaSelecoesAll;
    }

    public void setJogaSelecoesAll(boolean bl2) {
        this.jogaSelecoesAll = bl2;
    }

    public boolean isNegritoCasa() {
        return this.negritoCasa;
    }

    public void setNegritoCasa(boolean bl2) {
        this.negritoCasa = bl2;
        a.SR.setNegritoCasa(bl2);
    }

    public int getAutoSalvar() {
        return this.autoSalvar;
    }

    public void setAutoSalvar(int n2) {
        this.autoSalvar = n2;
        a.SR.setAutoSalvar(n2);
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int n2) {
        this.velocidade = n2;
        a.SR.setVelocidade(n2);
    }

    public int getVelocidadeNH() {
        return this.velocidadeNH;
    }

    public void setVelocidadeNH(int n2) {
        this.velocidadeNH = n2;
        a.SR.setVelocidadeNH(n2);
    }

    public int getAvisoTerminoContrato() {
        return this.avisoTerminoContrato;
    }

    public void setAvisoTerminoContrato(int n2) {
        this.avisoTerminoContrato = n2;
        a.SR.setAvisoTerminoContrato(n2);
    }

    public int getVerDecisaoPenNaoHumano() {
        return this.verDecisaoPenNaoHumano;
    }

    public void setVerDecisaoPenNaoHumano(int n2) {
        this.verDecisaoPenNaoHumano = n2;
        a.SR.setVerDecisaoPenNaoHumano(n2);
    }

    public int getVerMudancaTecnicos() {
        return this.verMudancaTecnicos;
    }

    public void setVerMudancaTecnicos(int n2) {
        this.verMudancaTecnicos = n2;
        a.SR.setVerMudancaTecnicos(n2);
    }

    public int getVerJanelaSubs() {
        return this.verJanelaSubs;
    }

    public void setVerJanelaSubs(int n2) {
        this.verJanelaSubs = n2;
        a.SR.setVerJanelaSubs(n2);
    }

    public boolean isAutoRenovaContrato() {
        return this.autoRenovaContrato;
    }

    public void setAutoRenovaContrato(boolean bl2) {
        this.autoRenovaContrato = bl2;
        a.SR.setAutoRenovaContrato(bl2);
    }

    public boolean isUsaCorPlacar() {
        return this.usaCorPlacar;
    }

    public void setUsaCorPlacar(boolean bl2) {
        this.usaCorPlacar = bl2;
        a.SR.setUsaCorPlacar(bl2);
    }

    public int getCorPlacar() {
        return this.corPlacar;
    }

    public void setCorPlacar(int n2) {
        this.corPlacar = n2;
        a.SR.setCorPlacar(n2);
    }

    public boolean isUsaSons() {
        return this.usaSons;
    }

    public void setUsaSons(boolean bl2) {
        this.usaSons = bl2;
        a.SR.setUsaSons(bl2);
    }

    public boolean isUsaCoresLista() {
        return this.usaCoresLista;
    }

    public void setUsaCoresLista(boolean bl2) {
        this.usaCoresLista = bl2;
        a.SR.setUsaCoresLista(bl2);
    }

    public boolean isVerEstaduaisAgrupados() {
        return this.verEstaduaisAgrupados;
    }

    public void setVerEstaduaisAgrupados(boolean bl2) {
        this.verEstaduaisAgrupados = bl2;
        a.SR.setVerEstaduaisAgrupados(bl2);
    }

    public Color[] getCoresLista() {
        if (this.coresLista != null) {
            return this.coresLista;
        }
        this.coresLista = new Color[5];
        this.coresLista[0] = new Color(148, 148, 73);
        this.coresLista[1] = new Color(179, 179, 100);
        this.coresLista[2] = new Color(192, 192, 129);
        this.coresLista[3] = new Color(209, 209, 163);
        this.coresLista[4] = new Color(222, 222, 188);
        return this.coresLista;
    }

    public void setCoresLista(Color[] colorArray) {
        this.coresLista = colorArray;
        a.SR.setCoresLista(colorArray);
    }

    public boolean isIgnoraLigas() {
        return this.ignoraLigas;
    }

    public void setIgnoraLigas(boolean bl2) {
        this.ignoraLigas = bl2;
        a.SR.setIgnoraLigas(bl2);
    }

    public boolean isIgnoraEstadual() {
        return this.ignoraEstadual;
    }

    public void setIgnoraEstadual(boolean bl2) {
        this.ignoraEstadual = bl2;
        a.SR.setIgnoraEstadual(bl2);
    }

    public boolean isUsarGruposReaisCopa() {
        return this.UsarGruposReaisCopa;
    }

    public void setUsarGruposReaisCopa(boolean bl2) {
        this.UsarGruposReaisCopa = bl2;
        a.SR.setUsarGruposReaisCopa(bl2);
    }

    public boolean[] getJogaRegionaisTodos() {
        return this.jogaRegionaisTodos;
    }

    public void setJogaRegionaisTodos(boolean[] blArray) {
        this.jogaRegionaisTodos = blArray;
    }

    public boolean isConviteRegionais() {
        return this.conviteRegionais;
    }

    public void setConviteRegionais(boolean bl2) {
        this.conviteRegionais = bl2;
    }

    public int getRegionaisSemHumanos() {
        return this.regionaisSemHumanos;
    }

    public void setRegionaisSemHumanos(int n2) {
        this.regionaisSemHumanos = n2;
    }

    public boolean isNovoFormatoCopa() {
        return this.novoFormatoCopa;
    }

    public void setNovoFormatoCopa(boolean bl2) {
        this.novoFormatoCopa = bl2;
    }

    public int getCorTema() {
        return this.corTema;
    }

    public void setCorTema(int n2) {
        this.corTema = n2;
    }

    public boolean isVerLeiloes() {
        return this.verLeiloes;
    }

    public void setVerLeiloes(boolean bl2) {
        this.verLeiloes = bl2;
        a.SR.setVerLeiloes(bl2);
    }
}

