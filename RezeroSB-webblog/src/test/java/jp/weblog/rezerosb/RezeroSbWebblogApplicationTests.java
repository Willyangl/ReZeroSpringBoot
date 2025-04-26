package jp.weblog.rezerosb;


import com.fasterxml.jackson.databind.ObjectMapper;
import jp.weblog.rezerosb.controller.UserController;
import jp.weblog.rezerosb.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
class RezeroSbWebblogApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testRegister() throws Exception {
		// テストデータ
		String username = "testusertest";
		String password = "testpasswordtes";

		// リクエストを送信して結果を検証
		String resultJson = mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
						.param("username", username)
						.param("password", password))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString(StandardCharsets.UTF_8); // UTF-8 エンコーディング指定

		// Resultオブジェクトに変換
		Result<?> result = objectMapper.readValue(resultJson, Result.class);

		// 検証
		Assertions.assertEquals(0, result.getCode()); // 成功コード
		Assertions.assertEquals("操作完了", result.getMessage()); // メッセージ
		Assertions.assertNull(result.getData()); // データが不要な場合はnull
	}
}
