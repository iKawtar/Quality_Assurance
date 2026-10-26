package mock2;

public class Calculatrice {
    private Iaddition addService;

    public Calculatrice(Iaddition addService) {
        this.addService = addService;
    }

    public int calcSomme(int num1, int num2) {
        System.out.println("**--- CalcService calc executed ---**");
        return addService.add(num1, num2);
    }
}