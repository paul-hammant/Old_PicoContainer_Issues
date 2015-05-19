package org.nanocontainer.script.pnuts;

import java.io.Reader;
import org.nanocontainer.script.ScriptedContainerBuilder;
import org.picocontainer.PicoContainer;
import pnuts.lang.Context;
import pnuts.lang.Package;
import pnuts.lang.Pnuts;

public class PnutsContainerBuilder extends ScriptedContainerBuilder {

    public PnutsContainerBuilder(Reader script, ClassLoader classLoader) {
        super(script, classLoader);
    }

    protected PicoContainer createContainerFromScript(PicoContainer parentContainer, Object assemblyScope) {
        Package pkg = new Package(null, null);
        Context context = new Context(pkg);

        pkg.set("parent".intern(), parentContainer, context);
        pkg.set("assemblyScope".intern(), assemblyScope, context);

        context.setClassLoader(classLoader);

        Object result = Pnuts.load(script, context);
        Object pico = pkg.get("pico".intern(), context);
        if (pico == null) {
            pico = result;
        }
        return (PicoContainer) pico;
    }
}
