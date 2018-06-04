import java.io.BufferedInputStream;
import java.text.ParseException;
import java.util.*;

class Day {
    int year = 1000;
    int month = 1;
    int day = 1;
    int[][] daysofmonth = {
            {},
            {31, 31},
            {28, 29},
            {31, 31},
            {30, 30},
            {31, 31},
            {30, 30},
            {31, 31},
            {31, 31},
            {30, 30},
            {31, 31},
            {30, 30},
            {31, 31},
    };

    public int isLeapYear(int year) {
        int isly = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
        return isly;
    }

    public void nextday() {

        if ((++day - 1) / daysofmonth[month][isLeapYear(year)] != 0) {
            day = day % daysofmonth[month][isLeapYear(year)];
            if ((++month - 1) / 12 != 0) {
                month = month % 12;
                year++;
            }
        }
    }

    public Day getDate(String date) {
        Day day1 = new Day();
        day1.year = Integer.parseInt(date.substring(0, 4));
        day1.month = Integer.parseInt(date.substring(4, 6));
        day1.day = Integer.parseInt(date.substring(6, 8));
        return day1;
    }
}

public class Main {
    public static void main(String args[]) throws ParseException {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int[][][] days = new int[5100][13][32];
        Day day = new Day();
        day.year = 1000;
        day.month = 1;
        day.day = 1;
        int cnt = 1;
        while (day.year < 5010) {
//            System.out.println(String.valueOf(day.year)+String.valueOf(day.month)+String.valueOf(day.day));
            days[day.year][day.month][day.day] = cnt++;
            day.nextday();
        }
        while (cin.hasNext()) {
            Day startTime = day.getDate(cin.next());
            Day endTime = day.getDate(cin.next());
            System.out.println(Math.abs(days[startTime.year][startTime.month][startTime.day]
                    - days[endTime.year][endTime.month][endTime.day]) + 1);
        }
    }
}
