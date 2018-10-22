package com.company;
import java.time.LocalTime;

public class Task extends Event {
    private boolean priority;
    private boolean completions;

    public Task(LocalTime start,LocalTime end,boolean completions,boolean priority,String addnotation)
    {
        setStartTime(start);
        setEndTime(end);
        setAddnotation(addnotation);
        setCompletions(completions);
        setPriority(priority);
    }
    public void setCompletions(boolean completions) {
        this.completions = completions;
    }

    public String getCompletions()
    {
        if (completions)
            return "Do realizacji";
        else
            return "Wykonany";
    }
    public void setPriority(boolean priority) {
        this.priority = priority;
    }
    public String getPriority()
    {
        if (priority)
            return "Normalny";
        else
            return "Wysoki";
    }
    @Override
    public String showEvent()
    {
        StringBuilder textMessage =new StringBuilder();
        textMessage.append(getStartTime()).append("-").append(getEndTime()).append("\t"+getAddnotation()+"\t").append("\tPriorytet: "+getPriority()+"\t\t")
                .append("\t("+getCompletions()+")");
   return textMessage.toString();
    }

    public boolean checkStatus(boolean searchingPriority,boolean searchingCompletions)
    {
        return (this.completions==searchingCompletions&&this.priority==searchingPriority);
    }


}




