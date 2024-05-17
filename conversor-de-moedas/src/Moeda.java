public enum Moeda {
    BRASIL("BRL"), EUA("USD"), CANADA("CAD"), EUROPA("EUR");

    private String value;
    Moeda (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
