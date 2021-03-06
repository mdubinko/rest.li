/*
   Copyright (c) 2017 LinkedIn Corp.

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

package com.linkedin.restli.client.testutils;

import com.linkedin.r2.transport.common.Client;
import com.linkedin.restli.client.RestClient;


/**
 * A {@link RestClient} implementation that exposes the URI prefix for testing purposes.
 *
 * @author Sean Sheng
 */
public class PrefixAwareRestClient extends RestClient
{
  private final String _prefix;

  public PrefixAwareRestClient(Client client, String prefix)
  {
    super(client, prefix);
    _prefix = prefix;
  }

  /**
   * Gets the URI prefix associated with this {@link RestClient}.
   *
   * @return the URI prefix
   */
  public String getPrefix()
  {
    return _prefix;
  }
}
