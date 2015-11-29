package viv1.homeautomation;

public class RoomTableData{

    private int bid;
    private String room_name;
    private String room_address;
    private boolean isVisible;

    public String getRoom_address() {
        return room_address;
    }

    public void setRoom_address(String room_address) {
        this.room_address = room_address;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }




}