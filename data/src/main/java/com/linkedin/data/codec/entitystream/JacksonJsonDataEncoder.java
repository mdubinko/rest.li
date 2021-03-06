/*
   Copyright (c) 2018 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.linkedin.data.codec.entitystream;

import com.linkedin.data.ByteString;
import com.linkedin.data.DataList;
import com.linkedin.data.DataMap;
import com.linkedin.entitystream.WriteHandle;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;


/**
 * An JSON encoder for a {@link com.linkedin.data.DataComplex} object implemented as a {@link com.linkedin.entitystream.Writer}
 * writing to an {@link com.linkedin.entitystream.EntityStream} of {@link ByteString}. The implementation is backed by
 * Jackson's {@link JsonGenerator}. The <code>JsonGenerator</code> writes to an internal non-blocking <code>OutputStream</code>
 * implementation that has a fixed-size primary buffer and an unbounded overflow buffer. Because the bytes are pulled
 * from the encoder asynchronously, it needs to keep the state in a stack.
 *
 * @author Xiao Ma
 */
public class JacksonJsonDataEncoder extends AbstractJacksonDataEncoder implements JsonDataEncoder
{
  protected static final JsonFactory JSON_FACTORY = new JsonFactory();

  public JacksonJsonDataEncoder(DataMap dataMap, int bufferSize)
  {
    super(JSON_FACTORY, dataMap, bufferSize);
  }

  public JacksonJsonDataEncoder(DataList dataList, int bufferSize)
  {
    super(JSON_FACTORY, dataList, bufferSize);
  }
}
