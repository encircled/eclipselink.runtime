/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.models.phone;

public class EmailAddress implements Contact {
	int id;
	String address;
/**
 * EmailAddress constructor comment.
 */
public EmailAddress() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (6/1/00 2:56:36 PM)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (6/1/00 2:56:36 PM)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (6/1/00 2:56:36 PM)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (6/1/00 2:56:36 PM)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
}
