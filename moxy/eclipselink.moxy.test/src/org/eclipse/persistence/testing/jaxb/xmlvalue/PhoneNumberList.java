/*******************************************************************************
 * Copyright (c) 1998, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.xmlvalue;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="phone")
@XmlType(name="phone-number")
public class PhoneNumberList {

    @XmlTransient
    public String someTransientThing;

    @XmlValue
    @XmlList
    public java.util.ArrayList<String> numbers;

    public boolean equals(Object o) {
        if(!(o instanceof PhoneNumberList) || o == null) {
            return false;
        } else {
            return ((PhoneNumberList)o).numbers.equals(this.numbers);
        }
    }

    public String toString() {
        return "EMPLOYEE(" + numbers + ")";
    }
}
