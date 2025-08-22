package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.service.AIChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * 聊天机器人相关接口
 *
 * @author 闫政
 * @since 2025/8/18 17:20 星期一
 */
@RestController
@RequestMapping("/chatbot")
@RequiredArgsConstructor
@Tag(name = "聊天机器人相关接口")
public class AIChatController {

    private final AIChatService aiChatService;

    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "AI 聊天")
    public Flux<String> chat(@RequestBody String question
            , @RequestAttribute String loginUserId
            , @RequestParam String conversationId
            , @RequestParam(required = false) String modelName) {
        return aiChatService.chat(question, conversationId, modelName, loginUserId);
    }
}
