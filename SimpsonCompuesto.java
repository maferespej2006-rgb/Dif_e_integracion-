package dif_e_Integracion;

public class SimpsonCompuesto {
    
    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;
        
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            
            // ===== TODO COMPLETADO =====
            if (k % 2 == 1) {
                // Índice impar → coeficiente 4
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                // Índice par → coeficiente 2
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
            // ===========================
        }
        
        double sumaTotal = TrapecioCompuesto.funcion(a) + 4 * sumaImpares + 2 * sumaPares + TrapecioCompuesto.funcion(b);
        return (h / 3) * sumaTotal;
    }
    
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;
        
        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        
        return integralAnterior;
    }
}
