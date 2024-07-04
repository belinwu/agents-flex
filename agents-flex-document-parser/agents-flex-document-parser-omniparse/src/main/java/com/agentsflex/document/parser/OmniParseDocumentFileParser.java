/*
 *  Copyright (c) 2023-2025, Agents-Flex (fuhai999@gmail.com).
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  <p>
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.agentsflex.document.parser;

import com.agentsflex.core.document.Document;
import com.agentsflex.core.document.parser.AbstractFileParser;
import com.agentsflex.core.llm.client.HttpClient;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * https://docs.cognitivelab.in/api
 */
public class OmniParseDocumentFileParser extends AbstractFileParser {

    private OmniParseConfig config;
    private HttpClient httpClient = new HttpClient();


    public OmniParseDocumentFileParser(OmniParseConfig config) {
        this.config = config;
    }

    @Override
    public Document parse(File file) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(file.getName(), file);

        String url = config.getEndpoint();
        if (Util.isImageFile(file.getName())) {
            url += "/parse_image/image";
        } else {
            url += "/parse_document";
        }

        String response = httpClient.multipartString(url, null, payload);
        return Document.of(response);
    }


}
