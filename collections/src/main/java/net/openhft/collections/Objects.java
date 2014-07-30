/*
 * Copyright 2014 Higher Frequency Trading
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.collections;

import net.openhft.lang.model.constraints.Nullable;

import java.util.Arrays;

/**
 * java.util.Objects since Java 7
 */
final class Objects {
    static int hash(Object... values) {
        return Arrays.hashCode(values);
    }

    static boolean equal(@Nullable Object a, @Nullable Object b) {
        return a != null ? a.equals(b) : b == null;
    }
}