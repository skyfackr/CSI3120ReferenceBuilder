package wang.skycloud.uocsi3120;

public class Symbol {
    String type;
    String name;
    String value;
    

    public Symbol() {
        this.type = "";
        this.name = "";
        this.value = "";
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
