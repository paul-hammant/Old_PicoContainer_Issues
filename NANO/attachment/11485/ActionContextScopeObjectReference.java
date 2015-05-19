package org.nanocontainer.webwork;

import org.picocontainer.defaults.ObjectReference;

import webwork.action.ActionContext;
/**
 * References an object that lives as an attribute of the
 * ServletRequest.
 *
 * @author <a href="mailto:joe@thoughtworks.net">Joe Walnes</a>
 */
public class ActionContextScopeObjectReference implements ObjectReference {

    private String key;

    public ActionContextScopeObjectReference(String key) {
        this.key = key;
    }

    public void set(Object item) {
        ActionContext.getContext().put(key, item);
    }

    public Object get() {
        return  ActionContext.getContext().get(key);
    }

}
