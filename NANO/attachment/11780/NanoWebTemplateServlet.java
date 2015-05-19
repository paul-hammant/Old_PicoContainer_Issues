package org.nanocontainer.nanoweb;

import groovy.lang.Binding;
import groovy.servlet.TemplateServlet;
import groovy.text.Template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NanoWebTemplateServlet extends TemplateServlet  {
    protected Template handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Binding binding) throws Exception {
        binding.setVariable("action", httpServletRequest.getAttribute("action"));
        // if GROOVY-357 is accepted
        return super.handleRequest(httpServletRequest, httpServletResponse, binding);

//      // if GROOVY-357 is NOT accepted
//      String servletPath = NanoWebServlet.getServletPath(httpServletRequest);
//      return getTemplate(servletPath);
    }
}