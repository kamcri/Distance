package org.example;

import java.time.DateTimeException;
import java.time.Period;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*Distance between dates calculator*/
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Difference in dates calculator!\nEnter first date in format of 'MM-dd-yyyy'.");

        //Change to user input?
        Scanner sc = new Scanner(System.in);

        String dateOneString = sc.next();
        System.out.println("Enter the second date.");
        String dateTwoString = sc.next();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        //initializing the 2 dates as null
        LocalDate dateOne = null;
        LocalDate dateTwo = null;

        try {
            //date format is yyyy-MM-dd
            dateOne = LocalDate.parse(dateOneString, dateFormat);
            //turn into MMM?
            System.out.println("Date 1: " + dateOne);

            dateTwo = LocalDate.parse(dateTwoString, dateFormat);
            System.out.println("Date 2: " + dateTwo);
        }catch (DateTimeException e){
            System.out.println("Exception: " + e);
        }

        //call method that calculates distance
        distance(dateOne, dateTwo);
    }
    public static void distance(LocalDate d1, LocalDate d2){
        //use period class to find the distance between the dates
        Period period = Period.between(d1, d2);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());

        System.out.println("The dates " + d1 + " and " + d2 + " are " + years + " years, "+
                months + " months, " + "and "+ days + " days apart.");
    }
}
