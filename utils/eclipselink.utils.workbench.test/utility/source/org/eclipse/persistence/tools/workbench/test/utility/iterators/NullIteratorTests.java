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

import org.eclipse.persistence.tools.workbench.utility.iterators.NullIterator;

public class NullIteratorTests extends TestCase {
	
	public static void main(String[] args) {
		TestRunner.main(new String[] {"-c", NullIteratorTests.class.getName()});
	}
	
	public static Test suite() {
		return new TestSuite(NullIteratorTests.class);
	}
	
	public NullIteratorTests(String name) {
		super(name);
	}
	
	public void testHasNext() {
		int i = 0;
		for (Iterator stream = NullIterator.instance(); stream.hasNext(); ) {
			stream.next();
			i++;
		}
		assertEquals(0, i);
	}
	
	public void testNext() {
		for (Iterator stream = NullIterator.instance(); stream.hasNext(); ) {
			fail("bogus element: " + stream.next());
		}
	}
	
	public void testNoSuchElementException() {
		boolean exCaught = false;
		Iterator stream = NullIterator.instance();
		Object element = null;
		while (stream.hasNext()) {
			element = stream.next();
		}
		try {
			element = stream.next();
		} catch (NoSuchElementException ex) {
			exCaught = true;
		}
		assertTrue("NoSuchElementException not thrown: " + element, exCaught);
	}
	
	public void testUnsupportedOperationException() {
		boolean exCaught = false;
		try {
			NullIterator.instance().remove();
		} catch (UnsupportedOperationException ex) {
			exCaught = true;
		}
		assertTrue("UnsupportedOperationException not thrown", exCaught);
	}
	
}
