package dif_e_Integracion;

public class Principal {
    public static void main(String[] args) {
        double a = 0.0;          // Límite inferior
        double b = Math.PI;      // Límite superior
        double tolerancia = 1e-6; // 0.000001
        
        System.out.println("=== INTEGRACIÓN NUMÉRICA ===");
        System.out.println("Función: f(x) = sen(x)");
        System.out.println("Intervalo: [" + a + ", " + b + "]");
        System.out.println("Tolerancia: " + tolerancia);
        System.out.println();
        
        // === MÉTODO DEL TRAPECIO COMPUESTO ===
        System.out.println("--- MÉTODO DEL TRAPECIO COMPUESTO ---");
        int nT = 2;
        double antT = TrapecioCompuesto.calcularTrapecio(a, b, nT);
        int iterT = 0;
        
        while (true) {
            iterT++;
            nT *= 2;
            double nueT = TrapecioCompuesto.calcularTrapecio(a, b, nT);
            double errT = Math.abs(nueT - antT);
            System.out.printf("n = %d | Integral = %.10f | Error = %.2e%n", nT, nueT, errT);
            if (errT <= tolerancia) break;
            antT = nueT;
        }
        double resT = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.printf("Resultado final Trapecio: %.10f | n final = %d | Iteraciones: %d%n", resT, nT, iterT);
        System.out.println();
        
        // === MÉTODO DE SIMPSON 1/3 COMPUESTO ===
        System.out.println("--- MÉTODO DE SIMPSON 1/3 COMPUESTO ---");
        int nS = 2;
        double antS = SimpsonCompuesto.calcularSimpson(a, b, nS);
        int iterS = 0;
        
        while (true) {
            iterS++;
            nS *= 2;
            double nueS = SimpsonCompuesto.calcularSimpson(a, b, nS);
            double errS = Math.abs(nueS - antS);
            System.out.printf("n = %d | Integral = %.10f | Error = %.2e%n", nS, nueS, errS);
            if (errS <= tolerancia) break;
            antS = nueS;
        }
        double resS = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.printf("Resultado final Simpson:  %.10f | n final = %d | Iteraciones: %d%n", resS, nS, iterS);
        System.out.println();
        
        // === COMPARACIÓN ===
        System.out.println("--- COMPARACIÓN ---");
        System.out.println("Trapecio -> n = " + nT + ", Iteraciones = " + iterT);
        System.out.println("Simpson  -> n = " + nS + ", Iteraciones = " + iterS);
        System.out.println("Valor exacto: ∫sen(x)dx de 0 a π = 2.0");
    }
}
