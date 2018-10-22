package com.company;
        import java.time.format.DateTimeFormatter;
        import java.time.LocalTime;
        import java.util.Scanner;

public class Main {
    enum  Status{POTWIERDZONE,NIEPOTWIERDZONE,WAZNE};
    Kalendary newKalendary=new Kalendary();
    public static void main(String[] args)
    {
        Main newMain=new Main();
        boolean end=true;

        do{
            menu();


            switch (getDay())
            {
                case 0:
                    System.out.println("Podałeś błędną cyfre!!\nWybierz jeszcze raz");
                    break;
                case 1:
                    newMain.addTask();
                    break;
                case 2:
                    newMain.addMeeting();
                    break;
                case 3:
                    newMain.showKalendary();
                    break;
                case 4:
                    newMain.whatShows(true);
                    break;
                case 5:
                    newMain.whatShows(false);
                    break;
                case 6:
                    newMain.showByStatus();
                    break;
                case 7:
                    newMain.showByPriorityAndCompletions();
                    break;
                case 8:
                    end=false;
                    break;
            }
        }while(end);
    }

    public void showByPriorityAndCompletions()
    {
        System.out.println("Podaj Wartosci dla jakich chcesz wyswietlic zadania:");
        int selectedDay=selectDay();
        boolean selectedPriority= priority();
        boolean selectedCompletions=completions();
        System.out.println(newKalendary.showTaskByPriorityAndCompletions(selectedDay,selectedPriority,selectedCompletions));

    }

    public void showByStatus()
    {

        int selectedDay=selectDay();
        Status selectedStatus=status();
        System.out.println(newKalendary.showMeetingByStatus(selectedDay,selectedStatus.toString()));


    }
    public void whatShows(boolean selectedOption)//true -show tasks,false meetings
    {
        int selectedDay=selectDay();
        showSelectedDays(selectedDay);
        System.out.println(newKalendary.showTasksOrMeetings(selectedDay,selectedOption));
    }

    public void showKalendary()
    {
        int selectedDay=selectDay();
        showSelectedDays(selectedDay);
        System.out.println(newKalendary.showDay(selectedDay));
    }

    public void addMeeting()
    {
        int selectedDay=selectDay();
        LocalTime selectedStart=startTime();
        LocalTime selectedEnd=endTime();
        String selectedAddnotation=addnotation();
        String selectedStatus=status().toString();
        newKalendary.addMeeting(selectedDay,selectedStart,selectedEnd,selectedStatus,selectedAddnotation);

    }

    public void addTask()
    {
        int selectedDay=selectDay();
        LocalTime selectedStart=startTime();
        LocalTime selectedEnd=endTime();
        boolean selectedCompletition =completions();
        boolean selectedPriority=priority();
        String selectedAddnotation=addnotation();
        newKalendary.addTask(selectedDay,selectedStart,selectedEnd,selectedCompletition,selectedPriority,selectedAddnotation);

    }
    public static LocalTime startTime()
    {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Podaj godzine rozpoczecia:");
        Scanner in=new Scanner(System.in);
        LocalTime time=LocalTime.parse(in.nextLine(),format);
        return time;
    }
    public static LocalTime endTime()
    {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Podaj godzine zakonczenia:");
        Scanner in=new Scanner(System.in);
        LocalTime time=LocalTime.parse(in.nextLine(),format);
        return time;
    }
    public static boolean completions()
    {
        System.out.println("Czy zrealizowano zadanie? (y:n)");
        Scanner comp=new Scanner(System.in);
        String completions=comp.nextLine();
        if(completions.equals("y"))
            return true;
        else if(completions.equals("n"))
            return false;
        else
            System.out.println("wybrano zla wartosc!!! Przydzielam Status: Do realizacji");
            return false;
    }
    public static Status status()
    {
        System.out.println("Podaj Status(1-3) \n1-Potwierdzone \n2-Niepotwierdzone\n3-Wazne:");
        Scanner stat=new Scanner(System.in);
                switch (stat.nextInt()) {
                    case 1:
                        Status status1 = Status.POTWIERDZONE;
                        return status1;

                    case 2:
                        Status status2 = Status.NIEPOTWIERDZONE;
                        return status2;

                    case 3:
                        Status status3 = Status.WAZNE;
                        return status3;
                }
        return status();

    }

    public static boolean priority()
    {
        System.out.println("Czy priorytet zadania jest podwyzszony? Wybierz:\n1. Normalny\n2. Wysoki \n");
        Scanner in=new Scanner(System.in);
        int priority=in.nextInt();
        switch(priority) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("wybrano zla wartosc!!! - (PRIORYTER:NORMALNY)");
                return true;
        }
    }
    public static String addnotation()
    {
        System.out.println("Podaj wydarzenie:");
        Scanner in=new Scanner(System.in);
        return in.nextLine();
    }
    public static void menu()
    {
        System.out.println("Wybierz Co chcesz wykonać: ");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Dodaj Spotkanie");
        System.out.println("3. Wyswietl zaplanowany dzien");
        System.out.println("4. Wyswietl zadania na wybrany dzien");
        System.out.println("5. Wyswietl spotkania na wybrany dzien");
        System.out.println("6. Spotkania z wybranym stanem na wybrany dzien");
        System.out.println("7. Zadania z wybranym priorytetem i stanem na wybrany dzień");
        System.out.println("8. Zakoncz");
    }
    public static int getDay()
    {
        Scanner in=new Scanner(System.in);
        int day=in.nextInt();
        return day;
    }
    public static int selectDay()
    {
        System.out.println("1. Poniedzialek");
        System.out.println("2. Wtorek");
        System.out.println("3. Sroda");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        Scanner in=new Scanner(System.in);
        int gin = in.nextInt();
        return gin;
    }
    public static void showSelectedDays(int i) {
        if (i == 1)
            System.out.println("\nPoniedzialek: \n\n ");
        else if (i == 2)
            System.out.println("\nWtorek: \n\n ");
        else if (i == 3)
            System.out.println("\nSroda: \n\n ");
        else if (i == 4)
            System.out.println("\nCzwartek: \n\n ");
        else if (i == 5)
            System.out.println("\nPiatek: \n\n ");
        else if (i == 6)
            System.out.println("\nSobota: \n\n ");
        else if (i == 7)
            System.out.println("\nNiedziela: \n\n ");
    }
}

