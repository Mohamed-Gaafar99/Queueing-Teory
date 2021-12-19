
package compelet_programe;


public class MMCK_CLASS extends Model{
    double lamda;
    double mu;
    int c ;
    double r = (lamda/mu);
    double ro = (r/c);
    int k ;
    double Lq ;
    double L ;

//    }
    public static int factorial( int numero ) {
            int fact = 1;
            for( int i = 1; i <= numero; i++ ) {
            fact *= i;
        }
        return fact;
    }
    
    public  double segma(){
        double calc =0 ;
        double ans =0;
        for(int i=0 ;i<= c-1 ; i++){
            calc = Math.pow(r, i)/factorial(i);
            ans = calc + ans;
        }
        return ans ;
    }
    
    public  double Segma_System(){
        double s_calc;
        double s_ans=0;
        for(int i=0; i<=c-1 ; i++){  
            s_calc = (((c-i)*(Math.pow(r, i))/factorial(i)));
            s_ans = s_ans + s_calc ;
        }
        return s_ans ;
    }
    public double initial_probabelity(){
        double P0;
        if(ro!= 1){
            double div = (Math.pow(r, c))/factorial(c);
            double power_ro = Math.pow(ro, (k-c+1));
            double div_ro = (1-power_ro)/(1-ro);
            P0 =segma() + (div*div_ro);
        }else{
            double div = (Math.pow(r, c))/factorial(c);
            double mult = (k)-(c)+1;
            P0 = segma()+div*mult;
        }
        return 1/P0;
    }
    public double probabelity(int value){
        double Pk=0;
        if( value>=0 && value< c){
           double div = (Math.pow(r,value))/factorial(value);
           Pk=div*initial_probabelity();
        }else {
            double status = (Math.pow(c,value-c))*factorial(c);
            double div = (Math.pow(r, value))/status;
            Pk = div * initial_probabelity();
        }
        return Pk ; 
    }
    public double Nu_Of_Customer_In_Queue(){
        double expand = (ro *(Math.pow(r, c))*initial_probabelity());
        double status = factorial(c)*(Math.pow((1-ro), 2));
        double frist_term = 1-(Math.pow(ro, (k-c+1)));
        double second_term = (1-ro)*(k-c+1)*(Math.pow(ro,k-c));
        double Lq = (expand/status)*(frist_term-second_term);
        return Lq;
    }  
    public double Nu_Of_customer_in_System(){
        double colletion_sumition = (initial_probabelity()*Segma_System());
        double L = Nu_Of_Customer_In_Queue()+(c)-(colletion_sumition);
        return L;
    }
    public double Waiting_Time_In_System(){
        double lamda_dash = lamda*(1-probabelity(k));
        double W =Nu_Of_customer_in_System()/lamda_dash;
        return W;
    }
    public double Waiting_Time_In_Queue(){
        double lamda_dash = lamda*(1-probabelity(k));
        double Wq =Nu_Of_Customer_In_Queue()/lamda_dash;
        return Wq;
    }  
}
