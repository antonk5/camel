/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.flatpack;

import org.apache.camel.Converter;

import java.util.Map;
import java.util.HashMap;

import net.sf.flatpack.DataSet;

/**
 * @version $Revision: 1.1 $
 */
@Converter
public class FlatpackConverter {
    @Converter
    public static Map toMap(DataSet dataSet) {
        Map<String,Object> map = new HashMap<String, Object>();
        putValues(map, dataSet);
        return map;
    }

    /**
     * Puts the values of the dataset into the map
     * @param map
     * @param dataSet
     */
    public static void putValues(Map<String, Object> map, DataSet dataSet) {
        String[] columns = dataSet.getColumns();
        for (String column : columns) {
            // TODO deal with non-string types?
            String value = dataSet.getString(column);
            map.put(column, value);
        }
    }
}
