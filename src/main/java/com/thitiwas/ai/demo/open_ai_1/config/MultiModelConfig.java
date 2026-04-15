package com.thitiwas.ai.demo.open_ai_1.config;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiModelConfig {

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        ChatClient.Builder builder = ChatClient.builder(openAiChatModel);
        return builder.build();
    }

    @Bean
    public ChatClient claudeChatClient(AnthropicChatModel anthropicChatModel) {
        ChatClient.Builder builder = ChatClient.builder(anthropicChatModel);
        return builder.build();
    }
}
