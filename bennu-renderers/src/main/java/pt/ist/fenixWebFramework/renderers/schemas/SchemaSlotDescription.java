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
package pt.ist.fenixWebFramework.renderers.schemas;

import java.util.List;
import java.util.Properties;

import pt.ist.fenixWebFramework.renderers.components.converters.Converter;
import pt.ist.fenixWebFramework.renderers.validators.ValidatorProperties;

public class SchemaSlotDescription {

    private String slotName;

    private String layout;
    private String schema;
    private Properties properties;

    private String bundle;
    private String key;
    private String arg0;

    private Class<Converter> converter;

    private List<ValidatorProperties> validators;

    private String defaultValue;

    private boolean readOnly;
    private boolean hidden;
    private boolean setterIgnored;

    private String description;
    private String descriptionFormat;

    private String helpLabel;

    public SchemaSlotDescription(String slotName) {
        this.slotName = slotName;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Class<Converter> getConverter() {
        return this.converter;
    }

    public void setConverter(Class<Converter> converter) {
        this.converter = converter;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isSetterIgnored() {
        return this.setterIgnored;
    }

    public void setSetterIgnored(boolean setterIgnored) {
        this.setterIgnored = setterIgnored;
    }

    public List<ValidatorProperties> getValidators() {
        return validators;
    }

    public void setValidators(List<ValidatorProperties> validators) {
        this.validators = validators;
    }

    public String getHelpLabel() {
        return helpLabel;
    }

    public void setHelpLabel(String helpLabel) {
        this.helpLabel = helpLabel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionFormat() {
        return descriptionFormat;
    }

    public void setDescriptionFormat(String descriptionFormat) {
        this.descriptionFormat = descriptionFormat;
    }
}