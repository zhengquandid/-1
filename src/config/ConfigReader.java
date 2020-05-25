/*
package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class ConfigReader {

    public static void readConfig() throws DocumentException {
        SAXReader reader = new SAXReader();//创建xml读取器

        Document doc = reader.read("config/cfg.xml");//读取xml文件

        Element game = doc.getRootElement();//获得xml文件的根节点

        Element frame = game.element("frame");// 配置窗口

        List<Element> layers = frame.elements("layer");//获得layer标签里的东西

        for (Element layer : layers) {
            System.out.println(layer.attributeValue("className") + ",");
            System.out.println(layer.attributeValue("x") + ",");
            System.out.println(layer.attributeValue("y") + ",");
            System.out.println(layer.attributeValue("w") + ",");
            System.out.println(layer.attributeValue("h") + ",");
            System.out.println();
        }//循环输出layer标签里的内容
        String str = frame.attributeValue("width");
        System.out.println(str);
    }

    public static void main(String[] args) throws DocumentException {

        readConfig();
    }
}
*/
