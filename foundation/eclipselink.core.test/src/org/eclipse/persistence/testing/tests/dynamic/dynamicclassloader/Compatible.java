/*******************************************************************************
 * Copyright (c) 2011, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     dclarke - Dynamic Persistence
 *       http://wiki.eclipse.org/EclipseLink/Development/Dynamic
 *       (https://bugs.eclipse.org/bugs/show_bug.cgi?id=200045)
 *     mnorman - tweaks to work from Ant command-line,
 *               get database properties from System, etc.
 *
 ******************************************************************************/
package org.eclipse.persistence.testing.tests.dynamic.dynamicclassloader;

import org.eclipse.persistence.internal.dynamic.DynamicEntityImpl;
import org.eclipse.persistence.internal.dynamic.DynamicPropertiesManager;

/**
 * Test class - when created by a {@link DynamicClassLoader}, should <b>not</b> throw {@link IllegalArgumentException}
 * @author mnorman
 *
 */
public class Compatible extends DynamicEntityImpl {

    public static DynamicPropertiesManager DPM = new DynamicPropertiesManager();
    protected Compatible() {
        super();
    }

    @Override
    public DynamicPropertiesManager fetchPropertiesManager() {
        return DPM;
    }

}
