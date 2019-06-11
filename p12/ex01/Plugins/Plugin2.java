package p12.ex01.Plugins;

import reflection.IPlugin;

public class Plugin2 implements IPlugin {

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("Sou o plugin 2!");
    }
}