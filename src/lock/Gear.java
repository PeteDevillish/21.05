package lock;

public class Gear {
    private int openPosition;
    private int actualPosition;

    public Gear(int openPosition) {
        this.openPosition = openPosition % 10;
        actualPosition = this.openPosition;
    }

    public void setActualPosition(int rotation) {
        actualPosition = (actualPosition + rotation) %10;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public Boolean isOpenPosition() {
        return openPosition == actualPosition;
    }
}
