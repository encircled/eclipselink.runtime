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
package org.eclipse.persistence.testing.oxm.inheritance.typetests;

public class Employee {
    private Address address;

    public Employee() {
    }

    public void setAddress(Address theAddress) {
        this.address = theAddress;
    }

    public Address getAddress() {
        return address;
    }

    public boolean equals(Object theEmployee) {
        if (theEmployee instanceof Employee) {
            return address.equals(((Employee)theEmployee).getAddress());
        }
        return false;
    }

    public String toString() {
        return "Employee: " + address.toString();
    }
}
