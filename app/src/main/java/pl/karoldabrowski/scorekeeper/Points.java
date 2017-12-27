package pl.karoldabrowski.scorekeeper;

public enum Points {
    ZERO,
    FIFTEEN,
    THIRTY,
    FORTY,
    ADVANTAGE;

    public Points next() {
        switch (this) {
            case ZERO:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            case FORTY:
                return ADVANTAGE;
            default:
                return ZERO;
        }
    }

    public String label() {
        switch (this) {
            case ZERO:
                return "0";
            case FIFTEEN:
                return "15";
            case THIRTY:
                return "30";
            case FORTY:
                return "40";
            case ADVANTAGE:
                return "Ad";
            default:
                return "0";
        }
    }
}

