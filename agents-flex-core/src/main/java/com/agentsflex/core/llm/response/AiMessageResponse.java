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
package com.agentsflex.core.llm.response;

import com.agentsflex.core.message.AiMessage;

public class AiMessageResponse extends AbstractBaseMessageResponse<AiMessage> {
    private AiMessage aiMessage;

    public AiMessageResponse(AiMessage aiMessage) {
        this.aiMessage = aiMessage;
    }

    @Override
    public AiMessage getMessage() {
        return aiMessage;
    }

    @Override
    public String toString() {
        return "AiMessageResponse{" +
            "aiMessage=" + aiMessage +
            ", isError=" + error +
            ", errorMessage='" + errorMessage + '\'' +
            ", errorType='" + errorType + '\'' +
            ", errorCode='" + errorCode + '\'' +
            '}';
    }
}
