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
package pt.ist.fenixWebFramework.rendererExtensions.validators;

import pt.ist.fenixWebFramework.renderers.validators.EmailValidator;
import pt.ist.fenixWebFramework.renderers.validators.HtmlChainValidator;

public class RequiredEmailValidator extends EmailValidator {

    public RequiredEmailValidator() {
        super();
    }

    public RequiredEmailValidator(HtmlChainValidator htmlChainValidator) {
        super(htmlChainValidator);
    }

    @Override
    public void performValidation() {
        final String email = getComponent().getValue();
        if (email != null && email.length() > 0) {
            super.performValidation();
        } else {
            setValid(false);
            setMessage("renderers.validator.required");
        }
    }

}
