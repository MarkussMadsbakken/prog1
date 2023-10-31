package prog.ov10;

public class Arrangement {

    public enum Type{
        KONSERT, BARNETEATER, FOREDRAG
    };

    private final String navn, sted, arrangor;
    private final Type type;
    private final long tidspunkt;

    public Arrangement(String navn, String sted, String arrangor, Type type, long tidspunkt){
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int comapareToByTime(Arrangement other){
        if(this.tidspunkt < other.getTidspunkt()){
            return -1;
        }else if(this.tidspunkt > other.getTidspunkt()){
            return 1;
        }else{
            return 0;
        }
    }

    public int comapareToByPlace(Arrangement other){
        return this.sted.compareTo(other.getSted());
    }

    public int comapareToByType(Arrangement other){
        return this.type.compareTo(other.getType());
    }

    public String toString(){
        return navn + " " + sted + " " + arrangor + " " + type + " " + tidspunkt;
    }

    public String getSted(){
        return sted;
    }

    public String getNavn(){
        return navn;
    }

    public String getArrangør(){
        return arrangor;
    }

    public Type getType(){
        return type;
    }

    public long getTidspunkt(){
        return tidspunkt;
    }
}
