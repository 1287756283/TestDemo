package DesignPatterns.FactoryMode;

import DesignPatterns.FactoryMode.AbStractDomin.RouJiaMo;
import DesignPatterns.FactoryMode.Domin.LaRouJiaMo;
import DesignPatterns.FactoryMode.Domin.SuanRouJiaMo;
import DesignPatterns.FactoryMode.Domin.TianRouJiaMo;

public class SimpleRouJiaMoFactroy
{
    public RouJiaMo createRouJiaMo(String type)
    {
        RouJiaMo rouJiaMo = null;
        if (type.equals("Suan"))
        {
            rouJiaMo = new SuanRouJiaMo();

        } else if (type.equals("Tian"))
        {
            rouJiaMo = new TianRouJiaMo();
        } else if (type.equals("La"))
        {
            rouJiaMo = new LaRouJiaMo();
        }
        return rouJiaMo;
    }

}