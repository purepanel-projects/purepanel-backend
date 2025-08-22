package cn.yzdoit.purepanel.service;

import reactor.core.publisher.Flux;

/**
 * 聊天机器人相关服务
 *
 * @author 闫政
 * @since 2025/8/21 10:11 星期四
 */
public interface AIChatService {

    /**
     * AI 聊天
     *
     * @param question       问题
     * @param conversationId 会话ID
     * @param modelName      模型名称
     * @param userId         用户ID
     * @return Flux 流式结果
     */
    Flux<String> chat(String question, String conversationId, String modelName, String userId);

}
