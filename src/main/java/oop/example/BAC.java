/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Angelica Palacio
 */
package oop.example;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BAC
{
    public static void main(String[] args)
    {
        Double bac = calculateBAC();

        DecimalFormat d = new DecimalFormat("#.##");

        String output = bac < 0.08 ? "It is legal for you to drive." : "It is not legal for you to drive.";

        System.out.println("\nYour BAC is " + d.format(bac) + "\n" + output);
    }

    public static Double calculateBAC()
    {
        Scanner input = new Scanner(System.in);
        double weight;
        int gender;
        double alcohol;
        double time;

        while(true)
        {
            System.out.print("What is your weight?\nEnter the value in pounds (lbs). ");
            String a = input.nextLine();

            if(Pattern.matches("[^a-zA-Z]+", a))
            {
                weight = Double.parseDouble(a);
                break;
            }
        }

        while(true)
        {
            System.out.print("\nWhat is your gender?\nEnter 1 for male and 2 for female. " );
            String b = input.nextLine();

            if(Pattern.matches("[^a-zA-Z]+", b))
            {
                gender = Integer.parseInt(b);
                break;
            }
        }

        double ratio = 1;

        if(gender == 1)
        {
            ratio = 0.73;
        }
        else if(gender == 2)
        {
            ratio = 0.66;
        }

        while(true)
        {
            System.out.print("\nWhat is the total amount of alcohol you have consumed?\nEnter the value in ounces (oz). " );
            String c = input.nextLine();

            if(Pattern.matches("[^a-zA-Z]+", c))
            {
                alcohol = Integer.parseInt(c);
                break;
            }
        }


        while(true)
        {
            System.out.print("\nHow much time has passed since your last drink?\nEnter the value in hours. " );
            String d = input.nextLine();

            if(Pattern.matches("[^a-zA-Z]+", d))
            {
                time = Double.parseDouble(d);
                break;
            }
        }

        return ((alcohol * 5.14) / (weight * ratio)) - (0.015 * time);
    }
}