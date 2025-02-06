package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n ) {
        homes.sort(Comparator.comparingDouble(Home::getArea));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n && i < homes.size(); i++){
            result.add(homes.get(i).toString());
        }
        return result;
    }
}
// END
