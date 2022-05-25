package amrv;

import org.amrvimag.bocateria.Configuration;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ConfigurationTesting implements Configuration.ConfigurationListener {

    public static void main(String[] args) {
        System.out.println(Configuration.getConfig("random.data"));
//        Configuration.setConfig("random.data", "defaultValue");
        Configuration.addListener(new ConfigurationTesting());
        Configuration.setConfig("random.data", "example");
    }

    @Override
    public void onChange(String key, String oldValue, String newValue) {
        System.out
                .println("Key changed from '" + oldValue + "' to '" + newValue + "'");
    }
}
