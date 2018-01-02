package _01Logger.factories;

import _01Logger.models.SimpleLayout;
import _01Logger.models.XmlLayout;
import _01Logger.models.interfaces.Layout;

public final class LayoutFactory {
    private LayoutFactory() {
    }

    public static Layout createXmlLayout(){
        return new XmlLayout();
    }

    public static Layout createSimpleLayout(){
        return new SimpleLayout();
    }
}
