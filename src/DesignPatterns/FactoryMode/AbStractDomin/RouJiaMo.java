package DesignPatterns.FactoryMode.AbStractDomin;

public abstract class RouJiaMo
{
    protected String name;

    /**
     * 准备工作
     */
    public void prepare()
    {
        System.out.println(name+"--揉面-剁肉-完成准备工作");
    }

    /**
     * 使用你们的专用袋-包装
     */
    public void pack()
    {
        System.out.println(name+"--肉夹馍-专用袋-包装");
    }
    /**
     * 秘制设备-烘烤2分钟
     */
    public void fire()
    {
        System.out.println(name+"--肉夹馍-专用设备-烘烤");
    }
}