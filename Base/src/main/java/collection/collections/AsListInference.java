package collection.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Halo
 * @create 2021/09/26 下午 05:59
 * @description
 */
class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

/**
 * @author HALO
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());
        //- snow1.add(new Heavy()); // Exception

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        //- snow2.add(new Slush()); // Exception

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,
                new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());

        // Hint with explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush());
        //- snow4.add(new Powder()); // Exception
    }
}