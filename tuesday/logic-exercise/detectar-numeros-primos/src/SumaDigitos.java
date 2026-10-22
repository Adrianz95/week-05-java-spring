
public class SumaDigitos {

    public int sumaTotalDigitos(int numero) {

        if (numero < 0) {
            throw new Error("Debe de ser un número positivo.");
        }

        String textoDigito = String.valueOf(numero);
        String[] listaDigitos = textoDigito.split("");
        int suma = 0;

        for (String digito : listaDigitos) {
            suma += Integer.parseInt(digito);
        }

        return suma;

    }

    public void imprimirSumaDigitos(int numero) {
        int suma = sumaTotalDigitos(numero);
        System.out.println("La suma es: " + suma);
    }

}
