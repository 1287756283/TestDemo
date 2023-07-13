package DesignPatterns.FactoryMode;

import DesignPatterns.FactoryMode.AbStractDomin.RouJiaMo;
import DesignPatterns.FactoryMode.AbStractDomin.RoujiaMoStore;
import DesignPatterns.FactoryMode.Domin.XianLaRouJiaMo;
import DesignPatterns.FactoryMode.Domin.XianSuanRouJiaMo;
import DesignPatterns.FactoryMode.Domin.XianTianRouJiaMo;

public class XiAnRoujiamoStore extends RoujiaMoStore {
    @Override
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        if (type.equals("Suan"))
        {
            rouJiaMo = new XianSuanRouJiaMo();

        } else if (type.equals("Tian"))
        {
            rouJiaMo = new XianTianRouJiaMo();
        } else if (type.equals("La"))
        {
            rouJiaMo = new XianLaRouJiaMo();
        }
        return rouJiaMo;
    }
}
