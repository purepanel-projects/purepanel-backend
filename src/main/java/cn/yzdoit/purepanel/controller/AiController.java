package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.res.AiChatRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * AI 相关接口
 *
 * @author 闫政
 * @since 2025/8/18 17:20 星期一
 */
@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiController {

    private final ChatClient chatClient;

    @GetMapping("/chat")
    @Operation(summary = "聊天")
    public SseEmitter chat(@RequestParam String question, @RequestParam String conversationId) {
        SseEmitter sseEmitter = new SseEmitter(0L);
        chatClient.prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .user(question)
                .stream()
                .content()
                .subscribe(chunk -> {
                    try {
                        sseEmitter.send(AiChatRes.builder()
                                .content(chunk)
                                .build());
                    } catch (Exception e) {
                        sseEmitter.complete();
                    }
                }, throwable -> {
                    throw new RuntimeException(throwable);
                }, () -> {
                    sseEmitter.complete();
                });
        return sseEmitter;
    }
}
