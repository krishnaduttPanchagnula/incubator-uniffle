/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.uniffle.common.metrics;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;

public abstract class NettyMetrics extends RPCMetrics {

  private static final String NETTY_ACTIVE_CONNECTION = "netty_active_connection";
  private static final String NETTY_HANDLE_EXCEPTION = "netty_handle_exception";

  protected Gauge.Child gaugeNettyActiveConn;
  protected Counter.Child counterNettyException;

  public NettyMetrics(String tags) {
    super(tags);
  }

  @Override
  public void registerGeneralMetrics() {
    gaugeNettyActiveConn = metricsManager.addLabeledGauge(NETTY_ACTIVE_CONNECTION);
    counterNettyException = metricsManager.addLabeledCounter(NETTY_HANDLE_EXCEPTION);
  }

  public Counter.Child getCounterNettyException() {
    return counterNettyException;
  }

  public Gauge.Child getGaugeNettyActiveConn() {
    return gaugeNettyActiveConn;
  }
}
