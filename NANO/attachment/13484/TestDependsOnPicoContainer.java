/*
 * Copyright (c) 2004 Your Corporation. All Rights Reserved.
 */
package org.nanocontainer.testmodel;

import org.picocontainer.PicoContainer;

public class TestDependsOnPicoContainer {

    private PicoContainer pico;

    public TestDependsOnPicoContainer(PicoContainer pico) {
        this.pico = pico;
    }
}
