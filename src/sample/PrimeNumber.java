package sample;

/**
 * Created by Lyaro on 22.10.2015.
 */
public class PrimeNumber implements iPrimeNumber{
    int primeNumber = 0;

    int limit;

    public int getPrimeNumber (){
        limit = 100;
        Run();
        //System.out.println(primeNumber);
        return primeNumber;
    }

    public boolean isPprime (int a){
        if (a<0)
            return false;
        else return isprime (a);
    }

    private boolean isprime(int a) {
        if (a<0)
            return false;
        int i1, i2, i3, i4, i5, i6, i7, i8, bound;
        if (a == 0 || a == 1)
            return false;
        if (a == 2 || a == 3 || a == 5 || a == 7 || a == 11 || a == 13 || a == 17 || a == 19 || a == 23 || a == 29)
            return true;
        if (a%2 == 0 || a%3 == 0 || a%5 == 0 || a%7 == 0 || a%11 == 0 || a%13 == 0 || a%17 == 0 || a%19 == 0 || a%23 == 0 || a%29 == 0)
            return false;
        bound = (int)Math.ceil(Math.sqrt((double) a));
        i1 = 31; i2 = 37; i3 = 41; i4 = 43; i5 = 47; i6 = 49; i7 = 53; i8 = 59;
        while (i8 <= bound && a%i1==0 && a%i2==0 && a%i3==0 && a%i4==0 && a%i5==0 && a%i6==0 && a%i7==0 && a%i8==0) {
            i1 += 30; i2 += 30; i3 += 30; i4 += 30; i5 += 30; i6 += 30; i7 += 30; i8 += 30;
        }
        if (i8 <= bound && a % i8 == 0 ||
                i1 <= bound && a % i1 == 0 ||
                i2 <= bound && a % i2 == 0 ||
                i3 <= bound && a % i3 == 0 ||
                i4 <= bound && a % i4 == 0 ||
                i5 <= bound && a % i5 == 0 ||
                i6 <= bound && a % i6 == 0 ||
                i7 <= bound && a % i7 == 0)
            return false;
        return true;
    }

    public void Run() {
        int number = ((int)(Math.random()*limit/2 + limit/2));
        for (int i = number; i>0; i--){
            if (isPprime(i)){
                primeNumber = i;
                break;
            }
        }
    }
}
