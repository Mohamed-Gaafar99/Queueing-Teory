
package compelet_programe;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class MM1K_CLASS extends Model {
    double lamda;
    double mu;
    double ro = (lamda/mu);
    int k ;
    double Lq, L ,W, Wq, P0 ;
    public double initial_probabelity(){
        double expond = (1 - ro);
        double status = 1-(Math.pow(ro, k+1));
        P0 = expond/status;
        return P0;
    }
    public double probabelity(int value){
        double Pk=0;
        if( ro==1){
           Pk= 1/(1+k);
        }else {
            Pk = (Math.pow(ro, value))*initial_probabelity();
        }
        return Pk ; 
    }
    public double Nu_Of_Customer_In_System(){
        if(ro!=1){
            double sum1= (k+1)*(Math.pow(ro, k));
            double sum2= k*(Math.pow(ro, k+1));
            double expond=(1-sum1+sum2);
            double mult=(1-ro)*(1-(Math.pow(ro, k+1)));
            double div = (expond/mult);
            L = ro*div;
        }else{
            L = k/2;
        }
        return L;
    }  
    public double Nu_Of_Customer_in_Queue(){
        double lamda_dash = lamda*(1-probabelity(k));
        Lq = lamda_dash * Waiting_Time_In_Queue();
        return Lq;
    }
    public double Waiting_Time_In_System(){
        double lamda_dash = lamda*(1-probabelity(k));
        double W =Nu_Of_Customer_In_System()/lamda_dash;
        return W;
    }
    public double Waiting_Time_In_Queue(){
        
        double Wq =Waiting_Time_In_System()-(1/mu);
        return Wq;
    } 
}
