/*
*Clase para realizar las pruebas unitarias del programa
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.regresioncorrelacion;

import java.text.DecimalFormat;
import junit.framework.TestCase;

public class AppTest extends TestCase{
    
    DecimalFormat df = new DecimalFormat("#.####");
 
    public void testDatos1(){
        HallarValores valores = new HallarValores(HallarValores.datos1());
        assertTrue( df.format(valores.getB0()).equals("-22,5525") );
        assertTrue( df.format(valores.getB1()).equals("1,7279") );
        assertTrue( df.format(valores.getRxy()).equals("0,9545") );
        assertTrue( df.format(valores.getR2()).equals("0,9111")  );
        assertTrue( df.format(valores.getYk()).equals("644,4294") );
    }
    
    public void testDatos2(){
        HallarValores valores = new HallarValores(HallarValores.datos2());
        assertTrue( df.format(valores.getB0()).equals("-4,0389") );
        assertTrue( df.format(valores.getB1()).equals("0,1681") );
        assertTrue( df.format(valores.getRxy()).equals("0,9333") );
        assertTrue( df.format(valores.getR2()).equals("0,8711")  );
        assertTrue( df.format(valores.getYk()).equals("60,858") );
    }
    
    public void testDatos3(){
        HallarValores valores = new HallarValores(HallarValores.datos3());
        assertTrue( df.format(valores.getB0()).equals("-23,9239") );
        assertTrue( df.format(valores.getB1()).equals("1,431") );
        assertTrue( df.format(valores.getRxy()).equals("0,9631") );
        assertTrue( df.format(valores.getR2()).equals("0,9276")  );
        assertTrue( df.format(valores.getYk()).equals("528,4294") );
    }
    
    public void testDatos4(){
        HallarValores valores = new HallarValores(HallarValores.datos4());
        assertTrue( df.format(valores.getB0()).equals("-4,6037") );
        assertTrue( df.format(valores.getB1()).equals("0,1402") );
        assertTrue( df.format(valores.getRxy()).equals("0,948") );
        assertTrue( df.format(valores.getR2()).equals("0,8988")  );
        assertTrue( df.format(valores.getYk()).equals("49,4994") );
    }
    
}