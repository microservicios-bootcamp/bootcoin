package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monedero {
    private String id;
    private String phoneNumber;
    private String email;
}
