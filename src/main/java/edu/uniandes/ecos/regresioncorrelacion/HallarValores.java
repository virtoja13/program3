/*
*Clase para realizar las distintas operaciones que se realizan parar hallar la regresion y la correlacion
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.regresioncorrelacion;

import java.util.ArrayList;
 
public class HallarValores{
    
    private double avgX = 0.0;
    private double avgY = 0.0;
    private double sumX = 0.0;//sumatoria de los x
    private double sumY = 0.0;//sumatoria de los y
    private double sumX2 = 0.0;//sumatoria de los x al cuadrado
    private double sumY2 = 0.0;//sumatoria de los y al cuadrado
    private double sumXY = 0.0;
    private double B1 = 0.0;
    private double B0 = 0.0;
    private double rxy = 0.0;
    private double r2 = 0.0;
    private double Yk = 0.0;
    
    private static final int Xk = 386;
    
    public static ArrayList<Data> datos1(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(130,186));
        listaDatos.add(new Data(650,699));
        listaDatos.add(new Data(99,132));
        listaDatos.add(new Data(150,272));
        listaDatos.add(new Data(128,291));
        listaDatos.add(new Data(302,331));
        listaDatos.add(new Data(95,199));
        listaDatos.add(new Data(945,1890));
        listaDatos.add(new Data(368,788));
        listaDatos.add(new Data(961,1601));
        return listaDatos; 
    }
    

    public static ArrayList<Data> datos2(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(130.0,15.0));
        listaDatos.add(new Data(650.0,69.9));
        listaDatos.add(new Data(99.0,6.5));
        listaDatos.add(new Data(150.0,22.4));
        listaDatos.add(new Data(128.0,28.4));
        listaDatos.add(new Data(302.0,65.9));
        listaDatos.add(new Data(95.0,19.4));
        listaDatos.add(new Data(945.0,198.7));
        listaDatos.add(new Data(368.0,38.8));
        listaDatos.add(new Data(961.0,138.2));
        return listaDatos;
    }

    public static ArrayList<Data> datos3(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(163,186));
        listaDatos.add(new Data(765,699));
        listaDatos.add(new Data(141,132));
        listaDatos.add(new Data(166,272));
        listaDatos.add(new Data(137,291));
        listaDatos.add(new Data(355,331));
        listaDatos.add(new Data(136,199));
        listaDatos.add(new Data(1206,1890));
        listaDatos.add(new Data(433,788));
        listaDatos.add(new Data(1130,1601));
        return listaDatos;
    }

    public static ArrayList<Data> datos4(){
        ArrayList<Data> listaDatos = new ArrayList<Data>();
        listaDatos.add(new Data(163,15.0));
        listaDatos.add(new Data(765,69.9));
        listaDatos.add(new Data(141,6.5));
        listaDatos.add(new Data(166,22.4));
        listaDatos.add(new Data(137,28.4));
        listaDatos.add(new Data(355,65.9));
        listaDatos.add(new Data(136,19.4));
        listaDatos.add(new Data(1206,198.7));
        listaDatos.add(new Data(433,38.8));
        listaDatos.add(new Data(1130,138.2));
        return listaDatos;
    }
    
    public HallarValores(ArrayList<Data> datos){
        for(Data dato: datos){
            sumX += dato.getX();	
            sumY += dato.getY();
            sumX2 += dato.getX()*dato.getX();	
            sumY2 += dato.getY()*dato.getY();
            sumXY += dato.getX()*dato.getY();
        }
	avgX = sumX/datos.size();
	avgY = sumY/datos.size();
        //Regresion
        B1 = ((sumXY)-(datos.size()*avgX*avgY))/(sumX2-(datos.size()*avgX*avgX));
        B0 = avgY - (B1*avgX);
        //Correlacion
        rxy = ((datos.size()*sumXY)-(sumX*sumY))/Math.sqrt(((datos.size()*sumX2)-(sumX*sumX))*((datos.size()*sumY2)-(sumY*sumY)));
        r2 = rxy*rxy;
        Yk = B0 + (B1*Xk);
    }

    public double getB1() {
        return B1;
    }

    public double getB0() {
        return B0;
    }

    public double getRxy() {
        return rxy;
    }

    public double getR2() {
        return r2;
    }

    public double getYk() {
        return Yk;
    }

}