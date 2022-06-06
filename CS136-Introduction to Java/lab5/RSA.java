package lab5;


/*Alenn Wright,Erin Spielman
agw73, eks98
Lab 05 rsa*/
import java.util.Random;
import java.math.BigInteger;

/**
* @author Alenn Wright, Erin Spielman
* @version 1.0
*/
public class RSA {

    /**
     * decryption key, encryption key, and the product of two primes (n) 
     */
    private BigInteger d;
    public BigInteger e;
    private BigInteger n;
    
    /**
     * Uses the RSA algorithm to generate an encryption and decryption key
     * @param bitlength 
     */
    void GenerateKeys(int bitlength) {
        Random var = new Random();
        BigInteger p = BigInteger.probablePrime(bitlength, var);
        BigInteger q = BigInteger.probablePrime(bitlength, var);
        n = p.multiply(q);
        BigInteger pminus = p.subtract(BigInteger.ONE);
        BigInteger qminus = q.subtract(BigInteger.ONE);
        BigInteger tot = ((pminus).multiply(qminus)).divide((pminus.gcd(qminus)));
        e = BigInteger.probablePrime(bitlength, var);
        while (tot.gcd(e).compareTo(BigInteger.ONE) != 0 || e.compareTo(tot) >= 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(tot);
    }
    
    /**
     * Will encrypt a number using the public encryption key
     * @param number represents the message to be encrypted
     * @return the ciphered message
     */
    public BigInteger Encrypt(BigInteger number) {
        if (e == null || n == null) {
            return null;
        } 
        else {
            BigInteger c = number.modPow(e, n);
            return c;
        }
    }

    /**
     * Will decrypt a number using the private decryption key
     * @param number represents the ciphered message to be decrypted
     * @return the decrypted message
     */
    public BigInteger Decrypt(BigInteger number) {
        if (e == null || n == null) {
            return null;
        } 
        else {
            BigInteger c = number.modPow(d, n);
            return c;
        }
    }
}
