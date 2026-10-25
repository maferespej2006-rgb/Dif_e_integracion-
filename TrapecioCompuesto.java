package dif_e_Integracion;

public class TrapecioCompuesto {
    
    // Función a integrar (puedes cambiarla según tu práctica)
    public static double funcion(double x) {
        return Math.sin(x); // Ejemplo: f(x) = sen(x)
    }
    
    // Calcular el ancho de cada subintervalo
    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }
    
    // Método del Trapecio Compuesto
    public static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double suma = funcion(a) + funcion(b);
        
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            suma += 2 * funcion(xk);
        }
        
        return (h / 2) * suma;
    }
    
    // Integrar con tolerancia
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;
        
        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        
        return integralAnterior;
    }
}
