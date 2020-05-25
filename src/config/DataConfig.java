package config;

import org.dom4j.Element;


public class DataConfig {

    private final DataInterfaceConfig dataA;
    private final DataInterfaceConfig dataB;

    public DataConfig(Element data){
        dataA = new DataInterfaceConfig((javax.swing.text.Element) data.element("dataA"));
        dataB = new DataInterfaceConfig((javax.swing.text.Element) data.element("dataB"));
    }

    public DataInterfaceConfig getDataA() {
        return dataA;
    }

    public DataInterfaceConfig getDataB() {
        return dataB;
    }
}
