package earth.defense.corps.edc.global;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseHeader {
    private int status;
    private String message;
}
