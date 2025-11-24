import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una password da valutare: ");
        String password = scanner.nextLine();

        int punteggio = calcolaPunteggio(password);
        String livello = valutaLivello(punteggio);

        System.out.println("\n🔐 Risultato");
        System.out.println("Sicurezza password: " + livello + " (" + punteggio + "/5)");
    }

    private static int calcolaPunteggio(String password) {
        int score = 0;

        if (password.length() >= 8) score++;                // Lunghezza
        if (password.matches(".*[A-Z].*")) score++;         // Maiuscole
        if (password.matches(".*[a-z].*")) score++;         // Minuscole
        if (password.matches(".*[0-9].*")) score++;         // Numeri
        if (password.matches(".*[!@#$%^&*(),.?\\\\:{}|<>].*")) score++; // Simboli

        return score;
    }

    private static String valutaLivello(int score) {
        return switch (score) {
            case 0, 1, 2 -> "Weak";
            case 3, 4 -> "Medium";
            case 5 -> "Strong";
            default -> "Unknown";
        };
    }
}
