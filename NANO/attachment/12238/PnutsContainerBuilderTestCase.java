package org.nanocontainer.script.pnuts;

import java.io.Reader;
import java.io.StringReader;
import org.nanocontainer.script.AbstractScriptedContainerBuilderTestCase;
import org.picocontainer.PicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;

public class PnutsContainerBuilderTestCase extends AbstractScriptedContainerBuilderTestCase {

    public void testContainerBuilderCanBeBuildWithParent() {
        Reader script = new StringReader("" +
                "pico = class org.picocontainer.defaults.DefaultPicoContainer(parent)\n" +
                "pico.registerComponentInstance(\"hello\", \"Pnuts\")\n");
        PicoContainer parent = new DefaultPicoContainer();
        PicoContainer pico = buildContainer(new PnutsContainerBuilder(script, getClass().getClassLoader()), parent);
        assertSame(parent, pico.getParent());
        assertEquals("Pnuts", pico.getComponentInstance("hello"));
    }
}
