package cn.yzdoit.purepanel.config;

import cn.yzdoit.purepanel.ai.AiTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
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
    public ChatClient chatClient(ZhiPuAiChatModel zhiPuAiChatModel) {
        return ChatClient.builder(zhiPuAiChatModel)
                .defaultTools(aiTools)
                .build();
    }
}
