package language;

import java.io.FileNotFoundException;

import com.esotericsoftware.yamlbeans.YamlException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, YamlException {
        Locale l = Locale.getInstance();
        System.out.println(
                l.getText("show_points")
                .replace("{{PLAYERNAME}}", "DevPGSV")
                .replace("{{POINTS}}", "5")
            );
            
        l.setLocale("es");
        System.out.println(
                l.getText("show_points")
                .replace("{{PLAYERNAME}}", "DevPGSV")
                .replace("{{POINTS}}", "5")
            );
            
        
    }

}
