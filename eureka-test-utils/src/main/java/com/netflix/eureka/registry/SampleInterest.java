/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.eureka.registry;

import com.netflix.eureka.interests.Interest;
import com.netflix.eureka.interests.Interests;

/**
 * @author Tomasz Bak
 */
public enum SampleInterest {

    ZuulVip() {
        @Override
        public Interest<InstanceInfo> build() {
            return Interests.forVip("zuul.addr:7001");
        }
    },
    ZuulApp() {
        @Override
        public Interest<InstanceInfo> build() {
            return Interests.forApplication("zuul001");
        }
    },
    DiscoveryApp() {
        @Override
        public Interest<InstanceInfo> build() {
            return Interests.forApplication("discovery001");
        }
    },
    MultipleApps() {
        @Override
        public Interest<InstanceInfo> build() {
            return Interests.forSome(ZuulApp.build(), DiscoveryApp.build());
        }
    };

    public abstract Interest<InstanceInfo> build();
}
