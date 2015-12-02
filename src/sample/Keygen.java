package sample;

/**
 * Created by Lyaro on 22.10.2015.
 */
public class Keygen implements iKeygen {
    int D;
    int E;
    int N;

    PrimeNumber p;

    public Keygen (){
        p = new PrimeNumber ();
        Run();
    }

    public Keygen (PrimeNumber primeNumber){
        p = primeNumber;
        Run();
    }

    public String[] generation (){
        String keyE = Integer.toString(E) + " " + Integer.toString(N);
        String keyD = Integer.toString(D) + " " + Integer.toString(N);
        return new String [] {keyE, keyD};
    }

    public void Run () {
        int P = p.getPrimeNumber(), Q = p.getPrimeNumber();
        N = P * Q;
        int fN = (P - 1) * (Q - 1);
        int i = fN;
        while (true) {
            i--;
            if ((gcd(i, fN)==1 && (fN+1)%i==0)||i==1)
                break;
        }
        D=i;
        E = (fN + 1) / D;
        //System.out.println(i);
    }

    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
