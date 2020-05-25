package config;

import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class FrameConfig {

    private final String title;

    private final int windowUp;

    private final int width;

    private final int height;

    private final int padding;

    private final int border;

    /**
     * 图层属性
     */
    private List<LayerConfig> layersConfig;

    public FrameConfig(Element frame){
        this.width = Integer.parseInt(frame.attributeValue("width"));//获取窗口宽度

        this.height = Integer.parseInt(frame.attributeValue("height"));//获取窗口高度

        this.border = Integer.parseInt(frame.attributeValue("border"));//获取边框粗细

        this.padding = Integer.parseInt(frame.attributeValue("padding"));//获取边框边距

        this.title = frame.attributeValue("title");//获取标题

        this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));//获取窗口拔高
        @SuppressWarnings("unchecked")
        List<Element> layers = frame.elements("layer");//获取窗口属性

        layersConfig = new ArrayList<LayerConfig>();

        for (Element layer : layers) {
            //设置单个窗体的属性
            LayerConfig lc = new LayerConfig(
                    layer.attributeValue("className"),
                    Integer.parseInt(layer.attributeValue("x")),
                    Integer.parseInt(layer.attributeValue("y")),
                    Integer.parseInt(layer.attributeValue("w")),
                    Integer.parseInt(layer.attributeValue("h"))
            );
            layersConfig.add(lc);
        }
    }

    public String getTitle() {
        return title;
    }

    public int getWindowUp() {
        return windowUp;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPadding() {
        return padding;
    }

    public int getBorder() {
        return border;
    }

    public List<LayerConfig> getLayersConfig() {
        return layersConfig;
    }
}
