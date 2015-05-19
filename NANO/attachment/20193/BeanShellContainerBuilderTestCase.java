/*****************************************************************************
 * Copyright (C) NanoContainer Organization. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *                                                                           *
 * Original code by                                                          *
 *****************************************************************************/
/**
 * @author Aslak Helles&oslash;y
 * @version $Revision: 1629 $
 */
package org.nanocontainer.script.bsh;

import org.nanocontainer.script.AbstractScriptedContainerBuilderTestCase;
import org.picocontainer.PicoContainer;
import org.picocontainer.defaults.DefaultPicoContainer;

import java.io.Reader;
import java.io.StringReader;

/**
 * @author Aslak Helles&oslash;y
 * @version $Revision: 1629 $
 */
public class BeanShellContainerBuilderTestCase extends AbstractScriptedContainerBuilderTestCase {

    public void testContainerCanBeBuiltWithParent() {
        Reader script = new StringReader("" +
                "pico = new org.nanocontainer.reflection.DefaultNanoPicoContainer(parent);\n" +
                "pico.registerComponentInstance(\"hello\", \"BeanShell\");\n");
        PicoContainer parent = new DefaultPicoContainer();
        PicoContainer pico = buildContainer(new BeanShellContainerBuilder(script, getClass().getClassLoader()), parent, "SOME_SCOPE");
        //PicoContainer.getParent() is now ImmutablePicoContainer
        assertNotSame(parent, pico.getParent());
        assertEquals("BeanShell", pico.getComponentInstance("hello"));
    }

    public void testBuildTwoContainerWithOneBuilderInstance() {
        Reader script = new StringReader("" +
                "pico = new org.nanocontainer.reflection.DefaultNanoPicoContainer(parent);\n" +
                "pico.registerComponentInstance(\"hello\", \"BeanShell\");\n");
        PicoContainer parent = new DefaultPicoContainer();
        BeanShellContainerBuilder builder = new BeanShellContainerBuilder(script, getClass().getClassLoader());
        PicoContainer pico = buildContainer(builder, parent, "SOME_SCOPE");
        assertNotNull(pico);

        PicoContainer pico2 = buildContainer(builder, parent, "SOME_SCOPE");
	assertNotNull(pico2);
   }

}
