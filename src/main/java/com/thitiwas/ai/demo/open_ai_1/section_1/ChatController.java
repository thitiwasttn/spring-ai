package com.thitiwas.ai.demo.open_ai_1.section_1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient openAi;

    private final ChatClient claude;

    public ChatController(@Qualifier("openAiChatClient") ChatClient chatClient,
            @Qualifier("claudeChatClient") ChatClient claude) {
        this.openAi = chatClient;
        this.claude = claude;
    }

    @GetMapping("/chat/open-ai")
    public String openAi(@RequestParam("message") String message) {
        return openAi.prompt(message).call().content();
    }

    @GetMapping("/chat/claude")
    public String claude(@RequestParam("message") String message) {
        return claude.prompt(message).call().content();
    }
}
