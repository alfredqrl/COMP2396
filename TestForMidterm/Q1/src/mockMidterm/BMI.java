package mockMidterm;

public class BMI {
    private String name;
    private int age;
    private double weight;
    private double height;

    public BMI (String name, int age, double height, double weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public BMI(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = 25;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public double getBMI(){
        double weightInKilo = this.weight * 0.45359237;
        double heightInMeter = this.height * 0.0254;
        String a = String.format("%.2f",weightInKilo / (heightInMeter * heightInMeter));
        return(Double.parseDouble(a));
    }

    public String getStatus(){
        double bmiVal = getBMI();
        if (bmiVal < 16){
            return "seriously underweight";
        }else if (bmiVal < 18){
            return "underweight";
        }else if (bmiVal < 24){
            return "normal weight";
        }else if (bmiVal < 29){
            return "over weight";
        }else if (bmiVal < 35){
            return "seriously over weight";
        }else if (bmiVal > 35){
            return "gravely over weight";
        }
        return "error";
    }

}
