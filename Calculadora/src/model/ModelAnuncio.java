package model;
/**
*
* @author Ariadna Morais
*/
public class ModelAnuncio {

    private int anuncId;
    private String anuDescricao;
    private String anuCliente;
    private double anuValinvest;
    private double anuDateinicio;
    private double anuDatefim;
    private double anuValtotalinvest;
    private double anuQtdmaxvisu;
    private double anuQtdmaxcliq;
    private double anuQtdmaxcompt;

    /**
    * Construtor
    */
    public ModelAnuncio(){}

    /**
    * seta o valor de anuncId
    * @param pAnuncId
    */
    public void setAnuncId(int pAnuncId){
        this.anuncId = pAnuncId;
    }
    /**
    * @return pk_anuncId
    */
    public int getAnuncId(){
        return this.anuncId;
    }

    /**
    * seta o valor de anuDescricao
    * @param pAnuDescricao
    */
    public void setAnuDescricao(String pAnuDescricao){
        this.anuDescricao = pAnuDescricao;
    }
    /**
    * @return anuDescricao
    */
    public String getAnuDescricao(){
        return this.anuDescricao;
    }

    /**
    * seta o valor de anuCliente
    * @param pAnuCliente
    */
    public void setAnuCliente(String pAnuCliente){
        this.anuCliente = pAnuCliente;
    }
    /**
    * @return anuCliente
    */
    public String getAnuCliente(){
        return this.anuCliente;
    }

    /**
    * seta o valor de anuValinvest
    * @param pAnuValinvest
    */
    public void setAnuValinvest(double pAnuValinvest){
        this.anuValinvest = pAnuValinvest;
    }
    /**
    * @return anuValinvest
    */
    public double getAnuValinvest(){
        return this.anuValinvest;
    }

    /**
    * seta o valor de anuDateinicio
    * @param pAnuDateinicio
    */
    public void setAnuDateinicio(double pAnuDateinicio){
        this.anuDateinicio = pAnuDateinicio;
    }
    /**
    * @return anuDateinicio
    */
    public double getAnuDateinicio(){
        return this.anuDateinicio;
    }

    /**
    * seta o valor de anuDatefim
    * @param pAnuDatefim
    */
    public void setAnuDatefim(double pAnuDatefim){
        this.anuDatefim = pAnuDatefim;
    }
    /**
    * @return anuDatefim
    */
    public double getAnuDatefim(){
        return this.anuDatefim;
    }

    /**
    * seta o valor de anuValtotalinvest
    * @param pAnuValtotalinvest
    */
    public void setAnuValtotalinvest(double pAnuValtotalinvest){
        this.anuValtotalinvest = pAnuValtotalinvest;
    }
    /**
    * @return anuValtotalinvest
    */
    public double getAnuValtotalinvest(){
        return this.anuValtotalinvest;
    }

    /**
    * seta o valor de anuQtdmaxvisu
    * @param pAnuQtdmaxvisu
    */
    public void setAnuQtdmaxvisu(double pAnuQtdmaxvisu){
        this.anuQtdmaxvisu = pAnuQtdmaxvisu;
    }
    /**
    * @return anuQtdmaxvisu
    */
    public double getAnuQtdmaxvisu(){
        return this.anuQtdmaxvisu;
    }

    /**
    * seta o valor de anuQtdmaxcliq
    * @param pAnuQtdmaxcliq
    */
    public void setAnuQtdmaxcliq(double pAnuQtdmaxcliq){
        this.anuQtdmaxcliq = pAnuQtdmaxcliq;
    }
    /**
    * @return anuQtdmaxcliq
    */
    public double getAnuQtdmaxcliq(){
        return this.anuQtdmaxcliq;
    }

    /**
    * seta o valor de anuQtdmaxcompt
    * @param pAnuQtdmaxcompt
    */
    public void setAnuQtdmaxcompt(double pAnuQtdmaxcompt){
        this.anuQtdmaxcompt = pAnuQtdmaxcompt;
    }
    /**
    * @return anuQtdmaxcompt
    */
    public double getAnuQtdmaxcompt(){
        return this.anuQtdmaxcompt;
    }

    @Override
    public String toString(){
        return "ModelAnuncio {" + "::anuncId = " + this.anuncId + "::anuDescricao = " + this.anuDescricao + "::anuCliente = " + this.anuCliente + "::anuValinvest = " + this.anuValinvest + "::anuDateinicio = " + this.anuDateinicio + "::anuDatefim = " + this.anuDatefim + "::anuValtotalinvest = " + this.anuValtotalinvest + "::anuQtdmaxvisu = " + this.anuQtdmaxvisu + "::anuQtdmaxcliq = " + this.anuQtdmaxcliq + "::anuQtdmaxcompt = " + this.anuQtdmaxcompt +  "}";
    }
}