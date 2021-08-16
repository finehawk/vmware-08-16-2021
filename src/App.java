import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

// Author Name: Nimish Khokhar, email: nimishx97@gmail.com, phone: 8699652112
public class App {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:/Users/nimis/Documents/Vmware/vmware_nimish/src/input.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject areaJson = new JSONObject();

            for (int i = 1; i <= jsonObject.size(); i++) {
                String id = Integer.toString(i);
                JSONObject areaObj = (JSONObject) jsonObject.get(id);
                String areaType = (String) areaObj.get("type");

                if (areaType.equals("circle")) {
                    Long radius = (Long) areaObj.get("radius");
                    areaJson.put(id, String.valueOf(Math.PI * radius * radius));
                } else if (areaType.equals("square")) {

                    Long side = (Long) areaObj.get("side");
                    areaJson.put(id, String.valueOf(side * side));
                } else if (areaType.equals("rectangle")) {

                    Long length = (Long) areaObj.get("l");
                    Long breadth = (Long) areaObj.get("b");
                    areaJson.put(id, String.valueOf(length * breadth));
                } else {

                }

            }
            System.out.println(areaJson);
            try {
                FileWriter file = new FileWriter("C:/Users/nimis/Documents/Vmware/vmware_nimish/src/output.json");
                file.write(areaJson.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}