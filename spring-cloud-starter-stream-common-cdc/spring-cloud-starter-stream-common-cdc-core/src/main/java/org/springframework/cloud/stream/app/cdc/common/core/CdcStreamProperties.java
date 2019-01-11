/*
 * Copyright 2019 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.cdc.common.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Christian Tzolov
 */
@ConfigurationProperties("cdc.stream")
@Validated
public class CdcStreamProperties {

	/**
	 * Control what information to be serialized in the outbound message headers.
	 */
	private Header header = new Header();

	public Header getHeader() {
		return header;
	}

	public static class Header {

		/**
		 * When true the source record's offset metadata is serialized into the outbound message header under cdc.offset.
		 */
		private boolean offset = false;

		/**
		 * When true the source record's key data is serialized into the outbound message header under cdc.key.
		 */
		private boolean key = false;

		public boolean isOffset() {
			return offset;
		}

		public void setOffset(boolean offset) {
			this.offset = offset;
		}

		public boolean isKey() {
			return key;
		}

		public void setKey(boolean key) {
			this.key = key;
		}
	}
}
