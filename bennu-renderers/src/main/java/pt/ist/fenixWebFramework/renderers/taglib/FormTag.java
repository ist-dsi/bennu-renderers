/**
 * Copyright © 2008 Instituto Superior Técnico
 *
 * This file is part of Bennu Renderers Framework.
 *
 * Bennu Renderers Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bennu Renderers Framework is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Bennu Renderers Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ist.fenixWebFramework.renderers.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import pt.ist.fenixWebFramework.renderers.utils.RenderUtils;

public class FormTag extends ContextTag {

    private String action;
    private String target;
    private String encoding;
    private boolean confirmationNeeded;
    private String bundle;
    private String titleKey;
    private String messageKey;
    private String okKey;
    private String cancelKey;
    private String formId;
    private String style;

    public boolean isConfirmationNeeded() {
        return confirmationNeeded;
    }

    public void setConfirmationNeeded(boolean confirmationNeeded) {
        this.confirmationNeeded = confirmationNeeded;
    }

    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getOkKey() {
        return okKey;
    }

    public void setOkKey(String okKey) {
        this.okKey = okKey;
    }

    public String getCancelKey() {
        return cancelKey;
    }

    public void setCancelKey(String cancelKey) {
        this.cancelKey = cancelKey;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public int doStartTag() throws JspException {
        writeStartForm();

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        super.doEndTag();
        writeEndForm();

        return EVAL_PAGE;
    }

    private void writeStartForm() throws JspException {
        StringBuilder formHead = new StringBuilder();

        if (isConfirmationNeeded()) {

            String path = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
            formHead.append("<script type=\"text/javascript\" src=\"");
            formHead.append(path);
            formHead.append("/bennu-renderers/js/jquery.ui.draggable.js\"></script>\n");
            formHead.append("<script type=\"text/javascript\" src=\"");
            formHead.append(path);
            formHead.append("/bennu-renderers/js/jquery.alerts.js\"></script>\n");
            formHead.append("<script type=\"text/javascript\" src=\"");
            formHead.append(path);
            formHead.append("/bennu-renderers/js/alertHandlers.js\"></script>\n");
        }

        formHead.append("<form ");
        if (getId() != null) {
            formId = getId();
            formHead.append("id=\"" + getId() + "\" ");
        }

        if (getAction() != null) {
            String path = RenderUtils.getModuleRelativePath(getAction());
            formHead.append("action=\"" + path + "\" ");
        }

        if (getEncoding() != null) {
            formHead.append("enctype=\"" + getEncoding() + "\" ");
        }

        if (getTarget() != null) {
            formHead.append("target=\"" + getTarget() + "\" ");
        }

        if (getStyle() != null) {
            formHead.append("style=\"" + getStyle() + "\" ");
        }

        formHead.append("method=\"post\" class='form-horizontal'>\n");
        try {
            pageContext.getOut().write(formHead.toString());
        } catch (IOException e) {
            throw new JspException("could not generate form");
        }
    }

    private void writeEndForm() throws JspException {
        StringBuilder formTail = new StringBuilder();

        if (isConfirmationNeeded()) {
            formTail.append("<input class=\"inputbutton\" type=\"button\" value=\"");
            formTail.append(RenderUtils.getResourceString("RENDERER_RESOURCES", "renderers.form.submit.name"));
            formTail.append("\" onClick=\"requestConfirmation('");
            formTail.append(formId);
            formTail.append("','");
            formTail.append(RenderUtils.getResourceString(getBundle(), getTitleKey()));
            formTail.append("','");
            formTail.append(RenderUtils.getResourceString(getBundle(), getMessageKey()));
            formTail.append("');\"/>");
        }
        formTail.append("</form>");
        try {
            pageContext.getOut().write(formTail.toString());
        } catch (IOException e) {
            throw new JspException("could not generate form");
        }
    }

}
