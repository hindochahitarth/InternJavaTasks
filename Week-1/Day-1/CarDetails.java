import java.time.LocalDateTime;
import java.util.*;
class CarDetails {
    private LocalDateTime manufacturingDate;

    private int totalCapacity;
    private String transmissionMode;

    public CarDetails(LocalDateTime manufacturingDate, int totalCapacity, String transmissionMode) {
        this.manufacturingDate = manufacturingDate;
        this.totalCapacity = totalCapacity;
        this.transmissionMode = transmissionMode;
    }

    public LocalDateTime getLocalDateTime() {
        return manufacturingDate;
    }

    public void setLocalDateTime() {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCapacity() {
        return totalCapacity;
    }

    public void setCapacity() {
        this.totalCapacity = totalCapacity;
    }

    public String gettransmissionMode() {
        return transmissionMode;
    }

    public void settransmissionMode() {
        this.transmissionMode = transmissionMode;
    }

    public String showCarDetails() {
        return "Manufacturing Date & Time : " + manufacturingDate
                + "\n" + "Total Capacity : " + totalCapacity +
                "\n" + "transmissionMode : " + transmissionMode;
    }

}
