package org.example.ex08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Exam08 {

    public Exam08(Store store){    // service logic
        var stringRegisterAt = toLocalDateTimeString(
            Optional.ofNullable(store.getRegisterAt())
        );
    }

    public String toLocalDateTimeString(Optional<LocalDateTime> localDateTime){

        LocalDateTime temp = localDateTime.orElseGet(()-> LocalDateTime.now());
        return temp.format(DateTimeFormatter.ofPattern("yyyy MM dd"));
    }

    public static void main(String[] args){
        // client ->
        var registerDto = new Store();
        //registerDto.setRegisterAt(LocalDateTime.now());

        new Exam08(registerDto);    // example service logic
    }
}

class Store{
    private LocalDateTime registerAt;

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }
}