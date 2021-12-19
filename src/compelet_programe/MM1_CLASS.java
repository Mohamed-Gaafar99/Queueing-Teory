
package compelet_programe;



public class MM1_CLASS extends Model {
    double lamda;
    double mu;
    double ro = (lamda/mu);
    double Lq, L ,W, Wq, P0 ;

    public double initial_probabelity(){
        P0 = (1 - ro);// بروبابيلتلا عميل 0
        return P0;
    }
    
    public double Number_of_Customer_In_System(){
        double l = (lamda)/(mu - lamda);
        L = Math.ceil(l);// تقريب 
        return L;
    }
    
    public double Number_of_Customer_In_Queue(){
        Lq = (lamda/mu)*(Number_of_Customer_In_System());
        return Lq;
    }
    public double waiting_in_System(){
        W = 1/(mu-lamda);
        return W;
    }
    
    public double Waiting_in_Queue(){
        Wq = Number_of_Customer_In_System()*(1/mu);
        return Wq ;
    }
    
}
