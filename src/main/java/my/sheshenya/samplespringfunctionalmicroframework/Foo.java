package my.sheshenya.samplespringfunctionalmicroframework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {

    private String name;
//
//    @ConstructorProperties("name")
//    Foo(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }

}
