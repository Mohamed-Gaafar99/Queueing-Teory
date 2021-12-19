package compelet_programe;

public class DD1k extends Model {
  public double t =0;
  public double lmda;
  public double mu;
  public double n ;
  double k;
   public double ti;
   double AT;
   double ST;
   double Wq;
double Wq2;
 double M=0;
     public double Time_case_1() {
        double exponed =  ((k*(1/mu)*(1/lmda)) - Math.pow((1/lmda), 2));
        ti = exponed/((1/mu)-(1/lmda)); 
        for (int i = 0; i <= ti; i++) {
            double sub =((i-(1/lmda))/(1/mu));
            int V = (int) (lmda * i); 
            int F = (int) (sub); 
            int U = V - F;
            if (k == U) {
                ti = i;
                break;
            }
       }
       return ti;
    }
     public double Number_Of_Customer(){
         double sub = (mu * t) - (mu / lmda);
        int F = (int) (sub); //look line 60
        int V = (int) (lmda * t); // look line 60
        n = V - F;
        return  n;
     }
    public double Number_case_1() {

        AT = 1 / lmda; 
        ti =  Time_case_1(); 
        if((lmda%mu==0)){
            if (t < AT) {
               n = 0;
            } else if (t >= AT && t < ti) {
                int F = (int) ((mu * t) - (mu / lmda)); 
                int V = (int) (lmda * t);
            n = V - F;
            } else if (t >= ti) {
                n = k - 1;
            }
            return  n;
        }
        if (t < AT) {
            n = 0;
        }
        else if (t >= AT && t < ti) {
int F = (int) ((mu * t) - (mu / lmda)); //look line 60
int V = (int) (lmda * t); // look line 60
n = V - F;
} else if (t >= ti&&t<ti+2) {
n = k - 1;
}else if(t>=ti+2&&t>ti+4){
      n=k-2;  
    }
return  n;
}
public double Wating_Time_case_1() {
AT = 1 / lmda; // arrival time funtional in the arrival rate
ST =1/mu; // service time funtional in the service rate

ti =(int) Time_case_1(); // find the time of occurrence of the first balk (ti)
n = Number_case_1(); //find the number in the system at time (t) including the customer in service.
if (n == 0) {
Wq = 0;
} else if (n < lmda * ti) {
Wq = (ST - AT) * (n - 1);
} else if (n >= lmda * ti) {
Wq = (ST - AT) * (lmda * ti - 2);
Wq2 = (ST - AT) * (lmda * ti - 3);
return Wq2;
}
return Wq;
} 
  public double Time_case_2() {

ti =  ((M) / (mu - lmda)); // the M : initial customers
for (int i = 0; i <= ti; i++) {

int v = (int) (lmda * i); //caluclat the firt part from eqution in line 110 look at line 110
int f = (int) (mu * i); //caluclat the secnod part from eqution in line 110 look at line 111
double u =(int) (M + v - f); // totol eqution
if (u == 0) {
// the condition M=u frome the eqution in line 110 N(t)= 0 the M=(L*Ti)-(µ*Ti)
ti = i; // first values Ti forme the Loop
//Model1.java
//2
break; // Out the Loop
}
}
return ti;
}
  public double  case2_graph(int time ){
if (ti == 0 && lmda == mu) {
// arrival rate less than services rate and T less than Ti
n = M; //look line 136
} else if (time< ti) {
int V = (int) (lmda * time); //caluclat the firt part from eqution in line 110 look at line
//110
int U = (int) (mu * time); //caluclat the secnod part from eqution in line 110 look at
//line 111
n = M + V - U; // Total eqution look line 134
} else if (time >= ti) {
if (time < ti + 2) {
n = 0;
} else if (ti + 2 <= time && time < ti + 3) {
n = 1;
}
}
return n; 
}      
  
 public double Number_case_2() {

if (ti == 0 && lmda == mu) {
// arrival rate less than services rate and T less than Ti
n = M; //look line 136
} else if (t< ti) {
int V = (int) (lmda * t); //caluclat the firt part from eqution in line 110 look at line
//110
int U = (int) (mu * t); //caluclat the secnod part from eqution in line 110 look at
//line 111
n = M + V - U; // Total eqution look line 134
} else if (t >= ti) {
if (t < ti + 2) {
n = 0;
} else if (ti + 2 <= t && t < ti + 3) {
n = 1;
}
}
return n; 
}
 
 public double Wating_Time_case_2() {
AT = 1 / lmda; // arrival time funtional in the arrival rate
ST = 1 / mu; // service time funtional in the service rate

ti = (int) Time_case_2();
n = Number_case_2();
int Q = (int) (lmda * ti); // Look at line 171
if (n == 0) {
//Model1.java
//3
Wq = (M - 1) / (2 * mu);
} else if (n <= Q) {
Wq = ((M - 1 + n) * ST) - (n * AT);
} else if (n > Q) {
Wq = 0;
} else if (lmda == mu) {
Wq = (M - 1) * (1 / mu);
}
return Wq;
}

}

  

