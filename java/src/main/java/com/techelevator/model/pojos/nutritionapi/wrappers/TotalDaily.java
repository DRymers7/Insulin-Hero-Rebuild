package com.techelevator.model.pojos.nutritionapi.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.pojos.nutritionapi.nutrientInfo.*;

public class TotalDaily {

    @JsonProperty("ENERC_KCAL")
    private ENERC_KCAL enerc_kcal;
    @JsonProperty("FAT")
    private FAT fat;
    @JsonProperty("FASAT")
    private FASAT fasat;
    @JsonProperty("CHOCDF")
    private CHOCDF chocdf;
    @JsonProperty("FIBTG")
    private FIBTG fibtg;
    @JsonProperty("PROCNT")
    private PROCNT procnt;
    @JsonProperty("CHOLE")
    private CHOLE chole;
    @JsonProperty("NA")
    private NA na;
    @JsonProperty("CA")
    private CA ca;
    @JsonProperty("MG")
    private MG mg;
    @JsonProperty("K")
    private K k;
    @JsonProperty("FE")
    private FE fe;
    @JsonProperty("ZN")
    private ZN zn;
    @JsonProperty("P")
    private P p;
    @JsonProperty("VITARAE")
    private VITARae vitaRae;
    @JsonProperty("VITC")
    private VITc viTc;
    @JsonProperty("THIA")
    private THIA thia;
    @JsonProperty("RIBF")
    private RIBF ribf;
    @JsonProperty("NIA")
    private NIA nia;
    @JsonProperty("VITB6A")
    private VITB6A vitb6A;
    @JsonProperty("FOLDFE")
    private FOLDFE foldfe;
    @JsonProperty("VITB12")
    private VITB12 vitb12;
    @JsonProperty("VITD")
    private VITD vitd;
    @JsonProperty("TOPCHA")
    private TOPCHA topcha;
    @JsonProperty("VITK1")
    private VITK1 vitk1;

    public TotalDaily() {};

    public ENERC_KCAL getEnerc_kcal() {
        return enerc_kcal;
    }

    public void setEnerc_kcal(ENERC_KCAL enerc_kcal) {
        this.enerc_kcal = enerc_kcal;
    }

    public FAT getFat() {
        return fat;
    }

    public void setFat(FAT fat) {
        this.fat = fat;
    }

    public FASAT getFasat() {
        return fasat;
    }

    public void setFasat(FASAT fasat) {
        this.fasat = fasat;
    }

    public CHOCDF getChocdf() {
        return chocdf;
    }

    public void setChocdf(CHOCDF chocdf) {
        this.chocdf = chocdf;
    }

    public FIBTG getFibtg() {
        return fibtg;
    }

    public void setFibtg(FIBTG fibtg) {
        this.fibtg = fibtg;
    }

    public PROCNT getProcnt() {
        return procnt;
    }

    public void setProcnt(PROCNT procnt) {
        this.procnt = procnt;
    }

    public CHOLE getChole() {
        return chole;
    }

    public void setChole(CHOLE chole) {
        this.chole = chole;
    }

    public NA getNa() {
        return na;
    }

    public void setNa(NA na) {
        this.na = na;
    }

    public CA getCa() {
        return ca;
    }

    public void setCa(CA ca) {
        this.ca = ca;
    }

    public MG getMg() {
        return mg;
    }

    public void setMg(MG mg) {
        this.mg = mg;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public FE getFe() {
        return fe;
    }

    public void setFe(FE fe) {
        this.fe = fe;
    }

    public ZN getZn() {
        return zn;
    }

    public void setZn(ZN zn) {
        this.zn = zn;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }

    public VITARae getVitaRae() {
        return vitaRae;
    }

    public void setVitaRae(VITARae vitaRae) {
        this.vitaRae = vitaRae;
    }

    public VITc getViTc() {
        return viTc;
    }

    public void setViTc(VITc viTc) {
        this.viTc = viTc;
    }

    public THIA getThia() {
        return thia;
    }

    public void setThia(THIA thia) {
        this.thia = thia;
    }

    public RIBF getRibf() {
        return ribf;
    }

    public void setRibf(RIBF ribf) {
        this.ribf = ribf;
    }

    public NIA getNia() {
        return nia;
    }

    public void setNia(NIA nia) {
        this.nia = nia;
    }

    public VITB6A getVitb6A() {
        return vitb6A;
    }

    public void setVitb6A(VITB6A vitb6A) {
        this.vitb6A = vitb6A;
    }

    public FOLDFE getFoldfe() {
        return foldfe;
    }

    public void setFoldfe(FOLDFE foldfe) {
        this.foldfe = foldfe;
    }

    public VITB12 getVitb12() {
        return vitb12;
    }

    public void setVitb12(VITB12 vitb12) {
        this.vitb12 = vitb12;
    }

    public VITD getVitd() {
        return vitd;
    }

    public void setVitd(VITD vitd) {
        this.vitd = vitd;
    }

    public TOPCHA getTopcha() {
        return topcha;
    }

    public void setTopcha(TOPCHA topcha) {
        this.topcha = topcha;
    }

    public VITK1 getVitk1() {
        return vitk1;
    }

    public void setVitk1(VITK1 vitk1) {
        this.vitk1 = vitk1;
    }
}
