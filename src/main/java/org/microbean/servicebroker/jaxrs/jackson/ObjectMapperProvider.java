/* -*- mode: Java; c-basic-offset: 2; indent-tabs-mode: nil; coding: utf-8-unix -*-
 *
 * Copyright © 2017 MicroBean.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.microbean.servicebroker.jaxrs.jackson;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

  protected final ObjectMapper objectMapper;
  
  public ObjectMapperProvider() {
    super();
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    this.objectMapper = objectMapper;
  }

  @Override
  public ObjectMapper getContext(final Class<?> type) {
    final String cn = this.getClass().getName();
    final String mn = "getContext";
    final Logger logger = Logger.getLogger(cn);
    assert logger != null;
    if (logger.isLoggable(Level.FINER)) {
      logger.entering(cn, mn, type);
      logger.exiting(cn, mn, this.objectMapper);
    }
    return this.objectMapper;
  }

}
