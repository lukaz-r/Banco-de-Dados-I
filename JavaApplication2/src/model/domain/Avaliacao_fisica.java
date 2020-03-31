package model.domain;

import java.io.Serializable;

public class Avaliacao_fisica implements Serializable {

    private int numAvaliacao;
    private String matricula;
    private String cpf;
    private double altura;
    private String objetivoAluno;
    private double totalGordura;
    private double peso;
    private double dobraTricipical;
    private double dobraSubescapular;
    private double dobraAxiliarMedia;
    private double dobraAbdominal;
    private double dobraCoxa;
    private double dobraPeitoral;
    private double dobraSupraIliaca;
    private double circunferenciaTorax;
    private double circunferenciaQuadril;
    private double circunferenciaCintura;
    private double circunferenciaAbdomen;
    private double circunferenciaCoxaDir;
    private double circunferenciaCoxaEsq;
    private double circunferenciaBracoDir;
    private double circunferenciaBracoEsq;
    private String data;

    public Avaliacao_fisica(String matricula, String cpf, double altura, String objetivoAluno, double totalGordura, double peso, double dobraTricipical, double dobraSubescapular, double dobraAxiliarMedia, double dobraAbdominal, double dobraCoxa, double dobraPeitoral, double dobraSupraIliaca, double circunferenciaTorax, double circunferenciaQuadril, double circunferenciaCintura, double circunferenciaAbdomen, double circunferenciaCoxaDir, double circunferenciaCoxaEsq, double circunferenciaBracoDir, double circunferenciaBracoEsq) {
        super();
        this.matricula = matricula;
        this.cpf = cpf;
        this.altura = altura;
        this.objetivoAluno = objetivoAluno;
        this.totalGordura = totalGordura;
        this.peso = peso;
        this.dobraTricipical = dobraTricipical;
        this.dobraSubescapular = dobraSubescapular;
        this.dobraAxiliarMedia = dobraAxiliarMedia;
        this.dobraAbdominal = dobraAbdominal;
        this.dobraCoxa = dobraCoxa;
        this.dobraPeitoral = dobraPeitoral;
        this.dobraSupraIliaca = dobraSupraIliaca;
        this.circunferenciaTorax = circunferenciaTorax;
        this.circunferenciaQuadril = circunferenciaQuadril;
        this.circunferenciaCintura = circunferenciaCintura;
        this.circunferenciaAbdomen = circunferenciaAbdomen;
        this.circunferenciaCoxaDir = circunferenciaCoxaDir;
        this.circunferenciaCoxaEsq = circunferenciaCoxaEsq;
        this.circunferenciaBracoDir = circunferenciaBracoDir;
        this.circunferenciaBracoEsq = circunferenciaBracoEsq;
    }
    public Avaliacao_fisica(){
        
    }

    public int getNumAvaliacao() {
        return numAvaliacao;
    }

    public void setNumAvaliacao(int numAvaliacao) {
        this.numAvaliacao = numAvaliacao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getObjetivoAluno() {
        return objetivoAluno;
    }

    public void setObjetivoAluno(String objetivoAluno) {
        this.objetivoAluno = objetivoAluno;
    }

    public double getTotalGordura() {
        return totalGordura;
    }

    public void setTotalGordura(double totalGordura) {
        this.totalGordura = totalGordura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDobraTricipical() {
        return dobraTricipical;
    }

    public void setDobraTricipical(double dobraTricipical) {
        this.dobraTricipical = dobraTricipical;
    }

    public double getDobraSubescapular() {
        return dobraSubescapular;
    }

    public void setDobraSubescapular(double dobraSubescapular) {
        this.dobraSubescapular = dobraSubescapular;
    }

    public double getDobraAxiliarMedia() {
        return dobraAxiliarMedia;
    }

    public void setDobraAxiliarMedia(double dobraAxiliarMedia) {
        this.dobraAxiliarMedia = dobraAxiliarMedia;
    }

    public double getDobraAbdominal() {
        return dobraAbdominal;
    }

    public void setDobraAbdominal(double dobraAbdominal) {
        this.dobraAbdominal = dobraAbdominal;
    }

    public double getDobraCoxa() {
        return dobraCoxa;
    }

    public void setDobraCoxa(double dobraCoxa) {
        this.dobraCoxa = dobraCoxa;
    }

    public double getDobraPeitoral() {
        return dobraPeitoral;
    }

    public void setDobraPeitoral(double dobraPeitoral) {
        this.dobraPeitoral = dobraPeitoral;
    }

    public double getDobraSupraIliaca() {
        return dobraSupraIliaca;
    }

    public void setDobraSupraIliaca(double dobraSupraIliaca) {
        this.dobraSupraIliaca = dobraSupraIliaca;
    }

    public double getCircunferenciaTorax() {
        return circunferenciaTorax;
    }

    public void setCircunferenciaTorax(double circunferenciaTorax) {
        this.circunferenciaTorax = circunferenciaTorax;
    }

    public double getCircunferenciaQuadril() {
        return circunferenciaQuadril;
    }

    public void setCircunferenciaQuadril(double circunferenciaQuadril) {
        this.circunferenciaQuadril = circunferenciaQuadril;
    }

    public double getCircunferenciaCintura() {
        return circunferenciaCintura;
    }

    public void setCircunferenciaCintura(double circunferenciaCintura) {
        this.circunferenciaCintura = circunferenciaCintura;
    }

    public double getCircunferenciaAbdomen() {
        return circunferenciaAbdomen;
    }

    public void setCircunferenciaAbdomen(double circunferenciaAbdomen) {
        this.circunferenciaAbdomen = circunferenciaAbdomen;
    }

    public double getCircunferenciaCoxaDir() {
        return circunferenciaCoxaDir;
    }

    public void setCircunferenciaCoxaDir(double circunferenciaCoxaDir) {
        this.circunferenciaCoxaDir = circunferenciaCoxaDir;
    }

    public double getCircunferenciaCoxaEsq() {
        return circunferenciaCoxaEsq;
    }

    public void setCircunferenciaCoxaEsq(double circunferenciaCoxaEsq) {
        this.circunferenciaCoxaEsq = circunferenciaCoxaEsq;
    }

    public double getCircunferenciaBracoDir() {
        return circunferenciaBracoDir;
    }

    public void setCircunferenciaBracoDir(double circunferenciaBracoDir) {
        this.circunferenciaBracoDir = circunferenciaBracoDir;
    }

    public double getCircunferenciaBracoEsq() {
        return circunferenciaBracoEsq;
    }

    public void setCircunferenciaBracoEsq(double circunferenciaBracoEsq) {
        this.circunferenciaBracoEsq = circunferenciaBracoEsq;
    }
}

