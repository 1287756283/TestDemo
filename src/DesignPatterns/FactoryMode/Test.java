package DesignPatterns.FactoryMode;

import DesignPatterns.FactoryMode.AbStractDomin.RouJiaMo;

public class Test {
    public static void main(String[] args) {
        XiAnRoujiamoStore xiAnRoujiamoStore = new XiAnRoujiamoStore();
        RouJiaMo la = xiAnRoujiamoStore.sellRouJiaMo("La");
        System.out.println(la);
    }
}
