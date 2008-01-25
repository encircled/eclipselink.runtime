/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.utility.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.swingui.TestRunner;

import org.eclipse.persistence.tools.workbench.utility.iterators.SingleElementIterator;

public class SingleElementIteratorTests extends TestCase {

	public static void main(String[] args) {
		TestRunner.main(new String[] {"-c", SingleElementIteratorTests.class.getName()});
	}
	
	public static Test suite() {
		return new TestSuite(SingleElementIteratorTests.class);
	}
	
	public SingleElementIteratorTests(String name) {
		super(name);
	}
	
	public void testHasNext() {
		int i = 0;
		for (Iterator stream = this.buildSingleElementIterator(); stream.hasNext(); ) {
			stream.next();
			i++;
		}
		assertEquals(1, i);
	}
	
	public void testNext() {
		for (Iterator stream = this.buildSingleElementIterator(); stream.hasNext(); ) {
			assertEquals("bogus element", this.singleElement(), stream.next());
		}
	}
	
	public void testNoSuchElementException() {
		boolean exCaught = false;
		Iterator stream = this.buildSingleElementIterator();
		String string = (String) stream.next();
		try {
			string = (String) stream.next();
		} catch (NoSuchElementException ex) {
			exCaught = true;
		}
		assertTrue("NoSuchElementException not thrown: " + string, exCaught);
	}
	
	public void testRemove() {
		boolean exCaught = false;
		for (Iterator stream = this.buildSingleElementIterator(); stream.hasNext(); ) {
			if (stream.next().equals(this.singleElement())) {
				try {
					stream.remove();
				} catch (UnsupportedOperationException ex) {
					exCaught = true;
				}
			}
		}
		assertTrue("UnsupportedOperationException not thrown", exCaught);
	}
	
	protected Iterator buildSingleElementIterator() {
		return new SingleElementIterator(this.singleElement());
	}

	protected Object singleElement() {
		return "single element";
	}	
}
