
package compelet_programe;


public class MMC_CLASS extends Model {
    double lamda;
    double mu;
    int c ;
    double r = (lamda/mu);
    double ro = (r/c);
    int k ;
    double Lq, L ,W, Wq ;
    public double segma_System(){
        double calc =0 ;
        double ans =0;
        for(int i=0 ;i<= c-1 ; i++){
            calc = Math.pow(r, i)/factorial(i);
            ans = calc + ans;
        }return ans ;
    }
    
    public double initial_probabelity(){
        double P0=0;
        if(ro<1){
            double expand = c*(Math.pow(r, c));
            double status = factorial(c)*(c-r);
            P0 = segma(r)+(expand/status);
        }else{
            
            double div1 =(Math.pow(r, c))/factorial(c);
            double div2 = (c*mu)/((c*mu)-lamda);
            P0 = segma_System()+(div1*div2);
        }return 1/P0;
    }
    
    public double Number_of_Customer_In_Queue(){
        double expond = (Math.pow(r, c))*(lamda)*(mu);
        double sub = (c*mu)-lamda ;
        double status = (factorial(c-1))*(Math.pow(sub, 2));
        Lq = (expond/(status))*initial_probabelity();
        return Lq;
    }
    
    
    public double Number_of_Customer_In_System(){
       L = Number_of_Customer_In_Queue()+r;
       return L;
    }
    
    public double waiting_in_System(){
        W = (Number_of_Customer_In_Queue()/lamda)+(1/lamda);
        return W;
    }
    
    public double Waiting_in_Queue(){
        Wq = Number_of_Customer_In_Queue()/lamda;
        return Wq ;
    }
}
