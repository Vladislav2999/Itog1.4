public class Converter {
    double ckal;
    double kmm;

    Converter(double cal, double km) {
        ckal = cal;
        kmm = km;
    }

    void convert(int summ, int vvodCon) {
        if (vvodCon == 1) {
            double stepKm = summ * kmm;
            System.out.println("Ваше пройденное расстояние в километрах " + stepKm);
        } else if (vvodCon == 2) {
            double ccal = summ * ckal;
            System.out.println("Ваше количество сожженых килокалорий " + ccal);
        }
    }
}



