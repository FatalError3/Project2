package sample;

/**
 * Created by Lyaro on 22.10.2015.
 */
class Keygen implements Runnable, iKeygen {
    int D;
    int E;
    int N;

    Thread t;

    public Keygen (){
        t = new Thread(this);
        t.start();
    }

    public String[] generation (){
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String keyE = Integer.toString(E) + " " + Integer.toString(N);
        String keyD = Integer.toString(D) + " " + Integer.toString(N);
        return new String [] {keyE, keyD};
    }

    @Override
    public void run() {
        PrimeNumber p = new PrimeNumber();
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
