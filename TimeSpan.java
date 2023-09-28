class TimeSpan {
    private char timeUnit;
    private int numUnits;

    public TimeSpan(char timeUnit, int numUnits) {
        this.timeUnit = timeUnit;
        this.numUnits = numUnits;
    }

    public char getTime() {
        return timeUnit;
    }

    public int getNum() {
        return numUnits;
    }
}