/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compelet_programe;

import static compelet_programe.MMCK_CLASS.factorial;
import static compelet_programe.MMC_CLASS.factorial;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.Global.Infinity;

public class Model {
double lamda ; 
double mu; 
int     t ; 
int    cap; 
double r = (lamda/mu);
double ro = (r/cap);
int    k ; 
double Lq, L ,W, Wq;
    public Model() {
    }
public double valid(String value){
        double ob=0;       
    ScriptEngineManager sa =new ScriptEngineManager();
    ScriptEngine saa = sa.getEngineByName("javascript");
    //   ssa دى تشيرالى سواح   
     try{     
    try{
        ob = (double)saa.eval(value);
     
    }
    catch(Exception e){
        ob= (int)saa.eval(value);
        }
}        
     catch (Exception e) {
      // JOptionPane.showMessageDialog(null,"Ops your Entery is Ronge","ERROR",JOptionPane.ERROR_MESSAGE);
}
   if(ob>=Infinity){
       JOptionPane.showMessageDialog(null,"divide by zero not convient","ERROR",JOptionPane.ERROR_MESSAGE);
   return ob =0;
     }else{
      
return ob;
   }  
    }
 
 public static int factorial( int numero ) {
            int fact = 1;
            for( int i = 1; i <= numero; i++ ) {
            fact *= i;
        }
        return fact;
     
    }
    public  double segma(double r){
        double calc =0 ;
        double ans =0;
        for(int i=0 ;i<= cap-1 ; i++){
            calc = Math.pow(r, i)/factorial(i);
            ans = calc + ans;
        }
        return ans ;
    }
    
   
    }


