import lombok.Data;

@Data
public class Clothes {

    private String type;
    private Integer size;
    private Integer price;


    public Clothes(String type, Integer size, Integer price){
        this.type = type;
        this.size = size;
        this.price = price;
    }

}



