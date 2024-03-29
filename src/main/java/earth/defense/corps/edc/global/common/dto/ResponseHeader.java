package earth.defense.corps.edc.global.common.dto;


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
