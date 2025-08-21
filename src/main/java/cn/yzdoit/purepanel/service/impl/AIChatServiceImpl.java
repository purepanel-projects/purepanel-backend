package cn.yzdoit.purepanel.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.yzdoit.purepanel.service.AIChatService;
import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 聊天机器人相关服务
 *
 * @author 闫政
 * @since 2025/8/21 10:13 星期四
 */
@Service
@RequiredArgsConstructor
public class AIChatServiceImpl implements AIChatService {

    private final ChatClient chatClient;

    /**
     * AI 聊天
     *
     * @param question       问题
     * @param conversationId 会话ID
     * @param modelName      模型名称
     * @return Flux 流式结果
     */
    @Override
    public Flux<String> chat(String question, String conversationId, String modelName) {

        //支持的模型名称
        Set<String> supportModeNameSet = Arrays.stream(DashScopeApi.ChatModel.values())
                .map(DashScopeApi.ChatModel::getValue).collect(Collectors.toSet());

        //模型名称为空时，使用默认模型
        if (StrUtil.isBlank(modelName)) {
            modelName = DashScopeApi.ChatModel.QWEN_PLUS.getName();
        } else if (!supportModeNameSet.contains(modelName)) {
            return Flux.just("不支持的模型");
        }

        return chatClient.prompt()
                .options(DashScopeChatOptions.builder()
                        .withModel(modelName)
                        .build())
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .user(question)
                .stream()
                .content();
    }
}
