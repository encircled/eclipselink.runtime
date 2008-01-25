/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.models.complexinheritance;

import org.eclipse.persistence.tools.schemaframework.TableDefinition;

public class Bus extends FueledVehicle {
	public Person busDriver;
public static Bus example2(Company company)
{
	Bus example = new Bus();
	
	example.setPassengerCapacity(new Integer(30));
	example.setFuelCapacity(new Integer(100));
	example.setDescription("SCHOOL BUS");
	example.setFuelType("Petrol");
	example.getOwner().setValue(company);
	example.addPartNumber("188298SU-k");
	example.addPartNumber("199211HI-x");
	example.addPartNumber("023392SY-x");
	example.addPartNumber("002345DP-s");
	return example;
}
public static Bus example3(Company company)
{
	Bus example = new Bus();
	
	example.setPassengerCapacity(new Integer(30));
	example.setFuelCapacity(new Integer(100));
	example.setDescription("TOUR BUS");
	example.setFuelType("Petrol");
	example.getOwner().setValue(company);
	example.addPartNumber("188298SU-k");
	example.addPartNumber("199211HI-x");
	example.addPartNumber("023392SY-x");
	example.addPartNumber("002345DP-s");
	return example;
}
public static Bus example4(Company company)
{
	Bus example = new Bus();
	
	example.setPassengerCapacity(new Integer(30));
	example.setFuelCapacity(new Integer(100));
	example.setDescription("TRANSIT BUS");
	example.setFuelType("Gas");
	example.getOwner().setValue(company);
	example.addPartNumber("188298SU-k");
	example.addPartNumber("199211HI-x");
	example.addPartNumber("023392SY-x");
	example.addPartNumber("002345DP-s");
	return example;
}
/**
 * Return a platform independant definition of the database table.
 */

public static TableDefinition tableDefinition()
{
	TableDefinition definition = new TableDefinition();

	definition.setName("BUS");

	definition.addField("ID", java.math.BigDecimal.class, 15);
	definition.addField("DESCRIP", String.class, 30);
	definition.addField("DRIVER_ID", java.math.BigDecimal.class, 15);

	return definition;
}
}
