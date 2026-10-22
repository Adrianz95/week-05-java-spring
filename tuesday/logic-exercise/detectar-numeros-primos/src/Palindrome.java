
public class Palindrome {
    
    public boolean isPalindrome(String texto) {

        boolean isTextPalindrome = false;

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        String minusculaTexto = texto.toLowerCase();
        String textoInvertido = new StringBuilder(minusculaTexto).reverse().toString();

        if (minusculaTexto.equals(textoInvertido)) {
            isTextPalindrome = true;
        }

        return isTextPalindrome;
    }

    public void imprimirPalindrome(String texto) {
        boolean textoIsPalindrome = isPalindrome(texto.toLowerCase());
        System.out.println(texto + " - " + textoIsPalindrome);
    }

}
