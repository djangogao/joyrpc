package io.joyrpc.cluster.discovery.registry.etcd;

/*-
 * #%L
 * joyrpc
 * %%
 * Copyright (C) 2019 joyrpc.io
 * %%
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
 * #L%
 */

import io.joyrpc.cluster.discovery.backup.Backup;
import io.joyrpc.cluster.discovery.registry.AbstractRegistryFactory;
import io.joyrpc.cluster.discovery.registry.Registry;
import io.joyrpc.extension.Extension;
import io.joyrpc.extension.URL;
import io.joyrpc.extension.condition.ConditionalOnClass;

/**
 * ETCD注册中心
 */
@Extension(value = "etcd")
@ConditionalOnClass("io.etcd.jetcd.Client")
public class EtcdRegistryFactory extends AbstractRegistryFactory {

    @Override
    protected Registry createRegistry(final String name, final URL url, final Backup backup) {
        return new EtcdRegistry(name, url, backup);
    }
}
