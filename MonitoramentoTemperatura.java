import java.util.Locale;
import java.util.Scanner;

public class MonitoramentoTemperatura {

    public static void main(String[] args) {
        // Configura o Scanner para aceitar o ponto (.) ou vírgula conforme o sistema
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        final int TOTAL_LEITURAS = 12;
        final double MIN_TEMP = 4.0;
        final double MAX_TEMP = 10.0;

        // Vetor para armazenar as 12 temperaturas
        double[] temperaturas = new double[TOTAL_LEITURAS];
        double soma = 0.0;

        System.out.println("=== SISTEMA DE MONITORAMENTO DE TEMPERATURA DA ÁGUA ===");
        System.out.println("Insira " + TOTAL_LEITURAS + " medições válidas (entre " + MIN_TEMP + "ºC e " + MAX_TEMP + "ºC):\n");

        // Estrutura de repetição para preencher o vetor
        for (int i = 0; i < TOTAL_LEITURAS; i++) {
            double tempDigitada;

            // Loop do-while para garantir a validação da entrada
            do {
                System.out.print("Digite a " + (i + 1) + "ª temperatura: ");
                tempDigitada = scanner.nextDouble();

                if (tempDigitada < MIN_TEMP || tempDigitada > MAX_TEMP) {
                    System.out.println("[ERRO] Temperatura inválida! A temperatura deve estar entre " 
                                       + MIN_TEMP + "ºC e " + MAX_TEMP + "ºC. Tente novamente.");
                }
            } while (tempDigitada < MIN_TEMP || tempDigitada > MAX_TEMP);

            // Armazena a temperatura válida no vetor
            temperaturas[i] = tempDigitada;
            
            // Somatório para a média
            soma += temperaturas[i];
        }

        // Cálculo da média
        double media = soma / TOTAL_LEITURAS;

        // Exibição do resultado formatado com 1 casa decimal
        System.out.printf("\nA média de hoje das temperaturas é: %.1fº C%n", media);

        scanner.close();
    }
}