package com.company;


import java.util.ArrayList;
import java.time.LocalTime;
import java.util.function.Predicate;
public class Kalendary {
    private ArrayList <Event>[] kalendary;

    public Kalendary(){
        kalendary=new ArrayList [7];
        for(int i=0;i<7;i++) {
            kalendary[i] = new ArrayList<Event>();
        }
    }

    public String addTask(int selectedDay,LocalTime start,LocalTime end,boolean completions,boolean priority,String addnotation)
    {
        Task newTask=new Task(start,end,completions,priority,addnotation);
        kalendary[selectedDay].add(newTask);
        return "Dodano Zadanie";
    }
    public String addMeeting(int selectedDay,LocalTime start,LocalTime end, String status,String addnotation)
    {
        Meeting newMeeting=new Meeting(start,end,status,addnotation);
        kalendary[selectedDay].add(newMeeting);
        return "Dodano Spotkanie";
    }
    public String showDay(int selectedDay)
    {
        StringBuilder textToShow=new StringBuilder();
        for(int i=0;i<kalendary[selectedDay].size();i++)
        {
          textToShow.append(((kalendary[selectedDay].get(i))).showEvent()+"\n");
        }

    return textToShow.toString();
    }

    //user must select which of two options chose, if user select true function work on Task Objects, if true work on Meeting
    public String showTasksOrMeetings(int selectedDay,boolean selectedOption )
    {
        StringBuilder tasksToShow=new StringBuilder();
        StringBuilder meetingsToShow=new StringBuilder();
        for(int i=0;i<kalendary[selectedDay].size();i++)
        {
            if(checkClass(kalendary[selectedDay].get(i)))
                tasksToShow.append(((kalendary[selectedDay].get(i))).showEvent()+"\n");
            else
                meetingsToShow.append(((kalendary[selectedDay].get(i))).showEvent()+"\n");
        }
        if(selectedOption)
            return tasksToShow.toString();
        else
            return meetingsToShow.toString();
    }
    private boolean checkClass (Object c)
    {
        if (c instanceof Task )
        return true;
        else
        return false;
    }

public String showMeetingByStatus(int selectedDay,String searchingStatus){

    StringBuilder textToReturn=new StringBuilder();
     for(int i=0;i<kalendary[selectedDay].size();i++) {

         if ((kalendary[selectedDay].get(i)) instanceof Meeting) {
             Meeting d=((Meeting)(kalendary[selectedDay].get(i)));
             textToReturn.append(printMeetingByStatus(d,c-> c.checkStatus(searchingStatus)) + "\n");
         }
     }
    return textToReturn.toString();
}
    public String showTaskByPriorityAndCompletions(int selectedDay,boolean searchingPriority,boolean searchingCompletions){

        StringBuilder textToReturn=new StringBuilder();
        for(int i=0;i<kalendary[selectedDay].size();i++) {

            if ((kalendary[selectedDay].get(i)) instanceof Task) {
                Task d=((Task)(kalendary[selectedDay].get(i)));
                textToReturn.append(printTaskByStatus(d,c-> c.checkStatus(searchingPriority,searchingCompletions)) + "\n");
            }
        }
        return textToReturn.toString();
    }
  private String printMeetingByStatus(Meeting meeting,Predicate<Meeting> checker)
  {
      StringBuilder textToReturn=new StringBuilder();

          if(checker.test(meeting))
              textToReturn.append(meeting.showEvent());

      return textToReturn.toString();
  }

    private String printTaskByStatus(Task task,Predicate<Task> checker)
    {
        StringBuilder textToReturn=new StringBuilder();
        if(checker.test(task))
            textToReturn.append(task.showEvent());
        return textToReturn.toString();
    }
}




