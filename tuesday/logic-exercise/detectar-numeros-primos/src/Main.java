
public class Main {
    public static void main(String[] args) {

        SumaDigitos numero = new SumaDigitos();
        
        numero.imprimirSumaDigitos(472);
        numero.imprimirSumaDigitos(9005);
        numero.imprimirSumaDigitos(0);

        Palindrome texto = new Palindrome();

        texto.imprimirPalindrome("RadAr");
        texto.imprimirPalindrome("Java");
        texto.imprimirPalindrome("reconocER");
        texto.imprimirPalindrome(null);

    }
}
