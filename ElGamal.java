import java.util.*;
class ElGamal
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the prime number: ");
        int q=obj.nextInt();
        System.out.println("Enter the generator: ");
        int a=obj.nextInt();
        System.out.println("Enter the private key value: ");
        int x=obj.nextInt();
        System.out.println("Enter the message: ");
        int m=obj.nextInt();
        int c1=0,c2=0;
        if(x<=1 && x>=(q-1))
        {
            System.out.println("Invalid private key entered");
        }
        else
        {
            int y=(int)(Math.pow(a,x)%q); 
            System.out.println("Public key: "+y);
            System.out.println("Enter the random key value: ");
            int k=obj.nextInt();
            if(k<1 && k>(q-1))
            {
                System.out.println("Invalid key entered");
            }
            else
            {
                int k1=(int)(Math.pow(y,k)%q);
                System.out.println("The K dash value is: "+k1);
                System.out.println("Now we perform encryption: ");
                c1=(int)(Math.pow(a,k)%q);
                c2=(int)((k1*m)%q);
                System.out.println("Encryption: ("+c1+","+c2+")");
                System.out.println("Now we perform decryption: ");
                int k2=(int)(Math.pow(c1,x)%q);
                System.out.println("The K value after decryption: "+k2);
                int i=multiplicative_inverse(k2,q,0,1);
                System.out.println("The multiplicative inverse: "+i);
                if(i<0)
                {
                    i=i+q;
                }
                int m1=(int)((c2*i)%q);
                System.out.println("Decrypted message: "+m1);
            }
        }
    }
    public static int multiplicative_inverse(int n, int p, int t1, int t2) 
    {
        int q = (int)Math.floor(p / n);
        int r = p % n;
        int t = t1 - (t2 * q);
        if (r != 0) 
        {
            return multiplicative_inverse(r, n, t2, t);
        }
        return t2;
    }
}
