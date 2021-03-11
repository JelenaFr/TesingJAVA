package BMIApp;

public class BMIApplication {
    private BMIService bmiService;
    public void setBmiService(BMIService bmiService) {
        this.bmiService = bmiService;
    }
    public String calcMyBMP(double weight, double height) {
        double bmi = weight / Math.pow(2, height);
        System.out.println("BMI "+bmi);
        if(bmi < 18.5)
            return "Thinness";
        else if(bmi < 25)
            return "Normal";
        else if(bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }
}
