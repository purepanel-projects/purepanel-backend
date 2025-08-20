package cn.yzdoit.purepanel.config;

import cn.yzdoit.purepanel.ai.AiTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AI 配置
 *
 * @author 闫政
 * @since 2025/8/18 16:41 星期一
 */
@Configuration
@RequiredArgsConstructor
public class AiConfig {

    private final AiTools aiTools;

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultSystem("你是一个博学的智能聊天助手，请根据用户提问回答！")
                .defaultTools(aiTools)
                .build();
    }
}
