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

import java.util.Date;

public class ServiceCall {
	private int id;
	private Date time;
	private Serviceable serviceUser;
/**
 * ServiceCall constructor comment.
 */
public ServiceCall() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (11/27/00 5:25:21 PM)
 * @return int
 */
public int getId() {
	return this.id;
}
/**
 * Insert the method's description here.
 * Creation date: (11/27/00 5:25:21 PM)
 * @return test.oracle.models.phone.Serviceable
 */
public Serviceable getServiceUser() {
	return this.serviceUser;
}
/**
 * 
 * @return java.util.Date
 */
public java.util.Date getTime() {
	return this.time;
}
/**
 * Insert the method's description here.
 * Creation date: (11/27/00 5:25:21 PM)
 * @param newId int
 */
public void setId(int newId) {
	this.id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (11/27/00 5:25:21 PM)
 * @param newServiceUser test.oracle.models.phone.Serviceable
 */
public void setServiceUser(Serviceable newServiceUser) {
	serviceUser = newServiceUser;
}
/**
 * 
 * @param newTime java.util.Date
 */
public void setTime(java.util.Date newTime) {
	this.time = newTime;
}
}
