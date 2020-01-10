package org.apache.maven.shared.io.scan;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id: SimpleResourceInclusionScanner.java 595935 2007-11-17 11:39:34Z vsiveton $
 */
public class SimpleResourceInclusionScanner
    extends AbstractResourceInclusionScanner
{
    private Set sourceIncludes;

    private Set sourceExcludes;

    public SimpleResourceInclusionScanner( Set sourceIncludes, Set sourceExcludes )
    {
        this.sourceIncludes = sourceIncludes;

        this.sourceExcludes = sourceExcludes;
    }

    public Set getIncludedSources( File sourceDir, File targetDir )
        throws InclusionScanException
    {
        List srcMappings = getSourceMappings();

        if ( srcMappings.isEmpty() )
        {
            return Collections.EMPTY_SET;
        }

        return Collections.singleton( scanForSources( sourceDir, sourceIncludes, sourceExcludes ) );
    }
}
