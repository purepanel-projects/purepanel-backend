package cn.yzdoit.purepanel.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
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
    public SseEmitter chat(@RequestParam String question) {
        SseEmitter sseEmitter = new SseEmitter(0L);
        System.out.println();
        chatClient.prompt()
                .user(question)
                .stream()
                .content()
                .subscribe(System.out::print);
        return sseEmitter;
    }
}
