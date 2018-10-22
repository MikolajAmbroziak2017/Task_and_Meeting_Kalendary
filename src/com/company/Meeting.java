package com.company;

import java.time.LocalTime;

public class Meeting extends Event {

    private Status s1;//to dodalem i s1 bedzie trzymac te informacje s1 to obiekt klasy Status ktora jest wyliczeniowa
    private enum  Status{POTWIERDZONE,NIEPOTWIERDZONE,WAZNE}
    public Meeting(LocalTime start,LocalTime end, String status,String addnotation)
    {
        setAddnotation(addnotation);
        setEndTime(end);
        setStartTime(start);
        setStatus(status);
        }

    public void setStatus(String status)//dzieki temu moge setnąc s1 do wartosci enum Status
    {
        s1=Status.valueOf(status);
    }

    public String getStatus()//i gdy zwracam to wyrzucam bezpośrednio tylko z pola prywatnego
    {
    return s1.toString();
 }
    @Override
    public String showEvent() {
        StringBuilder textMessage =new StringBuilder();
        textMessage.append(getStartTime()).append("-").append(getEndTime()).append("\t"+getAddnotation()).append("\t( Status: "+getStatus()+" )");
    return textMessage.toString();
    }

    public boolean checkStatus(String searchingStatus)
    {
        String gotStatus=getStatus();
        return
                gotStatus.equals(searchingStatus);
    }

}

