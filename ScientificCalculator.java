import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class ScientificCalculator{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            try{
                System.out.println("Welcome to the scientific calculator! ");
                System.out.println("Please pick from the following options (1-5): ");
                System.out.println("1. Basic arithmetic");
                System.out.println("2. Quadratic functions");
                System.out.println("3. Trigonometric functions");
                System.out.println("4. Logarithms and exponentials");
                System.out.println("5. Exit");
                int num = scan.nextInt();

                if(num == 1) {
                    basicArithmetic(scan);
                    exit = true;
                } else if (num == 2) {
                    quadraticFormula(scan);
                    exit = true;
                } else if (num == 3) {
                    trigFunctions(scan);
                    exit = true;
                } else if (num == 4) {
                    logAndE(scan);
                    exit = true;
                } else if (num == 5) {
                    exit = true;
                } else { //handling an output out of the bounds [1,5]
                    System.out.println("Please enter an integer 1-5! ");
                }
            } catch(InputMismatchException e) { //handling a string input
                scan.nextLine();
                System.out.println("Please enter an integer 1-5! ");
            }
        }
    }

    public static void basicArithmetic(Scanner scan) {
        boolean complete = false;
        boolean goodInput = false;
        boolean computing = true;
        int count = 0;
        double currNum = 0.0;
        double nextNum = 0.0;
        double output = 0.0;
        char operation = 'c';
        double prevNum = 0.0; 
        DecimalFormat df = new DecimalFormat("#.##");
    
        while(!complete) {
            try {
                while(!goodInput) {
                    System.out.println("Welcome to the basic arithmetic calculator! Enter a double to begin with, type 'exit' to exit:");
                    if(scan.hasNextDouble()) {
                        currNum = scan.nextDouble();
                        goodInput = true;
                    } else {
                        String s = scan.next();
                        if (s.equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Please only enter a double value!");
                        }
                    }
                }
                goodInput = false;
    
                while(computing) {
                    goodInput = false;
                    while(!goodInput) {
                        System.out.println("Enter the operation you'd like to perform (+,-,*,/), type 'exit' to exit: ");
                        String s = scan.next();
                        if (s.equalsIgnoreCase("exit")) {
                            return;
                        }
                        operation = s.charAt(0);
                        if(operation == '+' || operation == '-' || operation == '*' || operation == '/') {
                            goodInput = true;
                        } else {
                            System.out.println("Please only enter one of the operations listed above!");
                        }
                    }
                    goodInput = false;
    
                    boolean notZero = true;
                    while(!goodInput) {
                        System.out.println("Enter a double, 'exit' to exit: ");
                        if (scan.hasNextDouble()) {
                            nextNum = scan.nextDouble();
                            count++;
    
                            if(operation == '/' && nextNum == 0) {
                                while (notZero) {
                                    System.out.println("Division by zero is not allowed! Please re-enter your double, type 'exit' to exit: ");
                                    if(scan.hasNextDouble()) {
                                        double d = scan.nextDouble();
                                        if (d == 0.0) {
                                            System.out.println("Division by zero is not allowed!");
                                        } else {
                                            notZero = false;
                                            nextNum = d; // Update nextNum with the valid value
                                        }
                                    } else {
                                        String s = scan.next();
                                        if (s.equalsIgnoreCase("exit")) {
                                            return;
                                        } else {
                                            System.out.println("Please only enter double values!");
                                        }
                                    }
                                }
                            } 

                            if(count == 1) {
                                if (operation == '+') {
                                    output = currNum + nextNum;
                                } else if (operation == '-') {
                                    output = currNum - nextNum;
                                } else if (operation == '*') {
                                    output = currNum * nextNum;
                                } else {
                                    output = currNum / nextNum;
                                }
                                System.out.println(df.format(currNum) + " " + operation + " " + df.format(nextNum) + " = " + df.format(output));
                                goodInput = true;
                            } else {
                                // Output with previous number
                                if(operation == '+') {
                                    output = currNum + nextNum;
                                } else if(operation == '-') {
                                    output = currNum - nextNum;
                                } else if(operation == '*') {
                                    output = currNum * nextNum;
                                } else {
                                    output = currNum / nextNum;
                                }
                                goodInput = true;
                                System.out.println(df.format(currNum) + " " + operation + " " + df.format(nextNum) + " = " + df.format(output));
                            }
                            prevNum = currNum; 
                            currNum = output; 
                        } else {
                            String s = scan.next();
                            if(s.equalsIgnoreCase("exit")) {
                                return;
                            } else {
                                System.out.println("Please enter a double!");
                            }
                        }
                    }
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("You entered a bad input. Let's restart! ");
            }
        }
    }

    public static void quadraticFormula(Scanner scan) {
        boolean complete = false;
    
        while(!complete) {
            try { 
                System.out.println("Using the quadratic equation: ax^2+bx+c: please specify a double value for 'a', type 'exit' to quit: ");
                double a = 1;
                double b = 1;
                double c = 1;
                boolean goodInput = false;
                
                    while(!goodInput) { 
                        if(scan.hasNextDouble()) {
                            a = scan.nextDouble();
                            goodInput = true; //break out of while loop if user put double
                        } else if(scan.next().equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter a double. ");

                        }
                    }

                    goodInput = false;
                    System.out.println("Please specify a double value for 'b', type 'exit' to quit: ");

                    while(!goodInput) { 
                        if(scan.hasNextDouble()) {
                            b = scan.nextDouble();
                            goodInput = true; //break out of while loop if user put double
                        } else if(scan.next().equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter a double. ");

                        }
                    }

                    goodInput = false;
                    System.out.println("Please specify a double value for 'c', type 'exit' to quit: ");

                    while(!goodInput) { 
                        if(scan.hasNextDouble()) {
                            c = scan.nextDouble();
                            goodInput = true; //break out of while loop if user put double
                        } else if(scan.next().equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter a double. ");

                        }
                    }
                //solve with the quadratic formula
                DecimalFormat df = new DecimalFormat("#.##");
                double discriminant = Math.pow(b, 2) - 4 * a * c;

                if(discriminant > 0) {
                    double rootOne = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double rootTwo = (-b - Math.sqrt(discriminant)) / (2 * a);
                    System.out.println("Root 1: " + df.format(rootOne));
                    System.out.println("Root 2: " + df.format(rootTwo));
                }else if(discriminant == 0) {
                    double root = -b / (2 * a);
                    System.out.println("Root: " + df.format(root));
                }else{
                    double realPart = -b / (2 * a);
                    double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                    System.out.println("Root 1: " + df.format(realPart) + " + " + df.format(imaginaryPart) + "i");
                    System.out.println("Root 2: " + df.format(realPart) + " - " + df.format(imaginaryPart) + "i");
                }
                complete = true;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("You entered a bad input. Let's restart! ");
            }
        }
    }

    public static void trigFunctions(Scanner scan) {
        boolean introComplete = false;
        double coefficient = 0.0;
        double divisor = 0.0;
        double radians = 0.0;
        double degrees = 0.0;
        int input = 0;
        while(!introComplete) {
            try{
                System.out.println("Please pick from the following options 1-2, or type 'exit' to exit: ");
                System.out.println("1. Enter amount to calculate in radians ");
                System.out.println("2. Enter amount to calculate in degrees ");
                boolean goodInput = false;
                
                while(!goodInput) {
                    try{ 
                        if(scan.hasNextInt()) {
                            input = scan.nextInt();
                            if(input > 2 || input < 1) {
                                System.out.println("Please only select values ranging from 1-2! ");
                            } else {
                                goodInput = true;
                            }
                        } else {
                            String s = scan.next();
                            if(s.equalsIgnoreCase("exit")) {
                                return;
                            } else {
                                System.out.println("Please only enter integers!");
                            }
                        } 

                    } catch(InputMismatchException e) {
                        scan.nextLine();
                        System.out.println("Please only enter integers!");
                    }
                }


                goodInput = false;
                if(input == 1) {
                    while(!goodInput) {
                        System.out.println("Enter coefficient of Pi (double), type 'exit' to exit: ");
                        if(scan.hasNextDouble()) {
                            coefficient = scan.nextDouble();
                            goodInput = true;
                        } else if(scan.next().equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Please enter a double value!");
                        }
                    }
                    goodInput = false;

                    while(!goodInput) {
                        System.out.println("Enter the double you'd like the coefficient and pi to be divided by, type 'exit' to exit: ");
                        if(scan.hasNextDouble()) {
                            divisor = scan.nextDouble();
                            if(divisor != 0) {
                                goodInput = true;
                            } else {
                                System.out.println("Please don't divide by zero!");
                            }
                        } else if(scan.next().equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Please enter a double value!");
                        }
                    }
                    goodInput = false;


                } else {
                    while(!goodInput) {
                        System.out.println("Enter a double representing the amount of degrees you'd like to compute, type 'exit' to exit: ");
                        if(scan.hasNextInt()) {
                            degrees = scan.nextInt();
                            goodInput = true;
                        } else {
                            String s = scan.next();
                            if (s.equalsIgnoreCase("exit")) {
                                return;
                            } else {
                                System.out.println("Please enter a double value!");
                            }
                        }
                    }
                    
                }

                DecimalFormat df = new DecimalFormat("#.##");

                if(input == 2) {
                    char symbol = '\u00B0';
                    System.out.println("Sin(" + degrees + symbol + ")" + " = " + df.format(Math.sin(degrees)));
                    System.out.println("Cos(" + degrees + symbol + ")" + " = " + df.format(Math.cos(degrees)));
                    System.out.println("Tan(" + degrees + symbol + ")" + " = " + df.format(Math.tan(degrees)));
                } else {
                    //coefficient, and divisor
                    double equated = ((coefficient) * Math.PI) / divisor;
                    char piSymbol = '\u03C0';
                    System.out.println("Sin( (" + coefficient + piSymbol + ") / " + divisor + ") )" + " = " + df.format(Math.sin(equated)));
                    System.out.println("Cos( (" + coefficient + piSymbol + ") / " + divisor + ") )" + " = " + df.format(Math.cos(equated)));
                    System.out.println("Tan( (" + coefficient + piSymbol + ") / " + divisor + ") )" + " = " + df.format(Math.tan(equated)));
                }
                introComplete = true;
            }catch(InputMismatchException e) {
                scan.nextLine();
                System.out.println("Bad input! Let's restart.");
            }
        }
    }

    public static void logAndE(Scanner scan) {
        boolean complete = false;
        DecimalFormat df = new DecimalFormat("#.##");
        while(!complete) {
            try{
                System.out.println("Please pick from the following options(1-2), or 'exit' to exit: ");
                System.out.println("1. Calculate logarithm");
                System.out.println("2. Calculate exponential");
                boolean goodInput = false;
                int num = 0;

                while(!goodInput) {
                    if(scan.hasNextInt()) {
                        num = scan.nextInt();
                        if(num == 1) {
                            goodInput = true;
                        } else if (num == 2) {
                            goodInput = true;
                        } else {
                            System.out.println("Invalid input. Please enter an integer (1-2).");
                        }
                    } else {
                        String s = scan.next();
                        if(s.equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter an integer (1-2). ");
                        }
                    }
                }
                goodInput = false;
                if(num == 1) {
                    while(!goodInput){
                        System.out.println("Enter a positive, non zero, double to calculate its natural logarithm (base e), type 'exit' to exit: ");
                        if(scan.hasNextDouble()) {
                            double input = scan.nextDouble();
                            if(input<=0) {
                                System.out.println("Please enter a positive, non zero, double only!");
                            } else {
                                double result = 0;
                                result = Math.log(input);
                                System.out.println("The natural logarithm of " + input + " is " + df.format(result));
                                goodInput = true;
                            }

                        } else {
                            String s = scan.next();
                            if(s.equalsIgnoreCase("exit")) {
                                return;
                            } else {
                                System.out.println("Please enter a positive, non zero, double only!");
                            }
                            
                        }
                    }
                } else {
                    while(!goodInput) {
                        System.out.println("Enter a double to calculate its exponential (e^x), or 'exit' to exit: ");
                        if(scan.hasNextDouble()) {
                            double input = scan.nextDouble();
                            double e = Math.exp(input);
                            System.out.println("e^" + input + " is equal to " + df.format(e));
                            goodInput = true;
                        } else {
                            String s = scan.next();
                            if(s.equalsIgnoreCase("exit")) {
                                return;
                            } else {
                                System.out.println("Please input a double value only!");
                            }
                        }
                    }
                }   
                complete = true;
            } catch(InputMismatchException e) {
                scan.nextLine();
                System.out.println("Bad input. Please enter an integer (1-2).");
            }
        }
    }
    
}