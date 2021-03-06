/*
 * Copyright 2013 Peter Lawrey
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

import net.openhft.lang.io.Bytes;


public enum Alignment {
    NO_ALIGNMENT {
        @Override
        void alignPositionAddr(Bytes bytes) {
            // no-op
        }

        @Override
        long alignAddr(long addr) {
            return addr;
        }

        @Override
        int alignSize(int size) {
            return size;
        }
    },

    OF_4_BYTES {
        @Override
        void alignPositionAddr(Bytes bytes) {
            bytes.alignPositionAddr(4);
        }

        @Override
        long alignAddr(long addr) {
            return (addr + 3) & ~3;
        }

        @Override
        int alignSize(int size) {
            return (size + 3) & ~3;
        }
    },

    OF_8_BYTES {
        @Override
        void alignPositionAddr(Bytes bytes) {
            bytes.alignPositionAddr(8);
        }

        @Override
        long alignAddr(long addr) {
            return (addr + 7) & ~7;
        }

        @Override
        int alignSize(int size) {
            return (size + 7) & ~7;
        }
    };

    private static final Alignment[] VALUES = values();

    static Alignment fromOrdinal(int ordinal) {
        return VALUES[ordinal];
    }

    abstract void alignPositionAddr(Bytes bytes);

    abstract long alignAddr(long addr);

    abstract int alignSize(int size);
}
