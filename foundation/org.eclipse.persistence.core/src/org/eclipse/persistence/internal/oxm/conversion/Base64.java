/*******************************************************************************
 * Copyright (c) 1998, 2016  -2014 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.internal.oxm.conversion;

/**
 * INTERNAL:
 * <p><b>Purpose</b>: Convert to/from XML base64Binary.</p>
 */

public class Base64 {

    /**
     * Base64 constructor comment.
     */
    private Base64() {
    }

    /**
     * base64Binary data is likely to be long, and decoding requires
     * each character to be accessed twice (once for counting length, another
     * for decoding.)
     *
     * This method decodes the given byte[] using the java.util.Base64
     *
     * @param  data the base64-encoded data.
     * @return the decoded <var>data</var>.
     */
    public static byte[] base64Decode(byte[] data) {
        return java.util.Base64.getMimeDecoder().decode(data);
    }

    /**
     * This method encodes the given byte[] using java.util.Base64
     *
     * @param  data the data
     * @return the base64-encoded <var>data</var>
     */
    public static byte[] base64Encode(byte[] data) {
        return java.util.Base64.getEncoder().encode(data);
    }
}
